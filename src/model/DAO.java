package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DAO {

	/** ______Atributos Conex�o_______ **/

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/orcamentos?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	/** _____M�todo de conex�o_____ **/

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

	/** M�todo para listar clientes **/
	public ArrayList<Beans> listarClientes() {
		ArrayList<Beans> clientes = new ArrayList<>();
		String sql = "select * from cliente order by nomeCliente";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int codigoCliente = rs.getInt(1);
				String nomeCliente = rs.getString(2);
				String foneCliente = rs.getString(3);
				String emailCliente = rs.getString(4);
				String endCliente = rs.getString(5);
				clientes.add(new Beans(codigoCliente, nomeCliente, foneCliente, emailCliente, endCliente));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** M�todo para cadastrar clientes **/
	public void cadastrarCliente(Beans cliente) {
		String sqlCreate = "insert into cliente (nomeCliente, foneCliente, emailCliente, endCliente) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlCreate);
			pst.setString(1, cliente.getNomeCliente());
			pst.setString(2, cliente.getFoneCliente());
			pst.setString(3, cliente.getEmailCliente());
			pst.setString(4, cliente.getEndCliente());
			pst.executeUpdate();
			con.close();
			//JOptionPane.showOptionDialog(null, "Cliente adicionado com sucesso!", "Cadastro OK", -1, 1, null, null,
			//		null);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** M�todo para excluir clientes **/
	public void removerCliente(int codigoCliente) {
		String sqlDelete = "DELETE from cliente WHERE codigoCliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pstmt = con.prepareStatement(sqlDelete);
			pstmt.setInt(1, codigoCliente);
			pstmt.execute();
			con.close();
			JOptionPane.showOptionDialog(null, "Cliente removido com sucesso!", "Remover Cliente", -1, 1, null, null,
					null);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Beans> selecionarCliente(int codigo) {
		ArrayList<Beans> cliente = new ArrayList<Beans>();
		String sql = "select * from cliente WHERE codigoCliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int codigoCliente = rs.getInt(1);
				String nomeCliente = rs.getString(2);
				String foneCliente = rs.getString(3);
				String emailCliente = rs.getString(4);
				String endCliente = rs.getString(5);
				cliente.add(new Beans(codigoCliente, nomeCliente, foneCliente, emailCliente, endCliente));
			}
			con.close();
			return cliente;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void updateCliente(Beans cliente) {
		String sqlCreate = "update cliente set nomeCliente = ?, foneCliente = ?, emailCliente = ?,  endCliente = ? WHERE codigoCliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sqlCreate);
			pst.setString(1, cliente.getNomeCliente());
			pst.setString(2, cliente.getFoneCliente());
			pst.setString(3, cliente.getEmailCliente());
			pst.setString(4, cliente.getEndCliente());
			pst.setInt(5, cliente.getCodigoCliente());
			pst.executeUpdate();
			con.close();
			JOptionPane.showOptionDialog(null, "Cliente atualizado com sucesso!", "Cadastro OK", -1, 1, null, null,
					null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
