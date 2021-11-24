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
		// TODO: código aqui
		return true;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean update() {
		// TODO: código com STORED PROCEDURES aqui		
		return true;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static List<Produto> list() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM Produtos";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir("");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
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
		String sql = "SELECT * FROM Produtos WHERE id = ?";
		
		try {
			Connection conn = Conexao.abrir("");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();	
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
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
