package dev.lubna.JA.controller;


import dev.lubna.JA.model.JournalEntry;
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

    @GetMapping("/{username}")
    public ResponseEntity<List<JournalEntry> > getJournalEntry(@PathVariable String username){
        try {

            List<JournalEntry>  journalEntries = journalEntryService.getAllEntries(username);
            return (ResponseEntity<List<JournalEntry>>) new ResponseEntity<>( journalEntries, HttpStatus.OK);

        }
        catch (Exception e){
            return  new  ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{pathId}")
    public ResponseEntity getEntryById(@PathVariable UUID pathId){
        Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(pathId);
        if (journalEntry.isPresent()){
            return new ResponseEntity(journalEntry , HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{username}")
    public  ResponseEntity<?> postJournalEntry(@RequestBody JournalEntry entry , @PathVariable String username){

            Boolean res =  journalEntryService.saveJournalEntry(entry ,username);
            if (res){
                return new  ResponseEntity<>( "Entry is enrolled!", HttpStatus.OK);

            }
            return  new ResponseEntity<>("Check title if blank or User is valid !" , HttpStatus.BAD_REQUEST);


    }

    @PutMapping("id/{username}/{journalId}")
    public  ResponseEntity<?> updateJournalEntryById(@RequestBody JournalEntry newEntry , @PathVariable UUID journalId , String username ){
       try {

           Optional<JournalEntry> res = journalEntryService.updateJournalEntry(journalId, username , newEntry);
           return  new ResponseEntity<>(res , HttpStatus.CREATED)  ;
       }
       catch (Exception e){
           return new ResponseEntity<>( HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping("id/{pathId}")
    public String deleteJournalEntryById(@PathVariable UUID

 pathId){
        journalEntryService.deleteById(pathId);
        return  pathId + "is Deleted !";
    }

}
