package ru.job4j.grabber;

import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) throws SQLException {
        try {
            Class.forName(cfg.getProperty("driver_class"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cnn = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password")
                );
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement statement
                     = cnn.prepareStatement(
                             "create table if not exists "
                                     + "post(id serial primary key,"
                                     + " name text, text text, link text,"
                                     + " created date)"
        )) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement
                     = cnn.prepareStatement(
                             "insert into"
                                     + " post(name, text, link, created)"
                                     + " values (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getLink());
            statement.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    post.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> list = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("select * from post")) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                list.add(new Post(
                   resultSet.getInt(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getString(4),
                   resultSet.getTimestamp(5).toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement
                     = cnn.prepareStatement("select id from post where id = ?")) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                post = new Post(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4).toLocalDateTime()
                        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) {
        HabrCareerParse habrCareerParse
                = new HabrCareerParse(new HabrCareerDateTimeParser());
        List<Post> list
                = habrCareerParse.list(
                "https://career.habr.com/vacancies/java_developer?page="
        );
        PsqlStore psqlStore = null;
        try (InputStream in
                     = PsqlStore.class.getClassLoader()
                .getResourceAsStream("career_parse.properties")) {
            Properties cfg = new Properties();
            cfg.load(in);
            psqlStore = new PsqlStore(cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Post p : list) {
            psqlStore.save(p);
        }
    }
}
