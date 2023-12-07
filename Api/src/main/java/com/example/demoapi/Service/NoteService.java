package com.example.demoapi.Service;
import com.example.demoapi.Repository.NoteRepository;
import com.example.demoapi.Models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Get all notes
    public List<Note> getAllNotes() {
        return this.noteRepository.findAll();
    }

    // Get a single note by ID
    public Optional<Note> getNoteById(Long id) {
        return this.noteRepository.findById(id);
    }

    // Add a new note
    public Note addNote(Note note) {
        return this.noteRepository.save(note);
    }

    // Update an existing note
    public Note updateNote(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setContent(noteDetails.getContent());
        // Set other fields if necessary...
        return noteRepository.save(note);
    }

    // Delete a note
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
