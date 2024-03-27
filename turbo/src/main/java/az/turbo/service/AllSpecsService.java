package az.turbo.service;

import az.turbo.dto.AllSpecsDto;
import az.turbo.entity.Allspecs;
import az.turbo.entity.Car;
import az.turbo.entity.Model;
import az.turbo.repository.AllSpecsRepository;
import az.turbo.repository.CarRepository;
import az.turbo.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AllSpecsService {
    private final AllSpecsRepository allSpecsRepository;
    private final CarRepository carRepository;
    private final ModelRepository modelRepository;


    public Allspecs createCarSpecs(AllSpecsDto allSpecsDto) {
        Car car = carRepository.findByName(allSpecsDto.car().getName());
        Model model = modelRepository.findByName(allSpecsDto.model().getName());
        Allspecs allSpecs = new Allspecs();
        allSpecs.setId(allSpecsDto.id());
        allSpecs.setRegion(allSpecsDto.region());
        allSpecs.setCar(car);
        allSpecs.setModel(model);
        allSpecs.setYear(allSpecsDto.year());
        allSpecs.setTypeOfBan(allSpecsDto.typeOfBan());
        allSpecs.setColor(allSpecsDto.color());
        allSpecs.setMarch(allSpecsDto.march());
        allSpecs.setGearBox(allSpecsDto.gearBox());
        allSpecs.setGear(allSpecsDto.gear());
        allSpecs.setNewOrOld(allSpecsDto.newOrOld());
        allSpecs.setNumberOfSeats(allSpecsDto.numberOfSeats());
        allSpecs.setOwners(allSpecsDto.owners());
        allSpecs.setTheSituation(allSpecsDto.theSituation());
        allSpecs.setPhoneNumber(allSpecsDto.phoneNumber());
        allSpecs.setPhoneNumber(allSpecsDto.phoneNumber());
        allSpecs.setAbout(allSpecsDto.about());
        allSpecs.setTag(allSpecsDto.tag());
        allSpecs.setPrice(allSpecsDto.price());
        allSpecs.setCountOfView(allSpecsDto.countOfView());
        allSpecs.setCreationDate(allSpecsDto.creationDate());
        allSpecs.setEngine(allSpecsDto.engine());
        allSpecsRepository.save(allSpecs);
        return allSpecs;

    }

    public List<Object> getSpecificFields() {
        return allSpecsRepository.findSomeFields();

    }

    @SneakyThrows
    public Allspecs findById(Long id) {
            Allspecs idi = allSpecsRepository.findById(id).orElseThrow();
            idi.setCountOfView(idi.getCountOfView() + 1L);
            allSpecsRepository.save(idi);
            return idi;
        }

        public List<Allspecs> findByCarName(String carName){
        return (List<Allspecs>) allSpecsRepository.findByCarName(carName);
        }

        public List<Allspecs> findByCarNameAndModelName(String carName, String modelName){
        return allSpecsRepository.findByCarNameAndModelName(carName,modelName);
        }

    public List<Allspecs> findByCarNameAndModelNameOrderByCreationDateDesc(String carName, String modelName){
        return allSpecsRepository.findByCarNameAndModelNameOrderByCreationDateDesc(carName,modelName);
    }


    public List<Allspecs> findByCarOrderByCreationDesc(String carName){
        return  allSpecsRepository.findByCarNameOrderByCreationDateDesc(carName);
    }

    public List<Allspecs> findByCarOrderByPriceAsc(String carName){
        return  allSpecsRepository.findByCarNameOrderByPriceAsc(carName);
    }


    public List<Allspecs> findByCarNameAndModelNameOrderByPriceAsc(String carName, String carModel){
        return  allSpecsRepository.findByCarNameAndModelNameOrderByPriceAsc(carName,carModel);
    }

    public List<Allspecs> findByCarOrderByPriceDesc(String carName){
        return  allSpecsRepository.findByCarNameOrderByPriceDesc(carName);
    }


    public List<Allspecs> findByCarNameAndModelNameOrderByPriceDesc(String carName, String carModel){
        return  allSpecsRepository.findByCarNameAndModelNameOrderByPriceDesc(carName,carModel);
    }


    public List<Allspecs> findByCarNameOrderByMarchAsc(String carName){
        return allSpecsRepository.findByCarNameOrderByMarchAsc(carName);
    }

    public List<Allspecs> findByCarNameAndModelNameOrderByMarchAsc(String carName, String carModel){
        return allSpecsRepository.findByCarNameAndModelNameOrderByMarchAsc(carName,carModel);
    }


    public List<Allspecs> findByCarNameOrderByYearDesc(String carName){
        return allSpecsRepository.findByCarNameOrderByYearDesc(carName);
    }

    public List<Allspecs> findByCarNameAndModelNameOrderByYearDesc(String carName, String carModel){
        return allSpecsRepository.findByCarNameAndModelNameOrderByYearDesc(carName,carModel);
    }

    public void deleteById(Long id){
        Optional<Allspecs> optionalAllspecs = allSpecsRepository.findById(id);
        if (optionalAllspecs.isPresent()) {
            Allspecs a = optionalAllspecs.get();
            allSpecsRepository.delete(a);
        } else {
            throw new NoSuchElementException("Allspecs with id " + id + " not found");
        }
    }

    }


