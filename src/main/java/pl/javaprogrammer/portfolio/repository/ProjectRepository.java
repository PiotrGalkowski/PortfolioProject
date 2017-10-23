package pl.javaprogrammer.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javaprogrammer.portfolio.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{
    List<Project> findAll();
}
