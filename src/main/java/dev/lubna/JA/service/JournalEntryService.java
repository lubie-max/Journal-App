package dev.lubna.JA.service;

import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;  // Dependency Injection


    public  void  saveJournalEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getEntryById(Long Id){
        return  journalEntryRepo.findById(Id);

    }

    public Optional<JournalEntry> updateById(Long Id){
        return   journalEntryRepo.findById(Id);
    }

    public  void deleteById(Long Id){
          journalEntryRepo.deleteById(Id);
    }

}
