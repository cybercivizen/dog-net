package dev.cybercivizen.dognet.post;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET, name = "Retrieve a post by id")
    public Optional<Post> getPost(@PathVariable Long postId) {
        return postRepository.findById(postId);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST, name = "Save a post")
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
