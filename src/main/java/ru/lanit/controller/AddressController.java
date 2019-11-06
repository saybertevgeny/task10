package ru.lanit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.exception.MappingException;
import ru.lanit.mapper.request.AddressMapper;
import ru.lanit.mapper.request.PersonMapper;
import ru.lanit.repository.AddressRepository;
import ru.lanit.repository.PersonRepository;

import java.util.Map;

@Controller
public class AddressController {

    private AddressRepository addressRepository;
    private PersonRepository personRepository;
    private AddressMapper mapper;

    public AddressController(AddressRepository addressRepository, PersonRepository personRepository, AddressMapper mapper) {
        this.mapper = mapper;
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;

    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public ModelAndView showFrom() {
        ModelAndView result = new ModelAndView();
        result.addObject("persons", personRepository.getList(false));
        return result;
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam Map<String, String> request) {
        boolean existError = false;
        ModelAndView result = new ModelAndView();
        try {
            addressRepository.save(mapper.map(request));
        } catch (MappingException e) {
            existError = true;
            result.addObject("errorMessage", e.getMessage());
        }
        if (existError) {
            result.setViewName("index");
        } else {
            result.setViewName("redirect:statictic");
        }
        return result;
    }
}
