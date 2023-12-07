package com.example.demoapi.Service;

import com.example.demoapi.Models.Dtos.*;
import com.example.demoapi.Models.JwtTokenUtil;
import com.example.demoapi.Models.Note;
import com.example.demoapi.Repository.UserRepository;
import com.example.demoapi.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
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
        AppUser appUser = new AppUser(password);
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
        List<NoteReadDTO> noteReadDTOs = appUser.getNotes().stream()
                .map(this::convertNoteToReadDTO)
                .collect(Collectors.toList());

        return new AppUserReadDTO(appUser.getId(), appUser.getName(), noteReadDTOs);
    }

    private NoteReadDTO convertNoteToReadDTO(Note note) {
        NoteReadDTO noteReadDTO = new NoteReadDTO();
        noteReadDTO.setId(note.getId());
        noteReadDTO.setContent(note.getContent());
        return noteReadDTO;
    }


    public Optional<AppUser> getItemByName(String name) {
        return this.userRepository.findByName(name);
    }

    public LoginResponseDTO authenticate(LoginRequestDTO loginRequest) throws Exception {
        Optional<AppUser> appUserOpt = userRepository.findByName(loginRequest.getUsername());

        if (!appUserOpt.isPresent() || !passwordMatches(loginRequest.getPassword(), appUserOpt.get().getPassword())) {
            throw new AuthenticationException("Wrong credentials");
        }

        // Generate token or perform additional authentication logic here
        String token = generateToken(appUserOpt.get());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        // set other necessary fields in the response

        return response;

    }

    private boolean passwordMatches(String rawPassword, String storedPassword) {
        return rawPassword.equals(storedPassword);
    }
//    private boolean passwordMatches(String rawPassword, String storedHashedPassword) {
//        // Compare the raw password after hashing with the stored hashed password
//        // You should use a password encoder here, like BCryptPasswordEncoder
//        return passwordEncoder.matches(rawPassword, storedHashedPassword);
//    }

    private String generateToken(AppUser user) {
        return jwtTokenUtil.generateToken(user);
    }
}
