package dev.lubna.JA.controller;


import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getJournalEntry(){
        return journalEntryService.getAllEntries() ;
    }

    @GetMapping("id/{pathId}")
    public Optional<JournalEntry> getEntryById(@PathVariable Long pathId){

        return  journalEntryService.getEntryById(pathId);
    }

    @PostMapping
    public  boolean postJournalEntry(@RequestBody JournalEntry entry){
          journalEntryService.saveJournalEntry(entry);
          return  true ;

    }

    @PutMapping("id/{pathId}")
    public  JournalEntry updateJournalEntryById(@RequestBody JournalEntry newEntry , @PathVariable Long pathId ){
        JournalEntry old = journalEntryService.updateById(pathId).orElse(null);
        if (old != null){
            old.setTitle(newEntry.title != null ? newEntry.content : old.content);
            old.setContent(newEntry.content != null ? newEntry.content : old.content );
        }
        journalEntryService.saveJournalEntry(old);
        return  old  ;
    }

    @DeleteMapping("id/{pathId}")
    public String deleteJournalEntryById(@PathVariable Long pathId){
        journalEntryService.deleteById(pathId);
        return  pathId + "is Deleted !";
    }

}
