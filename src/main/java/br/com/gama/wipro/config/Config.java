package br.com.gama.wipro.config;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gama.wipro.entity.CreditCard;
import br.com.gama.wipro.entity.CurrentAccount;
import br.com.gama.wipro.repository.CreditCardRepository;
import br.com.gama.wipro.repository.CurrentAccountRepository;

@Configuration
//@Profile("wiprodb")
public class Config implements CommandLineRunner {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	@Override
	public void run(String... args) {
		try {
			for (int i = 1; i <= 10; i++) {

				creditCardRepository.save(new CreditCard(1500F));
				List<CreditCard> list = creditCardRepository.findAll();
				CreditCard savedCreditCard = list.get(list.size()-1);
				CurrentAccount currentAccount = new CurrentAccount(i, 10F, savedCreditCard);
				currentAccountRepository.save(currentAccount);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}