package com.maistruk.hibernateRelations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernateRelations.OneToManyForeginKey.AddressForeignKey;
import com.maistruk.hibernateRelations.OneToManyForeginKey.UserForeignKey;
import com.maistruk.hibernateRelations.OneToManyJoinTable.AddressJoinTable;
import com.maistruk.hibernateRelations.OneToManyJoinTable.UserJoinTable;

public class MainOneToMany {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserForeignKey.class).addAnnotatedClass(AddressForeignKey.class)
                .addAnnotatedClass(UserJoinTable.class).addAnnotatedClass(AddressJoinTable.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        saveWithForeignKeyOneToMany(sessionFactory);
        
        //saveWithJoinTableOneToMany(sessionFactory);
        
       
    }
    
    public static void saveWithForeignKeyOneToMany(SessionFactory sessionFactory) {
        UserForeignKey user = new UserForeignKey();
        user.setId(null);
        user.setFirstName("Roman");
        user.setLastName("Mai");
        
        AddressForeignKey address1 = new AddressForeignKey();
        address1.setId(null);
        address1.setCity("Oslo");
        address1.setUser(user);
        AddressForeignKey address2 = new AddressForeignKey();
        address2.setId(null);
        address2.setCity("Riga");
        address2.setUser(user);
        Set<AddressForeignKey> addresses = new HashSet<>(Arrays.asList(address1, address2));
        user.setAddresses(addresses);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static void saveWithJoinTableOneToMany(SessionFactory sessionFactory) {
        UserJoinTable user = new UserJoinTable();
        user.setId(null);
        user.setFirstName("Roman");
        user.setLastName("Mai");
        
        AddressJoinTable address1 = new AddressJoinTable();
        address1.setId(null);
        address1.setCity("Oslo");
        AddressJoinTable address2 = new AddressJoinTable();
        address2.setId(null);
        address2.setCity("Riga");
        Set<AddressJoinTable> addresses = new HashSet<>(Arrays.asList(address1, address2));
        user.setAddresses(addresses);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        
    }

}
