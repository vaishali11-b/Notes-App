package org.example.Controller;

import org.example.Entity.Note;
import org.example.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public String createNote(@RequestBody Note note) {
        noteService.createNote(note.getName(), note.getContent());
        return "Note has been created";
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Note>> viewAllNotes() {
        List<Note> note = noteService.allNotes();
        return ResponseEntity.ok(note);
    }

    @GetMapping("/view")
    public ResponseEntity<String> viewNote(@RequestParam(value = "name") String name) {
        String view = noteService.viewNote(name);
        return ResponseEntity.ok(view);
    }

    @PutMapping("/update")
    public String updateNote(@RequestBody Note note) {
        return noteService.updateNote(note.getName(), note.getContent());
    }

    @DeleteMapping("/delete/{name}")
    public String deleteNote(@PathVariable String name) {
        return noteService.deleteNote(name);
    }
}
