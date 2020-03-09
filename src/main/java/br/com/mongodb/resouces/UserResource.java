package br.com.mongodb.resouces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mongodb.doman.User;
import br.com.mongodb.dto.UserDTO;
import br.com.mongodb.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = userService.findAll();
		
		return ResponseEntity.ok().body(list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList()));
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User usr = userService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(usr));
	}

}
