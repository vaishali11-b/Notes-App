package org.example.Service;

import org.example.DAO.NoteRepo;
import org.example.Entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class NoteService {
    private final Map<String, Note> map = new HashMap<>();
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public void createNote(String name, String content) {
        Note newNote = new Note(name, content);
        noteRepo.save(newNote);
    }

    public String deleteNote(String name) {
        Optional<Note> note = noteRepo.findById(name);
        if (!note.isPresent()) {
            return name + " note not found";
        } else {
            noteRepo.deleteById(name);
            return "Deleted note " + name;
        }
    }

    public String updateNote(String name, String newContent) {
        Optional<Note> note = noteRepo.findById(name);
        if (note.isPresent()) {
            Note newNote = note.get();
            newNote.setContent(newContent);
            noteRepo.save(newNote);
            return name + " updated";
        } else {
            return name + " note not found";
        }
    }

    public String viewNote(String name) {
        Optional<Note> value = noteRepo.findById(name);
        if (value.isPresent()) {
            return value.get().getContent();
        } else {
            return "No note found with name " + name;
        }
    }

    public List<Note> allNotes() {
        return noteRepo.findAll();
    }
}
