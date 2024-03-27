package az.turbo.service;

import az.turbo.dto.UserDto;
import az.turbo.entity.Role;
import az.turbo.entity.User;
import az.turbo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User createUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.id());
        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setPhoneNumber(userDto.phoneNumber());
        user.setRole(Role.USER);
        userRepository.save(user);
        return user;
    }

}
