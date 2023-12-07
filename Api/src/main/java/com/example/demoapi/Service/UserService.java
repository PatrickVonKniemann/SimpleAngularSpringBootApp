package com.example.demoapi.Service;
import com.example.demoapi.Models.AppUserReadDTO;
import com.example.demoapi.Repository.UserRepository;
import com.example.demoapi.Models.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<AppUser> getAllItems() {
        return this.userRepository.findAll();
    }

    public Optional<AppUser> getItem(Long id) {
        return this.userRepository.findById(id);
    }

    public void addItem(AppUser appUser) {
        this.userRepository.save(appUser);
    }

    public AppUser updateUser(Long id, AppUser appUserDetails) {
        AppUser appUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        appUser.setName(appUserDetails.getName());
        // Set other fields...
        return userRepository.save(appUser);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
