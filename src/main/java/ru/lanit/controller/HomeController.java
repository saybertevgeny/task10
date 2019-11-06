package ru.lanit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.repository.PersonRepository;

@Controller
public class HomeController {

    private PersonRepository personRepository;

    public HomeController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/statictic", method = RequestMethod.GET)
    public ModelAndView getStatistic(){
        ModelAndView result = new ModelAndView();
        result.addObject("persons", personRepository.getList());
        result.setViewName("statistic");
        return result;
    }
}
