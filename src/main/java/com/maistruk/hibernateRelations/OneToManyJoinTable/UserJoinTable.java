package com.maistruk.hibernateRelations.OneToManyJoinTable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_JOIN_TABLE")
public class UserJoinTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ADDRESS", joinColumns = {
            @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID") })
    private Set<AddressJoinTable> addresses;

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

    public Set<AddressJoinTable> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressJoinTable> addresses) {
        this.addresses = addresses;
    }

}
