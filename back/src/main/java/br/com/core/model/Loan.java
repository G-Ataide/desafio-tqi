package br.com.core.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "loan")
public class Loan extends AbstractEntity{
    @NotNull
    private Long client_id;

    @NotNull
    private String name;

    @NotNull
    private Long value;

    private String status;

    @NotNull
    private Timestamp ts_register;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Timestamp getTs_register() {
        return ts_register;
    }

    public void setTs_register(Timestamp ts_register) {
        this.ts_register = ts_register;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
