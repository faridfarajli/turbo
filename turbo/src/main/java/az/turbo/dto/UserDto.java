package az.turbo.dto;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String surname,
        String email,
        String password,
        Long phoneNumber

) {
}
