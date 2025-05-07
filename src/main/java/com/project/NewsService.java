package com.project;




import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsService {
    private final List<NewsItem> newsItems = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public NewsService() {
        // Initialize with sample data
        newsItems.add(new NewsItem(counter.incrementAndGet(), "Welcome", "Hello, welcome to the news portal!"));
        newsItems.add(new NewsItem(counter.incrementAndGet(), "Update", "New features added to the application."));
    }

    public List<NewsItem> getAllNews() {
        return new ArrayList<>(newsItems);
    }

    public NewsItem addNews(NewsItem newsItem) {
        newsItem.setId(counter.incrementAndGet());
        newsItems.add(newsItem);
        return newsItem;
    }
}