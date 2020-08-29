package br.com.core.endpoint;

import br.com.core.error.ResourceNotFoundException;
import br.com.core.model.Client;
import br.com.core.model.Encrypt;
import br.com.core.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("clients")
public class ClientEndpoint {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientEndpoint(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    private Encrypt encrypt;

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/add-client")
    public ResponseEntity<?> save(@RequestBody Client client) {
        verifyIfEmailExists(client.getEmail());
        client.setPassword(encrypt.getHashMd5(client.getPassword()));
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody Client client) {
        Optional<Client> optionalClient = clientRepository.findOneByEmailAndPassword(
                client.getEmail(),
                encrypt.getHashMd5(client.getPassword()));
        if (optionalClient.isPresent()) {
            Client optionalClientFull = clientRepository.findByEmail(client.getEmail()).get();
            optionalClientFull.setAcessToken(encrypt.getHashMd5(client.getEmail() + client.getPassword() + new Date().getTime()));
            return new ResponseEntity<>(clientRepository.save(optionalClientFull), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Email or Password is wrong");
        }
    }

    private void verifyIfEmailExists(String email) {
        if (clientRepository.findByEmail(email).isPresent()) {
            throw new ResourceNotFoundException("There is already Client registered with this email: " + email);
        }
    }

}
