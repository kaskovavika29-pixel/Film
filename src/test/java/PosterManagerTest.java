package netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    @Test
    void shouldFindAllFilms() {
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");

        String[] expected = {
                "Бладшот",
                "Вперёд",
                "Отель Белград"
        };

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastFiveFilms() {
        PosterManager manager = new PosterManager();

        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");
        manager.add("Фильм 6");

        String[] expected = {
                "Фильм 6",
                "Фильм 5",
                "Фильм 4",
                "Фильм 3",
                "Фильм 2"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastWhenFilmsLessThanLimit() {
        PosterManager manager = new PosterManager();

        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");

        String[] expected = {
                "Фильм 3",
                "Фильм 2",
                "Фильм 1"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldUseCustomLimit() {
        PosterManager manager = new PosterManager(3);

        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");

        String[] expected = {
                "Фильм 5",
                "Фильм 4",
                "Фильм 3"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnEmptyArrayWhenNoFilms() {
        PosterManager manager = new PosterManager();

        String[] expected = {};

        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }
}
