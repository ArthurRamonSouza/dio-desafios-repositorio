package com.mybank.banco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private int totalContas;
	private static List<Conta> contas = new ArrayList<>();
	private int totalClientes;
	private static List<Cliente> clientes = new ArrayList<>();

	public static List<Conta> getContas() {
		return contas;
	}

	public static void setContas(List<Conta> contas) {
		Banco.contas = contas;
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		Banco.clientes = clientes;
	}

	public int getTotalContas() {
		System.out.println("O total de contas no banco é: ");
		return Conta.getTotal();
	}

	public int getTotalClientes() {
		System.out.println("O total de clientes em nosso banco é: ");
		return Cliente.getTotal();
	}
}
