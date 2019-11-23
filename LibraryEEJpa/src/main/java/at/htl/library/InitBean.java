package at.htl.library;

import at.htl.library.entity.Author;
import at.htl.library.entity.Genre;
import at.htl.library.entity.PublishingHouse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
            readPublishingHousesFromFile("publishingHouses.csv");
            readGenreFromFile("genre.csv");
            readAuthorFromFile("author.csv");
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        // when app is undeployed
    }

    private void readPublishingHousesFromFile(String phFileName) {

        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(phFileName);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream.skip(1)
                    .map((String s) -> s.split(";"))
                    .map(a -> new PublishingHouse(a[0], a[1], Long.valueOf(a[2]), a[3], a[4]))
                    .forEach(em::merge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readGenreFromFile(String genreFileName) {

        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(genreFileName);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream.skip(1)
                    .map((String s) -> s.split(";"))
                    .map(a -> new Genre(a[0]))
                    .forEach(em::merge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAuthorFromFile(String authorFileName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(authorFileName);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream.skip(1)
                    .map((String s) -> s.split(";"))
                    .map(a -> new Author(a[0], a[1], LocalDate.parse(a[2], dtf)))
                    .forEach(em::merge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
