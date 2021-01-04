package com.test.payment.account.persistence.entity;

import com.test.payment.account.enums.AccountStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    @Convert(converter = AccountStatus.Mapper.class)
    private AccountStatus status;

    @Column(name = "error_id")
    private String errorId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public AccountEntity() {}

    public AccountEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
