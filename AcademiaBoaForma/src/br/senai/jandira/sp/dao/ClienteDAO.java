package br.senai.jandira.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.jandira.sp.dbUtils.Conexao;
import br.senai.jandira.sp.model.Cliente;

public class ClienteDAO {

	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;

	public void gravar() {

	}

	public void atualizar() {

	}

	public void excluir() {

	}

	public Cliente getCliente(String cpf) {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();

		String sql = "SELECT * FROM clientes ORDER BY nome";
		stm = null;
		rs = null;

		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDtNasc(rs.getString("dtNasc"));
				cliente.setAltura(rs.getInt("altura"));
				cliente.setPeso(rs.getInt("peso"));
				
				clientes.add(cliente);
			}
			Conexao.abrirConexao().close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return clientes;
	}

}
