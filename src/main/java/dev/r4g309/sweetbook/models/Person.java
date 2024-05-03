package dev.r4g309.sweetbook.models;

import dev.r4g309.sweetbook.schemas.PersonSchema;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    String name;
    Integer birthYear;
    Integer deathYear;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    List<Book> books;

    public Person() {
    }

    public Person(Long id, String name, Integer birthYear, Integer deathYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Person(PersonSchema person) {
        this.name = person.name();
        this.birthYear = person.birthYear();
        this.deathYear = person.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "----Autor----\n" +
               "Name: " + name + "\n" +
               "BirthYear: " + birthYear + "\n" +
               "DeathYear=" + deathYear + "\n" +
               "[Books]: [" + books.stream()
                       .map(Book::getTitle)
                       .collect(Collectors.joining(", ")) + "]\n" +
               "------------\n";
    }
}