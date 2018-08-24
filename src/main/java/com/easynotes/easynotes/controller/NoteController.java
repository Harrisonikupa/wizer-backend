package com.easynotes.easynotes.controller;

import com.easynotes.easynotes.exception.ResourceNotFoundException;
import com.easynotes.easynotes.model.Note;
import com.easynotes.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController //combination of @Controller and @ResponseBody
@RequestMapping("/api") //Declares that the url for all the apis in this controller should start with /api

public class NoteController {
  @Autowired
  NoteRepository noteRepository;

//Get all notes
@GetMapping("/notes")
public List<Note> getAllNotes() {
  return noteRepository.findAll();
}

@PostMapping("/notes")
public Note createNote(@Valid Note note) {
  //@Valid checks if the request body is valid. all this is based on the Note model that was created
  return noteRepository.save(note);
}

@GetMapping("/notes/{id}")
public Note getNoteById(@PathVariable(value = "id") Long noteId) {
  //PathVariable is used to bind a PathVariable with a method parameter
  return noteRepository.findById(noteId).orElse(null);
}

@PutMapping("/notes/{id}")
public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid Note noteDetails) {
  Note note = noteRepository.findById(noteId).get();

    note.setTitle(noteDetails.getTitle());
    note.setContent(noteDetails.getContent());

    Note updatedNote = noteRepository.save(note);
    return updatedNote;
}

@DeleteMapping("notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
  Note note = noteRepository.findById(noteId).get();

    noteRepository.delete(note);

    return ResponseEntity.ok().build();
}

}
