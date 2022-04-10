package com.urlshortener.bootstrap;

import com.urlshortener.entity.UrlMapping;
import com.urlshortener.repository.UrlShortenerRepository;
import com.urlshortener.utility.ShortUrlUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class BootStrapData {

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    @PostConstruct
    public void prefillData() {
    	
        for (int i = 62; i< 62*62; i++) {
            UrlMapping newUrlMapping = createUrlMapping(i);
            urlShortenerRepository.save(newUrlMapping);
        }
    }

    private UrlMapping createUrlMapping(int i) {
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setId(i);
        urlMapping.setShortUrl(ShortUrlUtility.idToShortURL(i));
        urlMapping.setOriginalUrl("");
        urlMapping.setCount(0);
        urlMapping.setCallTime(new Date(0));
        return urlMapping;
    }
}
