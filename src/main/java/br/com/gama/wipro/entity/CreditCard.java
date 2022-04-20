package br.com.gama.wipro.entity;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Float balance;
	
	private String number;
	
//	@OneToOne(mappedBy = "creditCard")
//	private Account account;

	public CreditCard() {
	}

	public CreditCard(Float balance) {
		this.number = generateNumber();
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public Float getBalance() {
		return balance;
	}
	
	public String generateNumber() {
		return "5502" + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
					  + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
				      + " " + ThreadLocalRandom.current().nextInt(1000, 9999);
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + this.id + ", balance=" + this.balance + ", number=" + this.number + "]";
	}
}