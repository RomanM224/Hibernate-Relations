package com.maistruk.hibernateRelations.NaturalId;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainNaturalId {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AccountNaturalId.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        AccountNaturalId account1 = new AccountNaturalId();
        account1.setId(null);
        account1.setEmail("email@gmail.com");
        account1.setFirstName("Roman");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account1);
        
        AccountNaturalId account2 = (AccountNaturalId) session.bySimpleNaturalId(AccountNaturalId.class).load("email@gmail.com");
        System.out.println(account2);
        
        session.getTransaction().commit();
        session.close();
    }

}
