package dev.lubna.JA.service;

import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.model.Users;
import dev.lubna.JA.repository.JournalEntryRepo;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;  // Dependency Injection

    @Autowired
    private UserRepo userRepo ;


    @Transactional
    public  Boolean  saveJournalEntry(JournalEntry journalEntry , String username){

        try {
            Users usersOptional = userRepo.findByUsername(username);
            if (usersOptional == null ){
                return false;
            }

            Users user = usersOptional;
            List<JournalEntry> userJournalEntries = user.getJournalEntries();

            if (journalEntry.title.isBlank() || journalEntry.title.isEmpty()){
                return  false;
            }
            userJournalEntries.add(journalEntry);
            journalEntry.setUser(user);
            journalEntryRepo.save(journalEntry);
//
            userRepo.save(user);


            return true;


        }
        catch (Exception e){
             e.printStackTrace();
            throw  e ;

//             return  "Something went wrong";
        }

    }



    public List<JournalEntry> getAllEntries(String username){

        Users users = userRepo.findByUsername(username);
        if (users != null){
            List<JournalEntry> journalEntries;
            journalEntries = users.getJournalEntries();
            return journalEntries;

        }
        return null;
    }

    public Optional<JournalEntry> getEntryById(UUID Id){
        return  journalEntryRepo.findById(Id);

    }



    public Optional<JournalEntry> updateJournalEntry(UUID uuid , String username ,JournalEntry newEntry){
        Users existingUsers = userRepo.findByUsername(username);
        if (existingUsers == null) {
           return Optional.empty();
        }

        Users users = existingUsers;
        Optional<JournalEntry> oldJournalEntryOptional = users.getJournalEntries().stream().filter(e -> e.getId().equals(uuid)).findFirst();

        if (oldJournalEntryOptional.isEmpty()){
            System.out.println("journal entry is not found :" + uuid);
            return  Optional.empty();
        }

        JournalEntry oldEntry = oldJournalEntryOptional.get();

        oldEntry.setTitle(newEntry.getTitle());
        oldEntry.setContent(newEntry.getContent());
        oldEntry.setUpdatedAt(LocalDateTime.now());
        journalEntryRepo.save(oldEntry);

        return  Optional.of(oldEntry);

    }

    public  void deleteById(UUID Id){
          journalEntryRepo.deleteById(Id);
    }

}
