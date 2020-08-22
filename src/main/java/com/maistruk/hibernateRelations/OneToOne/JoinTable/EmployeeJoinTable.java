package com.maistruk.hibernateRelations.OneToOne.JoinTable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "EMPLOYEE_JOIN_TABLE")
public class EmployeeJoinTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="EMPLOYEE_ACCCOUNT", joinColumns = @JoinColumn (name="EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name="ACCOUNT_ID"))
    private AccountJoinTable account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountJoinTable getAccount() {
        return account;
    }

    public void setAccount(AccountJoinTable account) {
        this.account = account;
    }
    
    
}
