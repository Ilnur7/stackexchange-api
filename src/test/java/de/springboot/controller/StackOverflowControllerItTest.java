package de.springboot.controller;

import com.google.common.collect.ImmutableList;
import de.springboot.Application;
import de.springboot.model.StackoverflowWebsite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class) //исходная точка приложения
@WebIntegrationTest
public class StackOverflowControllerItTest {

    RestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before(){
        //добавляем встроенную mongo для тестирования и не используем внешнюю mongo
        mongoTemplate.dropCollection(StackoverflowWebsite.class);
        mongoTemplate.save(new StackoverflowWebsite("website1", "website", "icon", "title", "desc"));
        mongoTemplate.save(new StackoverflowWebsite("website2", "website", "icon", "title", "desc"));
    }

    @Test
    public void getListOfProviders() {
        ResponseEntity<List<StackoverflowWebsite>> responseEntity =
            restTemplate.exchange("http://localhost:8090/api/stackoverflow", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<StackoverflowWebsite>>() {
            });

        List<StackoverflowWebsite> list = responseEntity.getBody();
        //validate
        assertThat(list.size(), is(2));
        List<String> listId = list.stream()
                .map(stackoverflowWebsite -> stackoverflowWebsite.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        assertThat(listId, containsInAnyOrder("website2", "website1"));

    }
}