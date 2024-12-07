package dev.lubna.JA.repository;

import dev.lubna.JA.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JournalEntryRepo extends JpaRepository<JournalEntry, UUID> {
}


// controller --> service --> repository ko