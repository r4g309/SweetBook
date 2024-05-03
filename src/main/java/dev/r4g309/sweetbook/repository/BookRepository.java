package dev.r4g309.sweetbook.repository;

import dev.r4g309.sweetbook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguagesLanguage(String language);
}
