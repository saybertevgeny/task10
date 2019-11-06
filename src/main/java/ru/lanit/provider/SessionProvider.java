package ru.lanit.provider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SessionProvider {

    private SessionFactory sessionFactory;

    private SessionProvider(){
        sessionFactory = (new Configuration()).configure().buildSessionFactory();
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }
}
