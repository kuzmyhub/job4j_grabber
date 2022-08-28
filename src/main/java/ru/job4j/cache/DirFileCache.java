package ru.job4j.cache;

import jdk.jshell.EvalException;
import org.jsoup.select.Evaluator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String value = null;
        try {
            String text = Files.readString(Path.of(cachingDir, key));
            value = text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
