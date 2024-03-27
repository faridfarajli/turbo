package az.turbo.repository;

import az.turbo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
  boolean existsByName(String name);

   Car findByName(String car);
}
