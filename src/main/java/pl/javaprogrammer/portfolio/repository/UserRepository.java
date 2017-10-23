package pl.javaprogrammer.portfolio.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javaprogrammer.portfolio.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    Optional<User> findByUsername(String username);
    Optional<User> findAll(Pageable pageable);
}
