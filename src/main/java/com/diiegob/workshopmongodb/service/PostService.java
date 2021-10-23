package com.diiegob.workshopmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diiegob.workshopmongodb.domain.Post;
import com.diiegob.workshopmongodb.repository.PostRepository;
import com.diiegob.workshopmongodb.service.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}

}
