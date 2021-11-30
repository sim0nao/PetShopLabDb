package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.CallableStatement;

import model.Cliente;


public class ClienteDAO {
	
	public static boolean insert(Cliente c) {
		String sp = "{SP_INCLUIRCLIENTE(?,?,?,?,?,?)}";
		CallableStatement call;
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			call = conn.prepareCall(sp);
			
			call.setString(1, c.getCpf());
			call.setString(2, c.getNome());
			call.setString(3, c.getEndereco());
			call.setString(4, c.getTelefone());
			call.setDate(5, Date.valueOf(c.getDataNascimento()));
			call.setInt(6, (char) c.getSexo());
			call.execute();
			
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
		}
		
		
		return true;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean update(Cliente c) {
		String sql = "UPDATE cliente SET nomecli = ?, telefone = ?, endereco = ?, datanasc = ?, sexo = ? WHERE cpf = ?";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setDate(4, Date.valueOf(c.getDataNascimento()));
			ps.setInt(5, c.getSexo());
			
			int updateResult = ps.executeUpdate();
			
			// se houve sucesso na atualizacao, entao o resultado eh 1
			// se retornar null, entao o resultado eh 2
			if (updateResult == 1) {
				return true;
			}
			
			ps.close();
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static List<Cliente> list() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nomecli"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setDataNascimento(LocalDate.parse(rs.getDate("datanasc").toString()));
				c.setSexo((char) rs.getInt("sexo"));
				lista.add(c);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
			lista = null;
		}
		
		return lista;
	}
	
/* ---------------------------------------------------------------- */
	
	public static Cliente consultaCliente(int cpf) {
		Cliente c = new Cliente();
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		
		try {
			Connection conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cpf);
			ResultSet rs = ps.executeQuery();
			
			rs.next();	
			c.setCpf(rs.getString("cpf"));
			c.setNome(rs.getString("nomecli"));
			c.setTelefone(rs.getString("telefone"));
			c.setEndereco(rs.getString("endereco"));
			c.setDataNascimento(LocalDate.parse(rs.getDate("datanasc").toString()));
			c.setSexo((char) rs.getInt("sexo"));
			
			rs.close();
			ps.close();
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
		}
		
		return c;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean delete(int id) {
		// TODO: código aqui
		return true;
	}

}
