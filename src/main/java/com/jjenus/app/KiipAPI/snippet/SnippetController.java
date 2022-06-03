package com.jjenus.app.KiipAPI.snippet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/snippets")
public class SnippetController {
    private final SnippetService snippetService;

    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @PostMapping
    public ResponseEntity<Snippet> newSnippet(@RequestBody Snippet newSnippet){
        Snippet snippet = snippetService.saveSnippet(newSnippet);
        return new ResponseEntity<>(snippet, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Snippet> getSnippets(){
        return snippetService.getSnippets();
    }

    @PutMapping
    public Snippet updateSnippet(@RequestBody Snippet snippet){
        System.out.println(snippet.getId());
        return snippetService.updateSnippet(snippet, snippet.getId());
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        snippetService.deleteSnippet(id);
    }
}
