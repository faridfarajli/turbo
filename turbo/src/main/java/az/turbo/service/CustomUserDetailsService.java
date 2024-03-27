package az.turbo.service;

import az.turbo.entity.User;
import az.turbo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user!=null){
            var roles = Stream.of(user.getRole())
                    .map(x-> new SimpleGrantedAuthority(x.name()))
                    .collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),roles);
        }else {
            throw new UsernameNotFoundException("Wrong email or pass");
        }

    }

}
