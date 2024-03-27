package az.turbo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Allspecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Car car;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Model model;
    private Long year;
    private String typeOfBan;
    private String color;
    private Long march;
    private String gearBox;
    private String gear;
    private String newOrOld;
    private String numberOfSeats;
    private String owners;
    private String theSituation;
    private String about;
    private String tag;
    private Long price;
    private Long phoneNumber;
    private Long countOfView;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime creationDate;
    private Double engine;





}
