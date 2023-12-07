package com.example.demoapi.Controllers;
import com.example.demoapi.Models.Dtos.NoteReadDTO;
import com.example.demoapi.Models.Dtos.NoteCreateDTO;
import com.example.demoapi.Models.Dtos.NoteUpdateDTO;

import com.example.demoapi.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Get all notes
    @GetMapping
    public ResponseEntity<List<NoteReadDTO>> getAllNotes() {
        List<NoteReadDTO> notes = noteService.getAllNotes();
        return ResponseEntity.ok().body(notes);
    }

    // Get a single note by ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteReadDTO> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new note
    @PostMapping
    public ResponseEntity<NoteReadDTO> createNote(@RequestBody NoteCreateDTO noteCreateDTO) {
        NoteReadDTO newNote = noteService.addNote(noteCreateDTO);
        return ResponseEntity.ok().body(newNote);
    }

    // Update an existing note
    @PutMapping("/{id}")
    public ResponseEntity<NoteReadDTO> updateNote(@PathVariable Long id, @RequestBody NoteUpdateDTO noteUpdateDTO) {
        NoteReadDTO updatedNote = noteService.updateNote(id, noteUpdateDTO);
        return ResponseEntity.ok().body(updatedNote);
    }

    // Delete a note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
