package com.tutorial.web_client_spring_boot.controller;

import com.tutorial.web_client_spring_boot.dto.PostsDto;
import com.tutorial.web_client_spring_boot.service.PostsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService){
        this.postsService = postsService;
    }

    @PostMapping
    public ResponseEntity<Mono<PostsDto>> save(@RequestBody PostsDto postsDto){
        return new ResponseEntity<>(postsService.save(postsDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<PostsDto>> getPosts(){
        return new ResponseEntity<>(postsService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Flux<PostsDto>> getPosts(@PathVariable Integer userId){
        return new ResponseEntity<>(postsService.getPostsByUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<PostsDto>> update(@PathVariable Integer id, @RequestBody PostsDto postsDto){
        return new ResponseEntity<>(postsService.update(id, postsDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        postsService.delete(id);
        return new ResponseEntity<>("Posts eliminado!", HttpStatus.OK);
    }
}
