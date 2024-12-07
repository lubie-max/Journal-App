package dev.lubna.JA.service;

import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.JournalEntryRepo;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;  // Dependency Injection

    @Autowired
    private UserRepo userRepo ;


    public  String  saveJournalEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
        return  null;
    }

    public List<JournalEntry> getAllEntries(String username){

        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()){
            List<JournalEntry> journalEntries;
            journalEntries = user.get().getJournalEntries();
            return journalEntries;

        }
        return null;
    }

    public Optional<JournalEntry> getEntryById(UUID Id){
        return  journalEntryRepo.findById(Id);

    }



    public Optional<JournalEntry> updateJournalEntry(UUID id , String username ,JournalEntry newEntry){
        Optional<User> existingUser = userRepo.findByUsername(username);
        if (existingUser.isEmpty()) {
           return Optional.empty();
        }

        User user = existingUser.get();
        Optional<JournalEntry> oldJournalEntryOptional = user.getJournalEntries().stream().filter(e -> e.getId().equals(id)).findFirst();

        if (oldJournalEntryOptional.isEmpty()){
            System.out.println("journal entry is not found :" + id);
            return  Optional.empty();
        }

        JournalEntry oldEntry = oldJournalEntryOptional.get();

        if (newEntry.getTitle() != null || !newEntry.getTitle().isBlank()  &&  !newEntry.getContent().isBlank()){
            oldEntry.setTitle(newEntry.getTitle());
            oldEntry.setContent(newEntry.getContent());
        }
        journalEntryRepo.save(oldEntry);

        return  Optional.of(oldEntry);

    }

    public  void deleteById(UUID Id){
          journalEntryRepo.deleteById(Id);
    }

}
