package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {

    private static final int LAST_PAGE_NUMBER = 5;

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        HabrCareerParse habrCareerParse
                = new HabrCareerParse(new HabrCareerDateTimeParser());
        posts.addAll(habrCareerParse.list(PAGE_LINK + "?page="));
    }

    @Override
    public List<Post> list(String link) {
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= LAST_PAGE_NUMBER; i++) {
            try {
                Connection connection = Jsoup.connect(link + i);
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> {
                    posts.add(parsePost(row));
                });
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
        }
        return posts;
    }

    private Post parsePost(Element element) {
        Element titleElement = element.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        Element dateElement = element.select(".vacancy-card__date").first();
        Element vacancyDate = dateElement.child(0);
        String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        String vacancyDescription = retrieveDescription(vacancyLink);
        Post post = new Post(vacancyName, vacancyLink,
                vacancyDescription,
                dateTimeParser.parse(
                        vacancyDate.attr("datetime")
                ));
        return post;
    }

    private String retrieveDescription(String link) {
        String description = null;
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Elements row = document.select(".style-ugc");
            description = row.text();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return description;
    }
}
