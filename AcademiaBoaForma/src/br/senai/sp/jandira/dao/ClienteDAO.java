package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ClienteDAO {
	
	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;
	
	//Métodos para o Banco de Dados
	
	public void gravar(){
		String sql = "INSERT INTO clientes (cpf, nome, dtNasc, sexo, altura, peso) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, cliente.getCpf());
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
	public void atualizar(){
		
	}
	public void excluir(){
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
