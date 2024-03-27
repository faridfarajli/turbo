package az.turbo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private Long phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
