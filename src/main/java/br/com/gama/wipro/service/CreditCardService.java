package br.com.gama.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entity.CreditCard;
import br.com.gama.wipro.repository.CreditCardRepository;

@Service
public class CreditCardService {

	private CreditCardRepository repository;
	
	@Autowired
	public CreditCardService(CreditCardRepository repository) {
		this.repository = repository;
	}
	
	public Optional<CreditCard> get(Integer id) {
		return repository.findById(id);
	}
}
