package com.impacta.login.repository;
import org.springframework.data.repository.CrudRepository;

import com.impacta.login.model.PersonDAO;
 
public interface UserRepository extends CrudRepository<PersonDAO, Integer> {

	 
 
}