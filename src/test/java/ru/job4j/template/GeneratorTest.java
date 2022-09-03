package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneratorTest {

    @Test
    public void whenKeysMatch() {
        Generator generator = new GreetingGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Ivan, Who are you? ";
        assertThat(generator.produce(template, map)).isEqualTo(expected);
    }

    @Test
    public void whenMapNotContainsKeyFromTemplate() {
        Generator generator = new GreetingGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "you");
        String template = "Hello ${patronymic} ${name}, how are ${subject}";
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, map);
        });
    }

    @Test
    public void whenMapContainsKeyThatIsNotInTemplate() {
        Generator generator = new GreetingGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "you");
        String template = "Hello ${name}";
        assertThrows(IllegalArgumentException.class, () -> {
           generator.produce(template, map);
        });
    }

}