package de.springboot.controller;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.service.StackOverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stackoverflow")
public class StackOverflowController {

    @Autowired
    private StackOverflowService stackOverflowService;

    @RequestMapping
    public List<StackoverflowWebsite> getListOfProviders(){
        return stackOverflowService.findAll();
    }

    @RequestMapping("{id}")
    public List<StackoverflowWebsite> getWebsiteById(@PathVariable String id){
        return stackOverflowService.findById(id);
    }
}
