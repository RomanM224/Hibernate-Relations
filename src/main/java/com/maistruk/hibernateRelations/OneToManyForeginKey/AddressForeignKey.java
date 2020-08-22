package com.maistruk.hibernateRelations.OneToManyForeginKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_FOREIGN_KEY")
public class AddressForeignKey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    
    @ManyToOne
    private UserForeignKey user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserForeignKey getUser() {
        return user;
    }

    public void setUser(UserForeignKey user) {
        this.user = user;
    }



}
