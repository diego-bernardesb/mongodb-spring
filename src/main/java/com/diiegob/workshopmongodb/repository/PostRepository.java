package com.diiegob.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diiegob.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//Função criada com Query Method
	List<Post> findByTitleContainingIgnoreCase(String text);
}
