package pl.javaprogrammer.portfolio.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javaprogrammer.portfolio.entity.About;

import javax.persistence.NamedNativeQuery;
import java.lang.annotation.Native;


@Repository
public interface AboutRepository extends CrudRepository<About, Integer> {
}
