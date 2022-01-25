package com.mybank.banco.model;

public class ContaCorrente extends Conta implements Tributavel {
	
	private static final long serialVersionUID = 1L;

	public ContaCorrente(int numero, int senha) {
		super(numero, senha);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		double valorASacar = valor + 0.2;
		 super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		super.saldo = super.saldo += valor;	
		
	}

	@Override
	public double getValorImposto() {
		return this.saldo*0.1;
	}
	
	@Override
	public String toString() {
		return "Conta Corrente, " + super.toString();
	}
	
}
