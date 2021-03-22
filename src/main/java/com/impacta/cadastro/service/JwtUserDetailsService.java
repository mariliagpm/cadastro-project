package com.impacta.cadastro.service;
 
import com.impacta.cadastro.model.PersonDAO;
import com.impacta.cadastro.model.PersonDto;
import com.impacta.cadastro.repository.UserRepository;

import org.apache.log4j.Logger; 
import javax.persistence.Query; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource; 
 import org.springframework.stereotype.Service;

import java.sql.Date; 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class JwtUserDetailsService   {
	@Autowired
	private UserRepository userDao;
  

	@Resource
	private MessageSource messageSource;

	private static final Logger LOGGER = Logger.getLogger(JwtUserDetailsService.class);

	 

	 

	public List<PersonDAO> buscaPorEmail(PersonDto user) {
		LOGGER.info("Searching login by email");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("user_login");
		EntityManager manager = factory.createEntityManager();
		LOGGER.info("Connecting at database");
		Query query = manager.createQuery("select email from login as ul " + "where ul.email = :email");
		query.setParameter("email", user.getEmail());
		List<PersonDAO> lista = query.getResultList();
		LOGGER.info("Query login by email was sent");
		return lista;
	}

	public PersonDAO save(PersonDto user) throws Exception {
	 
		LOGGER.info("Entering at save login method");
		PersonDAO newUser = new PersonDAO();
		newUser.setName(user.getName());
		newUser.setGender(user.getGender());
		newUser.setPassword(user.getPassword());
		newUser.setPinCard(user.getPinCard());
		newUser.setEmail(user.getEmail());
		newUser.setDocument(user.getDocument());
		newUser.setMotherName(user.getMotherName());
		newUser.setFatherName(user.getFatherName());
		newUser.setActive(user.isActive());
		newUser.setCountry(user.getCountry());
		newUser.setCityOrigin(user.getCityOrigin());
		newUser.setCountry(user.getCountry());
		newUser.setCreatedDate(new Date(System.currentTimeMillis()));
		newUser.setBirthday(user.getBirthday());
		newUser.setStatusID(user.getStatusID());
		newUser.setMaritalStatus(user.getMaritalStatus());
		newUser.setMaritalStatusDescription(user.getMaritalStatusDescription());
		newUser.setProfession(user.getProfession());
		
		return userDao.save(newUser);
		

	}

	 

}