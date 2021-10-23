package com.diiegob.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diiegob.workshopmongodb.domain.Post;
import com.diiegob.workshopmongodb.resources.util.URL;
import com.diiegob.workshopmongodb.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitleIgnoreCase(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);//decodifica o URL para ser lido 
		List<Post> list = service.findByTitle(text);//cria a lista com os post contendo o text
		
		return ResponseEntity.ok().body(list);
		
	}
}
