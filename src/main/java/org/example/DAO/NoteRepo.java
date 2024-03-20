package org.example.DAO;

import org.example.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, String> {
//    List<Note> findAll();
}