package de.springboot.repos;

import de.springboot.model.StackoverflowWebsite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackWebsiteRepository extends MongoRepository<StackoverflowWebsite, String> {

    List<StackoverflowWebsite> findById(String id);

}
