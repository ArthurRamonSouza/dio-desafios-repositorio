package com.mybank.banco.model;

public class ContaPoupanca extends Conta {
	
	private static final long serialVersionUID = 1L;

	public ContaPoupanca(int numero, int senha) {
		super(numero, senha);
	}

	@Override
	public void deposita(double valor) {
		super.saldo = super.saldo += valor;	
		
	}
	
	@Override
	public String toString() {
		return "Conta Poupança, " + super.toString();
	}
	
}
