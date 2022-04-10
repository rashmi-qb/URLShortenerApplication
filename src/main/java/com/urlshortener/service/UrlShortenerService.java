package com.urlshortener.service;

import com.urlshortener.entity.UrlMapping;
import com.urlshortener.repository.UrlShortenerRepository;
import com.urlshortener.utility.ShortUrlUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UrlShortenerService {

	@Autowired
	private UrlShortenerRepository urlShortenerRepository;

	private static final String DOMAIN_URL = "http://applau.se/";

	public String save(String longUrl) {
		Optional<UrlMapping> urlMapping = urlShortenerRepository.findEmptyUrl();
		UrlMapping newUrlMapping;
		if (urlMapping.isPresent()) {
			newUrlMapping = setUrlMapping(longUrl, urlMapping.get());
		} else {
			Optional<UrlMapping> urlMappingDateMapping = urlShortenerRepository.findLeastUsedDate();
			newUrlMapping = setUrlMapping(longUrl, urlMappingDateMapping.get());
		}

		return DOMAIN_URL + urlShortenerRepository.save(newUrlMapping).getShortUrl();
	}

	public String find(String shortUrl) {
		String newShortUrl = shortUrl.replace(DOMAIN_URL, "");
		Integer id = ShortUrlUtility.shortUrlToId(newShortUrl);
		Optional<UrlMapping> urlMapping = urlShortenerRepository.findById(id);
		if (urlMapping.isPresent()) {
			if (urlMapping.get().getOriginalUrl().length() > 0) {
				increaseUrlCountAndDate(urlMapping.get());
				return urlMapping.get().getOriginalUrl();
			}
		}
		return new String("No origin url exists for provided shorten url");
	}
    /**
     * This is thread safe as findById has done select for update
     * @param urlMapping
     */
    private void increaseUrlCountAndDate(UrlMapping urlMapping) {
        urlMapping.setCount(urlMapping.getCount() + 1);
        urlMapping.setCallTime(new Date());
        urlShortenerRepository.save(urlMapping);
    }

    private UrlMapping setUrlMapping(String longUrl, UrlMapping urlMapping) {
        UrlMapping newUrlMapping = new UrlMapping();
        newUrlMapping.setId(urlMapping.getId());
        newUrlMapping.setShortUrl(urlMapping.getShortUrl());
        newUrlMapping.setOriginalUrl(longUrl);
        newUrlMapping.setCount(urlMapping.getCount());
        newUrlMapping.setCallTime(urlMapping.getCallTime());
        return newUrlMapping;
    }
    
    public List<UrlMapping> findAll() {
		return urlShortenerRepository.findAllByOrderByCountDesc();
	}

}
