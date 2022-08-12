package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrCareerParse {

    private static final int LAST_PAGE_NUMBER = 5;

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= LAST_PAGE_NUMBER; i++) {
            Connection connection = Jsoup.connect(PAGE_LINK + "?page=" + i);
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                Element dateElement = row.select(".vacancy-card__date").first();
                Element vacancyDate = dateElement.child(0);
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                HabrCareerParse habrCareerParse = new HabrCareerParse();
                try {
                    String vacancyDescription = habrCareerParse.retrieveDescription(link);
                    System.out.printf(
                            "%s %s %s%n%s%n",
                            vacancyName, link, vacancyDate.attr("datetime"), vacancyDescription
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private String retrieveDescription(String link) throws IOException {
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        Elements row = document.select(".style-ugc");
        return row.text();
    }
}
