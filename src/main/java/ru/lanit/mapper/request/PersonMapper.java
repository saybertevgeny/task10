package ru.lanit.mapper.request;

import org.springframework.stereotype.Component;
import ru.lanit.entity.Person;
import ru.lanit.exception.MappingException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;

@Component
public class PersonMapper {

    private enum RequiredParams{firstname,middlename,lastname,birthday}

    public Person map(Map<String,String> request) throws MappingException{
        Person person = new Person();
        for(RequiredParams p: RequiredParams.values()){
            String paramValue = request.get(p.name());
            if(paramValue == null || paramValue.isEmpty()){
                throw new MappingException("Все поля обязательны");
            }
        }
        person.setFirstName(request.get("firstname"))
                .setMiddleName(request.get("middlename"))
                .setLastName(request.get("lastname"))
                .setBirthDate(LocalDate.parse(request.get("birthday")));
        return person;
    }
}
