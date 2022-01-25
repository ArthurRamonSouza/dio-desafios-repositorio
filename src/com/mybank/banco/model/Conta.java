package com.mybank.banco.model;


import java.io.Serializable;

public abstract class  Conta implements Comparable<Conta>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected double saldo;
	private int agencia;
	private int numero;
	private int senha;
	private Cliente titular;
	private static int total;
	
	public Conta(int agencia, int numero, int senha) {
		this.validaSenha(senha);
		this.agencia = agencia;
		this.numero = numero;
		
		this.senha = senha;
		Conta.total++;
		Banco.getContas().add(this);
	}
	
	public Conta(int numero, int senha) {
		this(3334, numero, senha);
	}
	
	protected void validaSenha(int senha) {
		if(senha > 9999) {
			System.out.println("A senha deve conter apenas 4 dígitos.");
		}
	}
	
	public abstract void deposita(double valor);
	
	public void saca(double valor) throws SaldoInsuficienteException {
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saque não efetuado!" + "Seu saldo é: " + this.saldo + "O valor a sacar é: " + valor 
					+ " mais o imposto se sua conta for corrente.");
		}
		this.saldo -= valor;	
	}
	
	public void transfere(double valor, Conta destinatario) throws SaldoInsuficienteException {
			saca(valor);
			destinatario.deposita(valor);
			System.out.println("Transferência concluída!");
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getAgencia() {
		System.out.println("Sua agência é: ");
		return this.agencia;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public Cliente getTitular() {
		return this.titular;
	} 
	
	public static int getTotal() {
		System.out.println("A quantidade de contas atualmente são: " + Conta.total);
		return Conta.total;
	}
	
	public void setTitular(Cliente cliente) {
		this.titular = cliente;
	}
		
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia: " + this.agencia;
	}

	@Override
	public boolean equals(Object ref) {
		
		Conta outra = (Conta) ref;
		
		if(this.agencia != outra.agencia) {
			return false;
		} 
		if(this.numero != outra.numero) {
			return false;
		}
		return true;
	}
	@Override
	public int compareTo(Conta outra) {
			return Double.compare(this.saldo, outra.saldo);
		}
	
	public void setSenha(int senha) {
		this.validaSenha(senha);
		this.senha = senha;
	}
	
	public int getSenha() {
		return senha;
	}
}
