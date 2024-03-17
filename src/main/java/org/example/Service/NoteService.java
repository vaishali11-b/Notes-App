package org.example.Service;

import org.example.Entity.Note;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class NoteService {
    private Map<String, Note> map = new HashMap<>();

    @Async
    public Note createNote(String name, String content) {
        Note newNote = new Note();
        newNote.setName(name);
        newNote.setContent(content);
        map.put(name, newNote);
        return newNote;
    }
    @Async
    public String deleteNote(String name) {
        Note ret = map.remove(name);
        if (null == ret) {
            return name + " note not found";
        }
        return "Deleted note " + name;
    }
    @Async
    public String updateNote(String name, String newContent) {
        if (map.containsKey(name)) {
            Note newNote = new Note();
            newNote.setName(name);
            newNote.setContent(newContent);
            map.put(name, newNote);
        }
        return newContent;
    }
    @Async
    public String viewNote(String name) {
        Note note = map.get(name);
        if (null != note)
            return note.getContent();
        else
            return "No note found with name " + name;
    }
    @Async
    public Map<String, String> allNotes() {
        Map<String, String> ret = new HashMap<>();
        for (Note n : map.values()) {
            ret.put(n.getName(), n.getContent());
        }
        return ret;
    }
}
