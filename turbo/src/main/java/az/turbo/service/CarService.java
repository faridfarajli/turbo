package az.turbo.service;


import az.turbo.dto.CarDto;
import az.turbo.entity.Car;
import az.turbo.entity.CarEnum;
import az.turbo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CarService {

    private final CarRepository carRepository;

    public Car createCar(CarDto carDto){
        Car car =  new Car();
        car.setId(carDto.id());
        car.setName(carDto.name());
        carRepository.save(car);
        return car;
    }
}
