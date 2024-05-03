package dev.r4g309.sweetbook.principal;

import dev.r4g309.sweetbook.models.Book;
import dev.r4g309.sweetbook.models.Languages;
import dev.r4g309.sweetbook.models.Person;
import dev.r4g309.sweetbook.repository.BookRepository;
import dev.r4g309.sweetbook.repository.LanguagesRepository;
import dev.r4g309.sweetbook.repository.PersonRepository;
import dev.r4g309.sweetbook.schemas.BookResponse;
import dev.r4g309.sweetbook.schemas.BookSchema;
import dev.r4g309.sweetbook.services.GutenService;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final GutenService gutenService = new GutenService();
    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    private final LanguagesRepository languagesRepository;

    public MainMenu(BookRepository bookRepository, PersonRepository personRepository, LanguagesRepository languagesRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.languagesRepository = languagesRepository;
    }

    public void run() {
        int option = -1;
        String menu = """
                Welcome to SweetBook!
                1 - Buscar libro por titulo
                2 - Listar libros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos en un determinado año
                5 - Listar libros por idioma
                0 - Salir
                """;
        while (option != 0) {
            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch (option) {
                case 1 -> searchBookByTitle();
                case 2 -> showRegisteredBooks();
                case 3 -> showRegisteredAuthors();
                case 4 -> searchAuthorsByYear();
                case 5 -> listBooksByLanguage();
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private void searchBookByTitle() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String title = keyboard.nextLine();

        BookResponse response = gutenService.getBooksByTitle(title);
        if (response == null || response.books()
                .isEmpty()) {
            System.out.println("No se encontraron libros con el título: " + title);
            return;
        }

        BookSchema bookSchema = response.books()
                .getFirst();

        try {
            Book savableBook = new Book(bookSchema);
            savableBook.setLanguages(insertLanguages(bookSchema.languages()));
            System.out.println(bookRepository.save(savableBook));
        } catch (Exception e) {
            System.out.println("No se puede guardar el mismo libro dos veces.");
        }

    }

    private List<Languages> insertLanguages(@NotNull List<String> languages) {
        return languages.stream()
                .map(language -> {
                    Optional<Languages> l = languagesRepository.findByLanguage(language);
                    return l.orElseGet(() -> languagesRepository.save(new Languages(language)));
                })
                .toList();
    }

    private void showRegisteredBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }
        books.forEach(System.out::println);
    }

    private void showRegisteredAuthors() {
        List<Person> authors = personRepository.findAll();
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados");
            return;
        }
        System.out.println("Listado de autores registrados");
        authors.forEach(System.out::println);
    }

    private void searchAuthorsByYear() {
        System.out.println("Ingrese el año a buscar: ");
        int year = keyboard.nextInt();
        List<Person> authors = personRepository.findByBirthYearLessThanAndDeathYearGreaterThan(year, year);
        if (authors.isEmpty()) {
            System.out.println("No hay autores vivos en el año: " + year);
            return;
        }
        System.out.println("Autores vivos en el año: " + year + "\n");
        authors.forEach(System.out::println);
    }

    private void listBooksByLanguage() {
        List<Languages> languages = languagesRepository.findAll();
        if (languages.isEmpty()) {
            System.out.println("No hay idiomas registrados");
            return;
        }
        System.out.println("Listado de idiomas registrados");
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(i + 1 + " - " + languages.get(i));
        }


        System.out.println("Ingrese el idioma a buscar: ");
        String language = keyboard.nextLine();
        if (language.isBlank()) {
            System.out.println("El idioma no puede estar vacío");
            return;
        }
        if (languages.stream()
                .noneMatch(l -> l.getLanguage()
                        .equals(language))) {
            System.out.println("El idioma no está registrado");
            return;
        }
        List<Book> books = bookRepository.findByLanguagesLanguage(language);
        if (books.isEmpty()) {
            System.out.println("No hay libros en el idioma: " + language);
            return;
        }
        System.out.println("Libros en el idioma: " + language + "\n");
        books.forEach(System.out::println);
    }
}
