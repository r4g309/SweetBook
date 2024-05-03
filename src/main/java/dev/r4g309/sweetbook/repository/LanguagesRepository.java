package dev.r4g309.sweetbook.repository;

import dev.r4g309.sweetbook.models.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguagesRepository extends JpaRepository<Languages, Long> {
    Optional<Languages> findByLanguage(String language);
}
