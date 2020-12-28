//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package firstspring.springframework.springwebapp.bootstrap;

import firstspring.springframework.springwebapp.domain.Author;
import firstspring.springframework.springwebapp.domain.Book;
import firstspring.springframework.springwebapp.domain.Publisher;
import firstspring.springframework.springwebapp.repositories.AuthorRepository;
import firstspring.springframework.springwebapp.repositories.BookRepository;
import firstspring.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepositor, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepositor;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Author turgut = new Author("Turgut", "Uyar");
        Book gbd = new Book("Göğe bakma durağı", "123123");
        Publisher publisher = new Publisher();
        publisher.setName("Ata Yayıncılık");
        publisher.setCity("Eskişehir");
        publisher.setState("Tepebaşı");
        this.publisherRepository.save(publisher);
        System.out.println("Publisher Count : " + this.publisherRepository.count());
        turgut.getBooks().add(gbd);
        gbd.getAuthors().add(turgut);
        gbd.setPublisher(publisher);
        publisher.getBooks().add(gbd);
        this.authorRepository.save(turgut);
        this.bookRepository.save(gbd);
        this.publisherRepository.save(publisher);
        Author cemal = new Author("Cemal", "Süreya");
        Book ss = new Book("Sevda Sözleri", "321321");
        cemal.getBooks().add(ss);
        ss.getAuthors().add(cemal);
        ss.setPublisher(publisher);
        publisher.getBooks().add(ss);
        this.authorRepository.save(cemal);
        this.bookRepository.save(ss);
        this.publisherRepository.save(publisher);
        System.out.println("Number of Books: " + this.bookRepository.count());
        System.out.println("Publisher Number of Books :" + publisher.getBooks().size());
    }
}
