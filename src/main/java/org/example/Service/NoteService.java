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
    /*
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }
     */

    public void createNote(String name, String content) {
        Note newNote = new Note();
        newNote.setName(name);
        newNote.setContent(content);
        map.put(name, newNote);
    }

    public String deleteNote(String name) {
        Note ret = map.remove(name);
        if (null == ret) {
            return name + " note not found";
        }
        return "Deleted note " + name;
    }

    public String updateNote(String name, String newContent) {
        if (map.containsKey(name)) {
            Note newNote = new Note();
            newNote.setName(name);
            newNote.setContent(newContent);
            map.put(name, newNote);
            return name + " updated";
        }
        return name + " note not found";
    }

    public String viewNote(String name) {
        Note note = map.get(name);
        if (null != note)
            return note.getContent();
        else
            return "No note found with name " + name;
    }

    public List<Note> allNotes() {
        return new ArrayList<>(map.values());
        //return noteRepo.findAll();
    }
}
