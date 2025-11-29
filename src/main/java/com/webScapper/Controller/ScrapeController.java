package com.webScapper.Controller;

import com.webScapper.Model.ScrapeResponse;
import com.webScapper.Service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class ScrapeController {

    @Autowired
    private ScraperService scraperService;

    @GetMapping("/api/scrape")
    public ScrapeResponse scrape(@RequestParam String url) throws IOException {
        return scraperService.webScrape(url);
    }

}
