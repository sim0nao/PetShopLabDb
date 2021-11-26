package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Animal;


public class AnimalDAO {

	public static boolean insert() {
		// TODO: código aqui
		return true;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean update(Animal a) {
		String sql = "UPDATE animal SET cpfcliente = ?, nomeanimal = ?, raca = ?, porte = ?, especia = ?, sexo = ? WHERE idanimal = ?";
		Connection conn = null;
		
		try {
			conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, a.getCpfCliente());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getRaca());
			ps.setString(4, a.getPorte());
			ps.setString(5, a.getEspecie());
			ps.setInt(6, a.getSexo());
			
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
	
	public static List<Animal> list() {
		List<Animal> lista = new ArrayList<>();
		String sql = "SELECT * FROM animal";
		Connection conn = null;
		
		/*
		 * IDANIMAL INTEGER NOT NULL,
	    CPFCLIENTE VARCHAR(11) NOT NULL, 
		NOMEANIMAL VARCHAR(20) NOT NULL,
	    RACA VARCHAR (20),
	    PORTE VARCHAR (30),
	    ESPECIA VARCHAR (20),
	    SEXO CHAR(1) NOT NULL);
		 * */
		
		try {
			conn = Conexao.abrir();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Animal a = new Animal();
				a.setId(rs.getInt("idanimal"));
				a.setCpfCliente(rs.getString("cpfcliente"));
				a.setNome(rs.getString("nomeanimal"));
				a.setRaca(rs.getString("raca"));
				a.setPorte(rs.getString("porte"));
				a.setEspecie(rs.getString("especia"));
				a.setSexo((char) rs.getInt("sexo"));
				lista.add(a);
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
	
	public static Animal consultaAnimal(int id) {
		Animal a = new Animal();
		String sql = "SELECT * FROM animal WHERE idanimal = ?";
		
		try {
			Connection conn = Conexao.abrir();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();	
			a.setCpfCliente(rs.getString("cpfcliente"));
			a.setNome(rs.getString("nomeanimal"));
			a.setRaca(rs.getString("raca"));
			a.setPorte(rs.getString("porte"));
			a.setEspecie(rs.getString("especia"));
			a.setSexo((char) rs.getInt("sexo"));
			
			rs.close();
			ps.close();
			conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Sql Exception", JOptionPane.ERROR_MESSAGE);
		}
		
		return a;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean delete() {
		// TODO: código aqui
		return true;
	}
	
}
