package br.com.gama.wipro.entity;

public class SpecialAccount extends Account {

	private Float overdraftLimit;

	public SpecialAccount() {
	}

	public SpecialAccount(Integer number, Float balance, CreditCard creditCard) {
		super(number, balance, creditCard);
		overdraftLimit = (balance * 1.5f);
	}

	public float getOverdraftLimit() {
		return this.overdraftLimit;
	}

	@Override
	public void sacar(Float valor) {
		if ((overdraftLimit + balance) >= valor) {
			super.sacar(valor);
		}
	}
	
	@Override
	public String toString() {
		return "\n\tConta Especial"+ 
			   " \n\n\tNúmero da conta: " + number + 
			   " \n\tSaldo: " + balance + 
			   " \n\tCartão de crédito: "+ creditCard +
			   "\n";
	}
}