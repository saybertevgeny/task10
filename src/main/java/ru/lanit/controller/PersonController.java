package ru.lanit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.exception.MappingException;
import ru.lanit.mapper.request.PersonMapper;
import ru.lanit.repository.PersonRepository;
import java.util.Map;

@Controller
public class PersonController {

    private PersonRepository personRepository;
    private PersonMapper mapper;

    public PersonController(PersonRepository personRepository, PersonMapper mapper){
        this.mapper = mapper;
        this.personRepository = personRepository;

    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showFrom(){
        return "index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam Map<String,String> request){
        boolean existError = false;
        ModelAndView result = new ModelAndView();
        try {
            personRepository.save(mapper.map(request));
        }
        catch (MappingException e){
            existError = true;
            result.addObject("errorMessage",e.getMessage());
        }
        if(existError){
            result.setViewName("index");
        }
        else{
            result.setViewName("redirect:address");
        }
        return result;
    }
}
