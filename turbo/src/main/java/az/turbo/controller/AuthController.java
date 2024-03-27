package az.turbo.controller;


import az.turbo.dto.*;
import az.turbo.entity.Allspecs;
import az.turbo.entity.Car;
import az.turbo.entity.Model;
import az.turbo.entity.User;
import az.turbo.service.AllSpecsService;
import az.turbo.service.CarService;
import az.turbo.service.ModelService;
import az.turbo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final CarService carService;
    private final ModelService modelService;
    private final AllSpecsService allSpecsService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDto userDto){
        Authentication authenticationToken =new UsernamePasswordAuthenticationToken(userDto.email(),userDto.password());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(authentication);
    }

    @PostMapping("/register")
    public User register (@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }


    @PostMapping("/create/car")
    public Car createCar(@RequestBody CarDto carDto){
       return carService.createCar(carDto);
    }

    @PostMapping("/create/model")
    public Model createModel(@RequestBody ModelDto modelDto){
        return modelService.createModel(modelDto);
    }

    @PostMapping("/create/specs")
    public Allspecs createAllSpecs(@RequestBody AllSpecsDto allSpecsDto){
        return allSpecsService.createCarSpecs(allSpecsDto);
    }

    @GetMapping("/find-all")
    public List<Object> findAll(){
        return allSpecsService.getSpecificFields();
    }

    @PostMapping("/find{id}")
    public Allspecs find(@PathVariable(value = "id") Long id){
        return allSpecsService.findById(id);
    }

    @GetMapping("/by-car")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarName(@RequestParam("carName") String carName) {
        List<Allspecs> allSpecs = allSpecsService.findByCarName(carName);
        if (allSpecs != null && !allSpecs.isEmpty()) {
            return ResponseEntity.ok(allSpecs);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/by-car-model")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameAndModelName(
            @RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
      List<Allspecs> allSpecs =     allSpecsService.findByCarNameAndModelName(carName,carModel);
        if (allSpecs != null && !allSpecs.isEmpty()) {
            return ResponseEntity.ok(allSpecs);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-model-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameAndModelNameOrderByCreationDateDesc(
            @RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
        List<Allspecs> allSpecs =     allSpecsService.findByCarNameAndModelNameOrderByCreationDateDesc(carName,carModel);
        if (allSpecs != null && !allSpecs.isEmpty()) {
            return ResponseEntity.ok(allSpecs);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/by-car-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarOrderByCreationDateDesc(@RequestParam("carName") String carName){
       List<Allspecs> allSpecs = allSpecsService.findByCarOrderByCreationDesc(carName);
       if (allSpecs!=null && !allSpecs.isEmpty()){
           return ResponseEntity.ok(allSpecs);
       }else {
           return ResponseEntity.notFound().build();
       }

    }


    @GetMapping("/by-car-price-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarOrderByPriceDateDesc(@RequestParam("carName") String carName){
        List<Allspecs> allSpecs = allSpecsService.findByCarOrderByPriceDesc(carName);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-model-price-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarAndModelNameOrderByPriceDateDesc(@RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameAndModelNameOrderByPriceDesc(carName,carModel);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-price-asc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarOrderByPriceDateAsc(@RequestParam("carName") String carName){
        List<Allspecs> allSpecs = allSpecsService.findByCarOrderByPriceAsc(carName);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-model-price-asc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarAndModelNameOrderByPriceDateAsc(@RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameAndModelNameOrderByPriceAsc(carName,carModel);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/by-car-march-asc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameOrderByMarchAsc(@RequestParam("carName") String carName){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameOrderByMarchAsc(carName);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-model-march-asc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameAndModelNameOrderByMarchAsc(@RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameAndModelNameOrderByMarchAsc(carName,carModel);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-year-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameOrderByYearDesc(@RequestParam("carName") String carName){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameOrderByYearDesc(carName);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/by-car-model-year-desc")
    public ResponseEntity<List<Allspecs>> getAllSpecsByCarNameAndModelNameOrderByYearDesc(@RequestParam("carName") String carName, @RequestParam("carModel") String carModel){
        List<Allspecs> allSpecs = allSpecsService.findByCarNameAndModelNameOrderByYearDesc(carName,carModel);
        if (allSpecs!=null && !allSpecs.isEmpty()){
            return ResponseEntity.ok(allSpecs);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete{id}")
    public void deleteById(@PathVariable("id") Long id){
        allSpecsService.deleteById(id);

    }


}
