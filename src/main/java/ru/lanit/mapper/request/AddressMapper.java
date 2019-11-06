package ru.lanit.mapper.request;

import org.springframework.stereotype.Component;
import ru.lanit.entity.Address;
import ru.lanit.exception.MappingException;
import java.util.Map;

@Component
public class AddressMapper {

    private enum RequiredParams{street,house,flat}

    public static Address map(Map<String,String> request) throws MappingException {
        Address address = new Address();
        for(RequiredParams p: RequiredParams.values()){
            String paramValue = request.get(p.name());
            if(paramValue == null || paramValue.isEmpty()){
                throw new MappingException("Все поля обязательны");
            }
        }
        address.setStreet(request.get("street"))
                .setHouse(request.get("house"))
                .setFlat(request.get("flat"));
        return address;
    }
}
