package dev.lubna.JA.controller;

import dev.lubna.JA.service.UserService;
import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.model.User;
import dev.lubna.JA.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping("/{userName}")
    public ResponseEntity<? > getJournalEntry(@PathVariable String userName){

        try {
            return (ResponseEntity<List<JournalEntry>>) new ResponseEntity<>( journalEntryService.getAllEntries(userName) , HttpStatus.OK);

        }
        catch (Exception e){
            return  new  ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{journalId}")
    public ResponseEntity getEntryById(@PathVariable Long journalId){
        Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(journalId);
        if (journalEntry.isPresent()){
            return new ResponseEntity(journalEntry , HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/{username}")
    public  ResponseEntity postJournalEntry(@RequestBody JournalEntry entry , @PathVariable String username){
        try {

           String res =   journalEntryService.saveJournalEntry(entry , username);


            return new  ResponseEntity(res, HttpStatus.CREATED);
        }
        catch (Exception e){
             return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("id/{pathId}")
    public  ResponseEntity<JournalEntry> updateJournalEntryById(@RequestBody JournalEntry newEntry , @PathVariable Long pathId ){
       try {
           JournalEntry old = journalEntryService.updateById(pathId).orElse(null);
           if (old != null){
               old.setTitle(newEntry.title != null ? newEntry.title : old.title);
               old.setContent(newEntry.content != null ? newEntry.content : old.content );
           }
//           journalEntryService.saveJournalEntry(old);
           return  new ResponseEntity<>(old , HttpStatus.CREATED)  ;
       }
       catch (Exception e){
           return new ResponseEntity<>( HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping("id/{pathId}")
    public String deleteJournalEntryById(@PathVariable Long pathId){
        journalEntryService.deleteById(pathId);
        return  pathId + "is Deleted !";
    }

}
