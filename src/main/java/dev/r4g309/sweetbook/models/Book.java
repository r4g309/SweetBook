package dev.r4g309.sweetbook.models;

import dev.r4g309.sweetbook.schemas.BookSchema;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String title;



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> authors;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Languages> languages;

    private Integer downloadCount;

    public Book() {

    }

    public Book(BookSchema bookSchema) {
        this.id = bookSchema.id();
        this.title = bookSchema.title();
        this.downloadCount = bookSchema.downloadCount();
        this.authors = bookSchema.authors()
                .stream()
                .map(Person::new)
                .toList();

        this.languages = bookSchema.languages()
                .stream()
                .map(Languages::new)
                .toList();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "------ Libro ------\n" +
               "Título: " + title + "\n" +
               "Autores: " + String.join(", ", authors.stream()
                .map(Person::getName)
                .toList()) + "\n" +
               "Idiomas: " + languages.stream()
                       .map(Languages::getLanguage)
                       .collect(Collectors.joining(", ")) + "\n" +
               "Numbero de descargas: " + downloadCount + "\n" +
               "-------------------";
    }
}
