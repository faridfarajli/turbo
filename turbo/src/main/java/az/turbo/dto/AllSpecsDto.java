package az.turbo.dto;

import az.turbo.entity.Car;
import az.turbo.entity.Model;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record AllSpecsDto(
         Long id,
         String region,
         Car car,
       Model model,
         Long year,
         String typeOfBan,
         String color,
         Long march,
         String gearBox,
         String gear,
         String newOrOld,
         String numberOfSeats,
         String owners,
         String theSituation,
         String about,
         Long advertisementNumber,
         String tag,
        Long price,
         Long phoneNumber,
        Long countOfView,
        LocalDateTime creationDate,
         Double engine




) {

}
