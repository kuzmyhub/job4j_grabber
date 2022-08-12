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

    public static void main(String[] args) throws IOException {
        List<Post> posts = new ArrayList<>();
        HabrCareerParse habrCareerParse
                = new HabrCareerParse(new HabrCareerDateTimeParser());
        posts.addAll(habrCareerParse.list(PAGE_LINK + "?page="));
        for (Post p : posts) {
            System.out.println(p + System.lineSeparator());
        }
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
                    HabrCareerParse habrCareerParse
                            = new HabrCareerParse(new HabrCareerDateTimeParser());
                    posts.add(habrCareerParse.parsePost(row.select(".vacancy-card__title").first(),
                                row.select(".vacancy-card__date").first()));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return posts;
    }

    private Post parsePost(Element titleElement, Element dateElement) {
        Post post = null;
        HabrCareerParse habrCareerParse
                = new HabrCareerParse(new HabrCareerDateTimeParser());
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        Element vacancyDate = dateElement.child(0);
        String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        try {
            String vacancyDescription = habrCareerParse.retrieveDescription(vacancyLink);
            post = new Post(vacancyName, vacancyLink,
                    vacancyDescription,
                    habrCareerParse.dateTimeParser.parse(
                            vacancyDate.attr("datetime")
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    private String retrieveDescription(String link) {
        String description = null;
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Elements row = document.select(".style-ugc");
            description = row.text();
        } catch (IllegalAccessError | IOException e) {
            e.printStackTrace();
        }
        return description;
    }
}
