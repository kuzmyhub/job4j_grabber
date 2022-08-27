package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String value = get(key);
        if (value == null) {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader in = new BufferedReader(
                        new FileReader(cachingDir + key)
                );
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = sb.toString();
        }
        return value;
    }
}
