package br.com.cast.getmovie.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.getmovie.dto.UserDTO;
import br.com.cast.getmovie.entities.User;
import br.com.cast.getmovie.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insert(UserDTO dto){
		User user = new User();
		
		
		if(dto != null){
			user.setId(dto.getId());
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			
			userRepository.insert(user);
		}
	}
	
	@Transactional
	public void remove(Integer id){
		User user = userRepository.searchById(id);
		userRepository.remove(user);
	}
	
	@Transactional
	public UserDTO searchById(Integer id){
		UserDTO userDTO = new UserDTO();
		
		User user = userRepository.searchById(id);
		
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		
		return userDTO;
	}
	
	@Transactional
	public List<UserDTO> searchAll(){
		List<UserDTO> dtos = new ArrayList<>();
		List<User> users = userRepository.searchAll();
		
		
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setPassword(user.getPassword());
			
			dtos.add(userDTO);
			
		}
		
		return dtos;
		
	}
	
	@Transactional
	public UserDTO login(String email, String password){
		
		UserDTO dto = new UserDTO();
		User user = userRepository.login(email, password);
		
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		
		return dto;
		
	}
	
	@Transactional
	public void update(Integer id){
		UserDTO dto = searchById(id);
		
		User user = new User();
		
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		
		userRepository.update(user);
		
	}
	

}
