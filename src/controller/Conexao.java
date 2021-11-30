package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	static Connection conn = null;
	
	/* ---------------------------------------------------------------- */
	
	public static Connection abrir() {
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/petshop";
		String user = "root";
		String psw = "r00t#19b";
		String msg = "";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, psw);
		} catch(SQLException sqle) {
			msg = "Não foi possível conectar:\n" + sqle.getMessage(); 
			JOptionPane.showMessageDialog(null, msg, "SQL Exception", JOptionPane.ERROR_MESSAGE);
			conn = null;
		} catch (ClassNotFoundException cnfe) {
			msg = "Driver não encontrado:\n" + cnfe.getMessage();
			JOptionPane.showMessageDialog(null, msg, "SQL Exception", JOptionPane.ERROR_MESSAGE);
			conn = null;
		}
		
		return conn;
	}
	
	/* ---------------------------------------------------------------- */
	
	public static boolean fechar() {
		try {
			conn.close();
			return true;
		} catch(SQLException sqle) {
			return false;
		}
	}

}
