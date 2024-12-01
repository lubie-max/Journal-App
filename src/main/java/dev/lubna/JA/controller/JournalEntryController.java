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

    @GetMapping
    public ResponseEntity<List<JournalEntry> > getJournalEntry(){
        try {
            return (ResponseEntity<List<JournalEntry>>) new ResponseEntity<>( journalEntryService.getAllEntries() , HttpStatus.OK);

        }
        catch (Exception e){
            return  new  ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{pathId}")
    public ResponseEntity getEntryById(@PathVariable Long pathId){
        Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(pathId);
        if (journalEntry.isPresent()){
            return new ResponseEntity(journalEntry , HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public  ResponseEntity<Boolean> postJournalEntry(@RequestBody JournalEntry entry){
        try {
            journalEntryService.saveJournalEntry(entry);
            return new  ResponseEntity<>(HttpStatus.OK);
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
           journalEntryService.saveJournalEntry(old);
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
