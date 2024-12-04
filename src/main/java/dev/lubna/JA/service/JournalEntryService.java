package dev.lubna.JA.service;

import dev.lubna.JA.model.JournalEntry;
import dev.lubna.JA.model.User;
import dev.lubna.JA.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;  // Dependency Injection


    @Autowired
    private UserService userService;


    public List<JournalEntry> getAllEntries(String username) {

        try {
            Optional<User> user = userService.getUserByName(username);
            if (user.isPresent()) {
                return user.get().getJournalEntries();

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }



    public String saveJournalEntry(JournalEntry journalEntry , String username) {
        try {
            Optional<User> user = userService.getUserByName(username);

            if(user.isPresent()){

//                List<JournalEntry> userJournalEntries = user.get().journalEntries
                journalEntry.setUser(user.get());
                user.get().journalEntries.add(journalEntry);

                 journalEntryRepo.save(journalEntry);


                 return "Entry is added";

            }

            else {
                return  "User is not present / invalid entry";

            }
        }

        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public Optional<JournalEntry> getEntryById(Long Id) {
        return journalEntryRepo.findById(Id);

    }

    public Optional<JournalEntry> updateById(Long Id) {
        return journalEntryRepo.findById(Id);
    }

    public void deleteById(Long Id) {
        journalEntryRepo.deleteById(Id);
    }


}


