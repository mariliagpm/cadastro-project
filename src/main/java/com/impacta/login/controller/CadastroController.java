package com.impacta.login.controller;
 
import com.impacta.login.model.JwtRequest; 
import com.impacta.login.model.PersonDAO;
import com.impacta.login.model.PersonDto;
import com.impacta.login.model.UserLogged;
import com.impacta.login.service.JwtUserDetailsService;

import java.util.List;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CadastroController extends AbstractController {

	@Autowired
	private AuthenticationManager authenticationManager;
 

	@Autowired
	private JwtUserDetailsService userDetailsService;

	private static final Logger LOGGER = Logger.getLogger(CadastroController.class);

	protected static final String FEEDBACK_MESSAGE_KEY_LOGIN_CREATED = "feedback.message.login.created";
	protected static final String ERROR_MESSAGE_KEY_LOGIN_WAS_NOT_CREATED = "error.message.login.was.not.created";
	protected static final String ERROR_MESSAGE_KEY_EMAIL_EMPTY = "error.message.email.not.blank";
	protected static final String ERROR_MESSAGE_KEY_USERNAME_EMPTY = "error.message.username.not.blank";
	protected static final String ERROR_MESSAGE_KEY_PASSWORD_EMPTY = "error.message.password.not.blank";
	protected static final String ERROR_MESSAGE_KEY_USER_ALREADY_HAS_ACCOUNT = "error.message.user.has.account";
	protected static final String ERROR_MESSAGE_EMAIL_ALREADY_USED = "error.message.email.already.used";

	// LoginMessages
	protected static final String ERROR_MESSAGE_LOGIN_BAD_CREDENTIALS = "error.message.login.bad.credencials";
	protected static final String ERROR_MESSAGE_LOGIN_USER_NOT_FOUND = "error.message.login.user.not.found";
	protected static final String FEEDBACK_MESSAGE_LOGIN_SUCCESS = "error.message.login.sucess";
	protected static final String ERROR_MESSAGE_LOGIN_DEFAULT = "error.message.login.default";

	/**
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/user/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@Valid @RequestBody PersonDto user) throws Exception {
		try { 
			if (user.getDocument() == null || user.getDocument().isEmpty()) {
				 return new ResponseEntity<>(addErrorMessage(ERROR_MESSAGE_KEY_USERNAME_EMPTY, user.getDocument()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			 
			if (user.getPassword() == null || user.getPassword().isEmpty()) {
				return new ResponseEntity<>(addErrorMessage(ERROR_MESSAGE_KEY_PASSWORD_EMPTY, user.getPassword()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			} 
			userDetailsService.save(user);
			LOGGER.info("User is created");

			return new ResponseEntity<>(addFeedbackMessage(FEEDBACK_MESSAGE_KEY_LOGIN_CREATED, user.getDocument()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(addErrorMessage(ERROR_MESSAGE_KEY_LOGIN_WAS_NOT_CREATED, user.getDocument()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	 
}
