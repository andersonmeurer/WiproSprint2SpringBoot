package br.com.gama.wipro.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Columns;

@MappedSuperclass
public abstract class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer number;

	protected Float balance;

	@OneToOne
	@JoinColumn(referencedColumnName = "id", name = "credit_card_id")
	protected CreditCard creditCard;

	public Account() {
	}

	public Account(Integer number, Float balance, CreditCard creditCard) {
		this.number = number;
		this.balance = balance;
		this.creditCard = creditCard;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	protected void deposit(Float value) {
		this.balance += value;
	}

	protected void sacar(Float value) {
		this.balance -= value;
	}

	@Override
	public String toString() {
		return "\tConta"
				+ " \n\n\tNúmero da conta: " + number
				+ " \n\tSaldo: " + balance
				+ " \n\tCartão de crédito: " + creditCard + "\n";
	}
}