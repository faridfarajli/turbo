package az.turbo.repository;

import az.turbo.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
    boolean existsByName(String name);

    Model findByName(String name);
}
