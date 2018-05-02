package br.senai.jandira.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.jandira.sp.dbUtils.Conexao;
import br.senai.jandira.sp.model.Cliente;

public class ClienteDAO {

	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;

	public void gravar() {
		String sql = "INSERT INTO clientes (cpf, nome, email, sexo, dtNasc, atividade, altura, peso) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getCpf());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getSexo());
			stm.setString(5, cliente.getDtNasc());
			stm.setString(6, cliente.getAtividade());
			stm.setDouble(7, cliente.getAltura());
			stm.setDouble(8, cliente.getPeso());
			stm.execute();
			stm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso!");
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public void atualizar() {
		
	}

	public void excluir() {

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
			
			cliente.setCpf(rs.getString("cpf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setDtNasc(data.format(rs.getDate("dtNasc")));
			cliente.setAtividade(rs.getString("atividade"));
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
				cliente.setAtividade(rs.getString("atividade"));
				cliente.setAltura(rs.getDouble("altura"));
				cliente.setPeso(rs.getDouble("peso"));
				
				clientes.add(cliente);
			}
			Conexao.abrirConexao().close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return clientes;
	}

}
