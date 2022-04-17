package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/**______Atributos Conex�o_______**/
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/orcamentos?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	
	/**_____M�todo de conex�o_____**/
	
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
	
	/** M�todo para atualizar lista de clientes **/
	public ArrayList<Beans> atualizaCliente() {
		ArrayList<Beans> clientes = new ArrayList<>();
		// Cria um objeto para acessar a classe Beans

		String sql = "select * from cliente order by nomeCliente";
		// Prepara o comando sql

		try {
			Connection con = conectar();
			// Abre conex�o

			PreparedStatement pst = con.prepareStatement(sql);
			// Prepara a execu��o no banco de dados

			ResultSet rs = pst.executeQuery();
			// cria um objeto para fazer o repeti��o do comando "pst"

			while (rs.next()) {
				/*
				 * cria um la�o de repeti�ao usando o objeto criado para receber todos os dados
				 * enquanto ouver algum dado no banco (condi��o objeto.next())
				 */

				int codigoCliente = rs.getInt(1);
				String nomeCliente = rs.getString(2);
				String telCliente = rs.getString(3);
				String emailCliente = rs.getString(4);
				String endCliente = rs.getString(5);
				// Vari�veis de apoio que recebem os dados do banco

				clientes.add(new Beans(codigoCliente, nomeCliente, telCliente, emailCliente, endCliente));
				// Insere os dados no ArrayList

			}
			con.close();
			// Fecha a conex�o

			return clientes;
			// Retorna um objeto com os dados da classe Beans

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}