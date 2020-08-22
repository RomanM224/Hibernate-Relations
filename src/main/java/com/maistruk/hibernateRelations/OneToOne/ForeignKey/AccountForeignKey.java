package com.maistruk.hibernateRelations.OneToOne.ForeignKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_FOREIGN_KEY")
public class AccountForeignKey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    
    @OneToOne(mappedBy = "account")
    private EmployeeForeignKey employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeForeignKey getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeForeignKey employee) {
        this.employee = employee;
    }
    
    

}
