package com.fo.SpringWithMongo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.Logger;
import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.SpringWithMongo.component.mapper.person.PersonMapper;
import com.fo.SpringWithMongo.dto.PersonDTO;
import com.fo.SpringWithMongo.model.Person;
import com.fo.SpringWithMongo.service.person.PersonService;

@RestController
@RequestMapping(value="/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	@GetMapping
	public List<PersonDTO> getAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
			 					@RequestParam(defaultValue = "10", required= false ) Integer size) {
		
		Logger logger = ESAPI.getLogger("PersonController");
		logger.info(Logger.EVENT_SUCCESS, "Logger of ESAPI");
		
		return personMapper.modelToDto(personService.findAll(PageRequest.of(page,  size)));
	}
	
	@GetMapping("/{idPerson}")
	public PersonDTO getById(@PathVariable("idPerson") String id) {
		return personMapper.modelToDto(personService.findById(id).get());
	}
	
	@PostMapping
	public PersonDTO create(@RequestBody PersonDTO personDTO) throws IntrusionException, ValidationException, IOException {
		
		ESAPI.validator().getValidInput("Email correcto", personDTO.getEmail(), "SafeString", 200, true, true);
		
		ESAPI.validator().isValidFileUpload(context, filepath, filename, parent, content, maxBytes, allowNull)
		
		Validator validator = ESAPI.validator();
		Encoder encoder = ESAPI.encoder();
		
		ESAPI.getLogger(PersonController.class).info(Logger.EVENT_SUCCESS, personDTO.getName());
		ESAPI.getLogger(PersonController.class).info(Logger.EVENT_SUCCESS, encoder.canonicalize(personDTO.getName()));
		ESAPI.getLogger(PersonController.class).info(Logger.EVENT_SUCCESS, new String(encoder.decodeFromBase64(personDTO.getName())));
		
		
		
		
		return personMapper.modelToDto(personService.create(personMapper.dtoToModel(personDTO)));
	}
	
	@PutMapping("/{idPerson}")
	public void update(@RequestBody PersonDTO personDTO, 
					@PathVariable("idPerson") String id) {
		Optional<Person> person = personService.findById(id);
		person.get().setName(personDTO.getName());
		person.get().setSurname(personDTO.getSurname());
		person.get().setUsername(personDTO.getUsername());
		person.get().setCar(personDTO.getCar());
		personService.update(person.get());
	}
	
	@DeleteMapping("/{idPerson}")
	public void delete(@PathVariable("idPerson") String id) {
		personService.delete(personService.findById(id).get());
	}
}
