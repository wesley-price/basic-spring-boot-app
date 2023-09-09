package repositories;

import org.springframework.data.repository.CrudRepository;

import domain.*;

public interface BookRepository extends CrudRepository<Books, Long> {
}
