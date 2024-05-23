package com.fj.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fj.webservice.entities.User;
import com.fj.webservice.repositories.UserRepository;
import com.fj.webservice.services.exceptions.DatabaseException;
import com.fj.webservice.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			User user = findById(id); // Isso fará que retorno um erro caso não exista, pois o delete não retorna.
			repository.deleteById(user.getId());
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
