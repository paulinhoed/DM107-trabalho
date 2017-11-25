package com.jersey;

import java.sql.Date;

public class EntregaModel {
	private int id;
	private int numero_pedido;
	private int id_cliente;
	private String nome_recebedor;
	private String cpf_recebedor;
	private Date data_entrega;
	public EntregaModel(){}
	
	public EntregaModel(int id, int numero_pedido, int id_cliente, String nome_recebedor, String cpf_recebedor,
			Date data_entrega) {
		super();
		this.id = id;
		this.numero_pedido = numero_pedido;
		this.id_cliente = id_cliente;
		this.nome_recebedor = nome_recebedor;
		this.cpf_recebedor = cpf_recebedor;
		this.data_entrega = data_entrega;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome_recebedor() {
		return nome_recebedor;
	}
	public void setNome_recebedor(String nome_recebedor) {
		this.nome_recebedor = nome_recebedor;
	}
	public String getCpf_recebedor() {
		return cpf_recebedor;
	}
	public void setCpf_recebedor(String cpf_recebedor) {
		this.cpf_recebedor = cpf_recebedor;
	}
	public Date getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}
	
	

}
