package com.example.demoapi.Controllers;

import com.example.demoapi.Models.Note;
import com.example.demoapi.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // Get a single note by ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new note
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note newNote = noteService.addNote(note);
        return ResponseEntity.ok().body(newNote);
    }

    // Update an existing note
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note updatedNote = noteService.updateNote(id, noteDetails);
        return ResponseEntity.ok().body(updatedNote);
    }

    // Delete a note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}