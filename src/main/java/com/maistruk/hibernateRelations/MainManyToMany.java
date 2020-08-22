package com.maistruk.hibernateRelations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernateRelations.ManyToMany.Reader;
import com.maistruk.hibernateRelations.ManyToMany.Subscription;

public class MainManyToMany {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reader.class).addAnnotatedClass(Subscription.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);    
        
        Subscription subscription1 = new Subscription();
        subscription1.setId(null);
        subscription1.setSubscriptionName("Entertainment");
        Subscription subscription2 = new Subscription();
        subscription2.setId(null);
        subscription2.setSubscriptionName("Comedy");
        Set<Subscription> subscriptions = new HashSet<>(Arrays.asList(subscription1, subscription2));
        
        Reader reader = new Reader();
        reader.setId(null);
        reader.setFirstName("Roman");
        reader.setLastName("Mai");
        reader.setSubscriptions(subscriptions);
        
        Reader reader2 = new Reader();
        reader2.setId(null);
        reader2.setFirstName("Vika");
        reader2.setLastName("Mai");
        reader2.setSubscriptions(subscriptions);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(reader);
        session.save(reader2);
        session.getTransaction().commit();
        session.close();
        
    }

}
