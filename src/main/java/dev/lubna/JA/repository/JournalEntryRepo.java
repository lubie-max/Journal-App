package dev.lubna.JA.repository;

import dev.lubna.JA.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepo extends JpaRepository<JournalEntry, Long> {
}


// controller --> service --> repository ko