package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ClienteDAO {

	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;

	// Métodos para o Banco de Dados

	public void gravar() {
		String sql = "INSERT INTO clientes (cpf, nome, dtNasc, sexo, altura, peso) " + "VALUES (?, ?, ?, ?, ?, ?)";
		stm = null;

		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getCpf());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getDtNasc());
			stm.setString(4, cliente.getSexo());
			stm.setDouble(5, cliente.getAltura());
			stm.setDouble(6, cliente.getPeso());
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public void atualizar(String cpf) {
		String sql = "UPDATE clientes SET nome = ?, dtNasc = ?, sexo = ?, " + "altura = ?, peso = ? WHERE cpf = ?";
		stm = null;

		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setString(3, cliente.getSexo());
			stm.setDouble(4, cliente.getAltura());
			stm.setDouble(5, cliente.getPeso());
			stm.setString(6, cpf);
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public void excluir(String cpf) {
		String sql = "DELETE FROM clientes WHERE cpf = ?";

		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cpf);
			stm.execute();
			stm.close();
			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Cliente getCliente(String cpf) {
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		cliente = new Cliente();

		String sql = "SELECT * FROM clientes WHERE cpf = ?";

		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cpf);
			rs = stm.executeQuery();

			rs.next();

			cliente.setNome(rs.getString("nome"));
			cliente.setDtNasc(data.format(rs.getDate("dtNasc")));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setAltura(rs.getDouble("altura"));
			cliente.setPeso(rs.getDouble("peso"));
			
			stm.close();
			
			Conexao.abrirConexao().close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Cliente> getContatos() {
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
				cliente.setDtNasc(rs.getString("dtNasc"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setAltura(rs.getDouble("altura"));
				cliente.setPeso(rs.getDouble("peso"));

				clientes.add(cliente);
			}
			Conexao.abrirConexao().close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return clientes;
	}

}
