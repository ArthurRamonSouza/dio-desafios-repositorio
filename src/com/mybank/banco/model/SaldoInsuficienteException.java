package com.mybank.banco.model;

public class SaldoInsuficienteException extends Exception{

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
