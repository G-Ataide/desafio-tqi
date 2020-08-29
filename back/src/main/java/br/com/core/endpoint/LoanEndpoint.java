package br.com.core.endpoint;

import br.com.core.error.ResourceNotFoundException;
import br.com.core.model.Client;
import br.com.core.model.Loan;
import br.com.core.repository.ClientRepository;
import br.com.core.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("loans")
public class LoanEndpoint {
    @Autowired
    private ClientRepository clientRepository;

    private final LoanRepository loanRepository;

    @Autowired
    public LoanEndpoint(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping(path = "/findByClientId/{id}")
    public ResponseEntity<?> listLoanByClientId(@PathVariable("id") Long id) {
        List<Loan> optionalLoan = loanRepository.findAllByClientId(id);
        if(!optionalLoan.isEmpty()){
            return new ResponseEntity<>(loanRepository.findAllByClientId(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Loan Not Found for this ClientId: "+ id.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add-loan")
    public ResponseEntity<?> save(@RequestBody Loan loan) {
        Client client = clientRepository.findOne(loan.getClient_id());
        if(client == null){
            throw new ResourceNotFoundException("ClientId not found");
        }else{
            loan.setStatus("PENDING_APROVATION");
            loan.setTs_register(new Timestamp(new Date().getTime()));
            return new ResponseEntity<>(loanRepository.save(loan), HttpStatus.CREATED);
        }
    }

}
