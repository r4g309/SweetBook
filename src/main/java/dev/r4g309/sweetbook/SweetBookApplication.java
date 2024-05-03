package dev.r4g309.sweetbook;

import dev.r4g309.sweetbook.principal.MainMenu;
import dev.r4g309.sweetbook.repository.BookRepository;
import dev.r4g309.sweetbook.repository.LanguagesRepository;
import dev.r4g309.sweetbook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SweetBookApplication implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    private final LanguagesRepository languagesRepository;

    @Autowired
    public SweetBookApplication(BookRepository bookRepository, PersonRepository personRepository, LanguagesRepository languagesRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.languagesRepository = languagesRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(SweetBookApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new MainMenu(bookRepository, personRepository,languagesRepository).run();
    }
}