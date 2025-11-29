package com.webScapper.Service;

import com.webScapper.Model.ScrapeResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperService {

    public ScrapeResponse webScrape(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();

        List<String> images = new ArrayList<>();
        List<String> videos = new ArrayList<>();
        List<String> links = new ArrayList<>();

        //Elements img = doc.select("a[href]");

        for(Element img : doc.select("img")){
            String src = img.absUrl("src");
            if(!src.isEmpty())
                images.add(src);
        }

        for(Element video : doc.select("video")){
            String src = video.absUrl("src");
            if(!src.isEmpty())
                videos.add(src);
        }

        for(Element link : doc.select("a[href]")){
            String src = link.absUrl("href");
            if(!src.isEmpty())
                links.add(src);
        }

        ScrapeResponse response = new ScrapeResponse();
        response.setImages(images);
        response.setVideos(videos);
        response.setLinks(links);

        return response;
    }

}
