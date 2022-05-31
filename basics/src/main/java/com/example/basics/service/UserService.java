package com.example.basics.service;

import com.example.basics.exceptions.UserNotFoundException;
import com.example.basics.model.Users;
import com.example.basics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users findById(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    //    public Users saveUser(LoginDTO loginDTO){
//        return userRepository.save(loginDTO.toUsers());
//    }

    public void insertAdminUser() {
        if (userRepository.findByLoginIgnoreCase("admin") == null) {
            log.debug("Administrator user not found, creating...");
            final var user = new Users();
            user.setName("Administrator");
            user.setLogin("admin");
            user.setAdmin(true);
            user.setActive(true);
            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
            user.setEmail("email@email.com");
            userRepository.save(user);
        } else {
            log.warn("Error: user not found");
        }
    }
}


