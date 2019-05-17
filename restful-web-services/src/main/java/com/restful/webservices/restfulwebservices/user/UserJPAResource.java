package com.restful.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/jpa")
public class UserJPAResource {

	@Autowired
	private UserDao dao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) {
		Optional<User> userOption = userRepository.findById(id);
		if (!userOption.isPresent()) {
			throw new UserNotPresentException("User not present userId: " + id);
		}
		User user = userOption.get();
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping(path = "/users/{id}")
	public User deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return dao.deleteOne(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> saveUser(@Validated @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> getPostForUser(@PathVariable Integer id) {
		Optional<User> userOption = userRepository.findById(id);
		if (!userOption.isPresent()) {
			throw new UserNotPresentException("User not present userId: " + id);
		}
		User user = userOption.get();
		return user.getPosts();
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<User> saveUserPost(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> userOption = userRepository.findById(id);
		if (!userOption.isPresent()) {
			throw new UserNotPresentException("User not present userId: " + id);
		}
		User user = userOption.get();
		post.setUser(user);
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
