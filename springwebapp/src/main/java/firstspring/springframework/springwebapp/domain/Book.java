package firstspring.springframework.springwebapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private String title;
    private String isbn;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(
                    name = "book_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "author_id"
            )}
    )
    private Set<Author> authors = new HashSet();

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Book book = (Book)o;
            return this.id != null ? this.id.equals(book.id) : book.id == null;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toString() {
        return "Book{id=" + this.id + ", title='" + this.title + '\'' + ", isbn='" + this.isbn + '\'' + ", authors=" + this.authors + '}';
    }
}
