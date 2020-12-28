package firstspring.springframework.springwebapp.repositories;

import firstspring.springframework.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
