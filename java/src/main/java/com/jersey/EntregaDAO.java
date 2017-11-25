package com.jersey;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregaDAO {
	public void insert(Connection conn, EntregaModel entrega)
			throws SQLException{
		String sql = "insert into entregas (numero_pedido, id_cliente, nome_recebedor, cpf_recebedor, data_entrega) values (?, ?, ?, ?, ?);";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, entrega.getNumero_pedido());
		pstm.setInt(2, entrega.getId_cliente());
		pstm.setString(3, entrega.getNome_recebedor());
		pstm.setString(4, entrega.getCpf_recebedor());
		pstm.setDate(5, entrega.getData_entrega());
		pstm.execute();
	}
	
	public EntregaModel listEntregaByNumeroPedido(Connection conn, int numeroPedido) throws SQLException{
		String sql = "select * from entregas where numero_pedido = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, numeroPedido);
		ResultSet rs = pstm.executeQuery();

		EntregaModel entrega = new EntregaModel();
		while (rs.next())
		{
			int id = rs.getInt("id");
			int numero_pedido = rs.getInt("numero_pedido");
			int id_cliente = rs.getInt("id_cliente");
			String nome_recebedor = rs.getString("nome_recebedor");
			String cpf_recebedor = rs.getString("cpf_recebedor");
			Date data_hora_entrega = rs.getDate("data_entrega");
			entrega = new EntregaModel(id, numero_pedido, id_cliente, nome_recebedor, cpf_recebedor, data_hora_entrega);
		}
		return entrega;
	}

}
