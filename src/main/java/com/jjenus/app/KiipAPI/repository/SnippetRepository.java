package com.jjenus.app.KiipAPI.repository;

import com.jjenus.app.KiipAPI.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, Long> {
}
