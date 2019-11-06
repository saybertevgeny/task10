package ru.lanit.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.lanit.entity.Address;
import ru.lanit.provider.SessionProvider;

@Component
public class AddressRepository {

    private SessionProvider sessionProvider;

    public AddressRepository(SessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }

    public void save(Address address){
        try (Session session = sessionProvider.getSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }
    }
}
