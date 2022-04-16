package model;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.DriverManager;

import view.Estoque;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/orcamentos?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	public Beans Bean = new Beans();
	public Estoque est = new Estoque();

	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}
}
