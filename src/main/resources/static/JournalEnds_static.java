package dev.lubna.JA.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal_static")
public class JournalEnds_static {

//    private Map<String , JournalEntry> journalEntryMap = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getJournalEntry(){
//        return new ArrayList<>(journalEntryMap.values());
//    }
//
//    @GetMapping("id/{pathId}")
//    public  JournalEntry getEntryById(@PathVariable String pathId){
//
//        return  journalEntryMap.get(pathId);
//    }
//
//    @PostMapping
//    public  boolean postJournalEntry(@RequestBody JournalEntry entry){
//
////        journalEntryMap.put(entry.getId() , entry);
//        return  true;
//
//    }
//
//    @PutMapping("id/{pathId}")
//    public  boolean updateJournalEntryById(@RequestBody JournalEntry entry , @PathVariable String pathId ){
//        journalEntryMap.put(pathId, entry);
//        return  true ;
//    }
//
//    @DeleteMapping("id/{pathId}")
//    public String deleteJournalEntryById(@PathVariable String pathId){
//        journalEntryMap.remove(pathId);
//        return  pathId + "is Deleted !";
//    }

}
