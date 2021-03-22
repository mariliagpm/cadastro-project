package com.impacta.cadastro.repository;
import org.springframework.data.repository.CrudRepository;

import com.impacta.cadastro.model.PersonDAO;
 
public interface UserRepository extends CrudRepository<PersonDAO, Integer> {

	 
 
}