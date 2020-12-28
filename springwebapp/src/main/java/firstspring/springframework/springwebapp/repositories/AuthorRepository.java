package firstspring.springframework.springwebapp.repositories;

import firstspring.springframework.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
