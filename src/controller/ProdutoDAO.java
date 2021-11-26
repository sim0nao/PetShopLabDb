package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;


public class ProdutoDAO {
	
	public static boolean insert() {
		// TODO: código com STORED PROCEDURES aqui
		return true;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean update(Produto p) {
		String sql = "UPDATE produto SET nomeproduto = ?, descricao = ?, valor = ? WHERE idproduto = ?";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setDouble(3, p.getValor());
			ps.setInt(4, p.getId());
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
	
	public static List<Produto> list() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("idproduto"));
				p.setNome(rs.getString("nomeproduto"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor"));
				lista.add(p);
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
	
	public static Produto consultaProduto(int id) {
		Produto p = new Produto();
		String sql = "SELECT * FROM produto WHERE idproduto = ?";
		
		try {
			Connection conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();	
			p.setId(rs.getInt("idproduto"));
			p.setNome(rs.getString("nomeproduto"));
			p.setDescricao(rs.getString("descricao"));
			p.setValor(rs.getDouble("valor"));
			
			rs.close();
			ps.close();
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
		}
		
		return p;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean delete(int id) {
		// TODO: código aqui
		return true;
	}
}
