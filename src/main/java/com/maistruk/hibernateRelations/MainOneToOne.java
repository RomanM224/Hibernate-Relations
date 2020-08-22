package com.maistruk.hibernateRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernateRelations.OneToOne.ForeignKey.AccountForeignKey;
import com.maistruk.hibernateRelations.OneToOne.ForeignKey.EmployeeForeignKey;
import com.maistruk.hibernateRelations.OneToOne.JoinTable.AccountJoinTable;
import com.maistruk.hibernateRelations.OneToOne.JoinTable.EmployeeJoinTable;


public class MainOneToOne {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeForeignKey.class).addAnnotatedClass(AccountForeignKey.class).addAnnotatedClass(EmployeeJoinTable.class).addAnnotatedClass(AccountJoinTable.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);    
        
       // saveWithForeginKeyOneToOne(sessionFactory);
        
        
        saveWithJoinTableOneToOne(sessionFactory);

    }
    
    public static void saveWithForeginKeyOneToOne(SessionFactory sessionFactory) {
        AccountForeignKey account = new AccountForeignKey();
        account.setId(null);
        account.setPassword("asd");
        EmployeeForeignKey employee = new EmployeeForeignKey();
        employee.setId(null);
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setAccount(account);
        account.setEmployee(employee);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void saveWithJoinTableOneToOne(SessionFactory sessionFactory) {
        AccountJoinTable account = new AccountJoinTable();
        account.setId(null);
        account.setPassword("asd");
        EmployeeJoinTable employee = new EmployeeJoinTable();
        employee.setId(null);
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setAccount(account);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
      //  session.save(account);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}
