package az.turbo.repository;

import az.turbo.entity.Allspecs;
import az.turbo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface AllSpecsRepository extends JpaRepository<Allspecs,Long> {

    @Query(nativeQuery = true, value = "SELECT a.price, c.*, m.*, a.year,  a.engine, a.march, a.region, a.creation_date " +
            "FROM turbo.allspecs a " +
            "JOIN cars c ON a.car_id = c.id " +
            "JOIN model m ON a.model_id = m.id")
    List<Object> findSomeFields();
    List<Allspecs> findByCarName(String carName);
    List<Allspecs> findByCarNameAndModelName(String carName,String modelName);
    List<Allspecs> findByCarNameAndModelNameOrderByCreationDateDesc(String carName, String modelName);
    List<Allspecs> findByCarNameOrderByCreationDateDesc(String carName);
    List<Allspecs> findByCarNameOrderByPriceAsc(String carName);
    List<Allspecs> findByCarNameAndModelNameOrderByPriceAsc(String carName, String carModel);
    List<Allspecs> findByCarNameOrderByPriceDesc(String carName);
    List<Allspecs> findByCarNameAndModelNameOrderByPriceDesc(String carName, String carModel);
    List<Allspecs> findByCarNameOrderByMarchAsc(String carName);
    List<Allspecs> findByCarNameAndModelNameOrderByMarchAsc(String carName, String carModel);

    List<Allspecs> findByCarNameOrderByYearDesc(String carName);
    List<Allspecs> findByCarNameAndModelNameOrderByYearDesc(String carName, String carModel);



}
