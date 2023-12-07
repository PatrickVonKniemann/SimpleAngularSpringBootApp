package com.example.demoapi.Service;

import com.example.demoapi.Models.Dtos.AppUserCreateDTO;
import com.example.demoapi.Models.Dtos.AppUserReadDTO;
import com.example.demoapi.Models.Dtos.AppUserUpdateDTO;
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

    public List<AppUserReadDTO> getAllItems() {
        return this.userRepository.findAll().stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }

    public Optional<AppUserReadDTO> getItem(Long id) {
        return this.userRepository.findById(id)
                .map(this::convertToReadDTO);
    }

    public AppUserReadDTO addItem(AppUserCreateDTO appUserCreateDTO) {
        AppUser appUser = new AppUser();
        appUser.setName(appUserCreateDTO.getName());
        AppUser savedAppUser = userRepository.save(appUser);
        return convertToReadDTO(savedAppUser);
    }

    public AppUserReadDTO updateUser(Long id, AppUserUpdateDTO appUserUpdateDTO) {
        AppUser appUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        appUser.setName(appUserUpdateDTO.getName());
        AppUser updatedAppUser = userRepository.save(appUser);
        return convertToReadDTO(updatedAppUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private AppUserReadDTO convertToReadDTO(AppUser appUser) {
        AppUserReadDTO dto = new AppUserReadDTO();
        dto.setId(appUser.getId());
        dto.setName(appUser.getName());
        return dto;
    }
}
