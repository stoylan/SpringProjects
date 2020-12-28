package firstspring.springframework.springwebapp.repositories;

import firstspring.springframework.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
