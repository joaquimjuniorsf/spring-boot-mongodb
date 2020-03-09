package br.com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mongodb.doman.User;
import br.com.mongodb.dto.UserDTO;
import br.com.mongodb.repository.UserRepository;
import br.com.mongodb.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User usr = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return usr;
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(),obj.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		
		updateData(newObj,obj);
		
		return userRepository.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

}
