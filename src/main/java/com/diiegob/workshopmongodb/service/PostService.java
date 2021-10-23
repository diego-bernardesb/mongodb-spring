package com.diiegob.workshopmongodb.service;

import java.util.Date;
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
	
	//query method com consulta simples
//	public List<Post> findByTitle(String text){
//		return repo.findByTitleContainingIgnoreCase(text);
//	}

	//query method com consulta personalizada
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);//conta apartir do momento que a data e criada até 24h dps para ser considerado 1 dia		
		return repo.fullSearch(text, minDate, maxDate);
	}
}
