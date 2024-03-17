package org.example.Controller;

import org.example.Entity.Note;
import org.example.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
/*
    @RequestMapping("/error")
    public String error() {
        return "Error Handling";
    }
*/
    @PostMapping("/note")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedNote = noteService.createNote(note.getName(), note.getContent());
        return ResponseEntity.ok(savedNote);
    }

    @GetMapping("/allNote")
    public ResponseEntity<Map<String, String>> allNotes() {
        Map<String, String> note = noteService.allNotes();
        return ResponseEntity.ok(note);
    }

    @GetMapping("/view/{name}")
    public ResponseEntity<String> viewNote(@PathVariable String name) {
        String view = noteService.viewNote(name);
        return ResponseEntity.ok(view);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateNote(
            @RequestParam (value = "name") String name,
            @RequestParam (value = "content") String newContent) {
        String updated = noteService.updateNote(name, newContent);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteNote(@PathVariable String name){
        String deleted = noteService.deleteNote(name);
        return ResponseEntity.ok(deleted);
    }
}
