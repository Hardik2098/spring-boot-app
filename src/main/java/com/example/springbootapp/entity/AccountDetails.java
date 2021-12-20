package com.example.springbootapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Account_Details")
public class AccountDetails {

    @Id
    @Column(name = "ACCOUNT_NO")
    private String accountNo;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "BALANCE")
    private String balance;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
