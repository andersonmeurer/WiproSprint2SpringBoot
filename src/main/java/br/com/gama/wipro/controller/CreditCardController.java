package br.com.gama.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entity.CreditCard;
import br.com.gama.wipro.service.CreditCardService;

@RequestMapping("/creditcard")
@RestController
public class CreditCardController {

	private CreditCardService service;

	@Autowired
	public CreditCardController(CreditCardService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CreditCard> get(@PathVariable Integer id) {
		Optional<CreditCard> response = service.get(id);
		if (response.isPresent()) {
			return ResponseEntity.ok().body(response.get());
		}
		return ResponseEntity.notFound().build();
	}
}