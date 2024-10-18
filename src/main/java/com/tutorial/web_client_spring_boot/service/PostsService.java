package com.tutorial.web_client_spring_boot.service;

import com.tutorial.web_client_spring_boot.dto.PostsDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostsService {

    private final WebClient webClient;

    public PostsService(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<PostsDto> save(PostsDto postsDto){
        return webClient.post().uri("/posts").bodyValue(postsDto).retrieve().bodyToMono(PostsDto.class);
    }

    public Flux<PostsDto> getPosts(){
        return webClient.get().uri("/posts").retrieve().bodyToFlux(PostsDto.class);
    }

    public Flux<PostsDto> getPostsByUser(Integer userId){
        return webClient.get().uri("/users/"+userId+"/posts").retrieve().bodyToFlux(PostsDto.class);
    }

    public Mono<PostsDto> update(Integer id, PostsDto postsDto){
        return webClient.put().uri("/posts/"+id).bodyValue(postsDto).retrieve().bodyToMono(PostsDto.class);
    }

    public void delete(Integer id){
        webClient.delete().uri("/posts/"+id).retrieve().bodyToMono(PostsDto.class);
    }
}
