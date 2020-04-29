package de.springboot.service;

import com.google.common.collect.ImmutableList;
import de.springboot.dto.SiteDto;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.repos.StackWebsiteRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class StackOverflowService {

    @Autowired
    private StackWebsiteRepository repo;

    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<StackoverflowWebsite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(siteDto -> toStackOverflowWebsite(siteDto))
                .filter(this::ignoreMeta) //игнорируем данные которые начинаются с meta
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NonNull StackoverflowWebsite stackoverflowWebsite) {
        return !stackoverflowWebsite.getId().startsWith("meta");
    }

    private StackoverflowWebsite toStackOverflowWebsite(@NonNull SiteDto siteDto) {
        return StackoverflowWebsite.builder()
                .id(siteDto.getSite_url().substring("https://".length(), siteDto.getSite_url().length() - ".com".length()))
                .description(siteDto.getAudience())
                .iconImageUrl(siteDto.getFavicon_url())
                .title(siteDto.getName())
                .website(siteDto.getSite_url())
                .build();
    }

    public List<StackoverflowWebsite> findById(String id){
        return repo.findById(id);
    }
}
