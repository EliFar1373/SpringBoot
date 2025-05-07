package com.project;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Web endpoint for home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("newsItems", newsService.getAllNews());
        return "home";
    }

    // REST API endpoints
    @GetMapping("/api/news")
    @ResponseBody
    public List<NewsItem> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping("/api/news")
    @ResponseBody
    public NewsItem addNews(@RequestBody NewsItem newsItem) {
        return newsService.addNews(newsItem);
    }
}