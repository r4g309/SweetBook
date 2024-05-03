package dev.r4g309.sweetbook.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "languages", indexes = {
        @Index(name = "language_index", columnList = "language", unique = true)
})
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "languages")
    private List<Book> books;

    @Column(unique = true)
    private String language;

    public Languages() {
    }

    public Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
