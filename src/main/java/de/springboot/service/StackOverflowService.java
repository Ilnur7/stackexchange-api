package de.springboot.service;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.repos.StackWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StackOverflowService {

    @Autowired
    private StackWebsiteRepository repo;

    public List<StackoverflowWebsite> findAll() {
        return repo.findAll();
    }

    public List<StackoverflowWebsite> findById(String id){
        return repo.findById(id);
    }
}
