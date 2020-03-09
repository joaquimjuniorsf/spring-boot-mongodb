package br.com.mongodb.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.mongodb.doman.Post;
import br.com.mongodb.doman.User;
import br.com.mongodb.repository.PostRepository;
import br.com.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post p1 = new Post(null,LocalDate.of(2018, 3, 21),"Partiu viagem","Vou viajar para São Paulo. Abraços", maria);
		Post p2 = new Post(null,LocalDate.of(2018, 3, 23),"Partiu viagem","Vou viajar para São Paulo. Abraços", alex);
		
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
