package com.jjenus.app.KiipAPI.snippet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Snippet {
    @Id
    @SequenceGenerator(
            name = "snippet_sequence",
            sequenceName = "snippet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "snippet_sequence"
    )
    private Long id;
    private String title;
    private String tags;
    private String description;
    private String language;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String snippet;
    private boolean makePublic;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onInsert(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
