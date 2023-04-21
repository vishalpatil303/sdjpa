package guru.springframework.sdjpa.boostrap;

import guru.springframework.sdjpa.dao.AuthorDao;
import guru.springframework.sdjpa.domain.Author;
import guru.springframework.sdjpa.domain.Book;
import guru.springframework.sdjpa.domain.primaryKey.AuthorPKUUID;
import guru.springframework.sdjpa.domain.primaryKey.BookPKSequence;
import guru.springframework.sdjpa.domain.primaryKey.BookPKUUIDRFC4122;
import guru.springframework.sdjpa.repository.*;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Profile({"local","default"})
@Component
public class Dataloader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookPKSequenceRepository bookPKSequenceRepository;
    private final AuthorPKUUIDRepository authorPKUUIDRepository;
    private final BookPKUUIDRFC4122Repository bookPKUUIDRFC4122Repository;
    private final AuthorDao authorDao;

    public Dataloader(BookRepository bookRepository, AuthorRepository authorRepository, BookPKSequenceRepository bookPKSequenceRepository, AuthorPKUUIDRepository authorPKUUIDRepository, BookPKUUIDRFC4122Repository bookPKUUIDRFC4122Repository, AuthorDao authorDao) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookPKSequenceRepository = bookPKSequenceRepository;
        this.authorPKUUIDRepository = authorPKUUIDRepository;
        this.bookPKUUIDRFC4122Repository = bookPKUUIDRFC4122Repository;
        this.authorDao = authorDao;
    }

    @Override
    public void run(String... args) throws Exception {
/*        Author a1 = new Author("Vishal","Dwarkunde");
        authorRepository.save(a1);

        Author a2= new Author("Tushar","Dwarkunde");
        authorRepository.save(a2);

        AuthorPKUUID ap1= new AuthorPKUUID("Vishal","Dwarkunde");
        authorPKUUIDRepository.save(ap1);

        AuthorPKUUID ap2= new AuthorPKUUID("Tushar","Dwarkunde");
        authorPKUUIDRepository.save(ap2);*/


        /*Book book1 = new Book("Domain Driven Design","123456 ","Macgill Publication ");
        bookRepository.save(book1);

        Book book2 = new Book("Spring in Action","123457","Orielly");
        bookRepository.save(book2);

        BookPKSequence b1 = new BookPKSequence("Domain Driven Design","123456 ","Macgill Publication ");
        bookPKSequenceRepository.save(b1);

        BookPKSequence b2 = new BookPKSequence("Spring in Action","123457","Orielly");
        bookPKSequenceRepository.save(b2);

        BookPKUUIDRFC4122 bu1 = new BookPKUUIDRFC4122("Domain Driven Design","123456 ","Macgill Publication ");
        bookPKUUIDRFC4122Repository.save(bu1);

        BookPKUUIDRFC4122 bu2 = new BookPKUUIDRFC4122("Spring in Action","123457","Orielly");
        bookPKUUIDRFC4122Repository.save(bu2);*/

        Set<Author> authors = authorDao.findAll();
        for (Author a:authors) {
            System.out.println(a);
        }
        authorDao.deleteById(205l);
       //authorDao.save(new Author("Vishal","Dwarkunde"));
        System.out.println("After Delete");
        Set<Author> authors2 = authorDao.findAll();
        for (Author a:authors2) {
            System.out.println(a);
        }
    }
}
