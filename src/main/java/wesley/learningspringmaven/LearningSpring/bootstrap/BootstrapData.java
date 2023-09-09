package bootstrap;

import domain.Author;
import domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;



@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author rod = new Author();
        rod.setFirstName("rod");
        rod.setLastName("Johnson");

        Books noEjb = new Books();
        noEjb.setTitle("J2EE Development without EJB");
        noEjb.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Books noEjbSaved = bookRepository.save(noEjb);
        authorRepository.save(rodSaved);

        rodSaved.getBooks().add(noEjbSaved);
        System.out.println("Author Count" + authorRepository.count());
        System.out.println("Book Count" + bookRepository.count());
    }
}
