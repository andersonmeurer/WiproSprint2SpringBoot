package br.com.gama.wipro.entity;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {

	public CurrentAccount() {
	}

	public CurrentAccount(Integer number, Float balance, CreditCard creditCard) {
		super(number, balance, creditCard);
	}

	@Override
	public void sacar(Float value) {
		if (value <= this.balance) {
			super.sacar(value);
		}
	}
	
	@Override
	public String toString() {
		return "\n\tConta Corrente"+ 
			   " \n\n\tNúmero da conta: " + number + 
		       " \n\tSaldo: " + balance + 
		       " \n\tCartão de crédito: "+ creditCard +
	           "\n";
	}
}