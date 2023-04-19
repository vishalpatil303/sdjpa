package guru.springframework.sdjpa.boostrap;

import guru.springframework.sdjpa.domain.Book;
import guru.springframework.sdjpa.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public Dataloader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Domain Driven Design","123456 ","Macgill Publication ");
        bookRepository.save(book1);

        Book book2 = new Book("Spring in Action","123457","Orielly");
        bookRepository.save(book2);
    }
}
