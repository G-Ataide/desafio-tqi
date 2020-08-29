package br.com.core.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Client extends AbstractEntity{
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @Nullable
    private String acessToken;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }
}
