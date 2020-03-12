package br.com.mongodb.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.mongodb.doman.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	public List<Post> findByTitleContainingIgnoreCase(String text);
}
