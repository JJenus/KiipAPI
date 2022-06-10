package com.jjenus.app.KiipAPI.service;

import com.jjenus.app.KiipAPI.model.Snippet;
import com.jjenus.app.KiipAPI.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SnippetService {
    private final SnippetRepository repository;
    @Autowired
    public SnippetService(SnippetRepository repository) {
        this.repository = repository;
    }

    public Snippet getSnippet(Long id){
        return repository.findById(id).orElseThrow(()->{
            throw new IllegalStateException("Snippet not found");
        });
    }

    public List<Snippet> getSnippets(){
        return repository.findAll();
    }

    public Snippet saveSnippet(Snippet snippet){
        return repository.save(snippet);
    }

    public void deleteSnippet(Long id){
        if (!repository.existsById(id)){
            throw new IllegalStateException("No snippet with id "+id);
        }
        repository.deleteById(id);
    }

    public Snippet updateSnippet(Snippet newSnippet, Long id) {
        if (!repository.existsById(id)){
            throw new IllegalStateException("No snippet with id "+id);
        }
        return repository.findById(id).map(snippet->{
            snippet.setTitle(newSnippet.getTitle());
            snippet.setTags(newSnippet.getTags());
            snippet.setDescription(newSnippet.getDescription());
            snippet.setLanguage(newSnippet.getLanguage());
            return repository.save(snippet);
        }).orElseThrow(()->{
            throw new IllegalStateException("Snippet does not exist");
        });
    }
}
