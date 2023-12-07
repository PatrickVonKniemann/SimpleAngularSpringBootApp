package com.example.demoapi.Service;

import com.example.demoapi.Models.Dtos.NoteCreateDTO;
import com.example.demoapi.Models.Dtos.NoteReadDTO;
import com.example.demoapi.Models.Dtos.NoteUpdateDTO;
import com.example.demoapi.Repository.NoteRepository;
import com.example.demoapi.Models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Get all notes
    public List<NoteReadDTO> getAllNotes() {
        return this.noteRepository.findAll().stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }

    // Get a single note by ID
    public Optional<NoteReadDTO> getNoteById(Long id) {
        return this.noteRepository.findById(id)
                .map(this::convertToReadDTO);
    }

    // Add a new note
    public NoteReadDTO addNote(NoteCreateDTO noteCreateDTO) {
        Note note = new Note();
        note.setContent(noteCreateDTO.getContent());
        // Set other fields if necessary...
        Note savedNote = noteRepository.save(note);
        return convertToReadDTO(savedNote);
    }

    // Update an existing note
    public NoteReadDTO updateNote(Long id, NoteUpdateDTO noteToUpdateDTO) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setContent(noteToUpdateDTO.getContent());
        // Update other fields as necessary...
        Note updatedNote = noteRepository.save(note);
        return convertToReadDTO(updatedNote);
    }

    // Delete a note
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    private NoteReadDTO convertToReadDTO(Note note) {
        NoteReadDTO dto = new NoteReadDTO();
        dto.setId(note.getId());
        dto.setContent(note.getContent());
        // Set other fields
        return dto;
    }
}
