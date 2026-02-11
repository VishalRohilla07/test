package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{myid}")
    public JournalEntry getEntryById(@PathVariable Long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("/delete/{myid}")
    public  JournalEntry deleteEntryById(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("/update/{myid}")
    public JournalEntry updateEntryById(@PathVariable Long myid, @RequestBody JournalEntry entry){
        return journalEntries.put(myid, entry);
    }
}
