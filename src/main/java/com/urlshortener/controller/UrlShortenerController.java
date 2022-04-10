package com.urlshortener.controller;

import com.urlshortener.entity.UrlMapping;
import com.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;


    @RequestMapping(value = "/url/short", method = RequestMethod.POST)
    String createShortUrl(@RequestParam("url") String url) {
        System.out.println(url);
        String shortUrl = urlShortenerService.save(url);
        return shortUrl;
    }


    @RequestMapping(value = "/url/original", method = RequestMethod.GET)
    String getOriginalUrl(@RequestParam("url") String url) {
        String originalUrl = urlShortenerService.find(url);
        return originalUrl;
    }
    
    @RequestMapping(value = "/urls", method = RequestMethod.GET)
    List<UrlMapping> getAllUrls() {
        return urlShortenerService.findAll();
    }
}
