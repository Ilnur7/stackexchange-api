package de.springboot.service;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.repos.StackWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StackOverflowService {

    @Autowired
    private StackWebsiteRepository repo;

    private static  List<StackoverflowWebsite> items = new ArrayList<>();

    static {
        items.add (new StackoverflowWebsite("stackoverflow", "http://stackoverflow.com",
                "http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico", "Stack Overflow (StackExchange)",
                "for professional and enthusiast programmers"));

        items.add (new StackoverflowWebsite("serverfault", "http: //serverfault.com",
        "http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico", "Server Fault (StackExchange)",
                "for systen and network administrators"));

        items.add (new StackoverflowWebsite("superuser", "http://superuser.com",
                "http://cdn.sstatic.net/Sites/superuser/img/favicon.ico", "Super User (StackExchange )",
                "for computer enthusiasts and power users "));

        items.add (new StackoverflowWebsite(" askubuntu "," http://askubuntu.com ",
                "http://cdn.sstatic.net/Sites/askubuntu/img/favicon.ico", "Ask Ubuntu (StackExchange)",
                "for Ubuntu users and developers "));

        items.add (new StackoverflowWebsite("apple", "http: //apple.stackexchange, com",
                "http://cdn.sstatic.net/Sites/apple/img/favicon.ico", "Ask Different (StackExchange)",
                "for power users of Apple hardware and software"));

        items.add (new StackoverflowWebsite("android", "http://android.stackexchange.com ",
        "http://cdn.sstatic.net/Sites/android/img/favicon.ico " , "Android Enthusiasts (StackExchange)",
                "for enthusiasts and power users of the Android operating system"));

        items.add (new StackoverflowWebsite("ru.stackoverflow" ,"http://ru.stackoverflow.com ",
        "http://cdn.sstatic.net/Sites/ru/img/favicon.ico",
                "Stack Overflow на русском (StackExchange)", "for programmers"));
    }

    //запускаем один раз, чтобы каждый раз значения не записывались в бд
    /*@PostConstruct
    public void init(){
        repo.save(items);
    }*/

    public List<StackoverflowWebsite> findAll() {
        return repo.findAll();
    }
}
