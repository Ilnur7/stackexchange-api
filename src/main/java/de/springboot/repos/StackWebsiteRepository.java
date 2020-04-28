package de.springboot.repos;

import de.springboot.model.StackoverflowWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StackWebsiteRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<StackoverflowWebsite> findAll() {
        return mongoTemplate.findAll(StackoverflowWebsite.class);
    }
}
