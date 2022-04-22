package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ComboDao {

	/** ______Atributos Conexão_______ **/

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_erp1?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	/** _____Método de conexão_____ **/

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

	/** Método para listar orçamentos **/
	public ArrayList<ItensBeans> listarItens(String tabela) {
		ArrayList<ItensBeans> item = new ArrayList<>();
		String sql = "select * from "+tabela;
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setString(1, tabela);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int codigoItem = rs.getInt(1);
				String descricao = rs.getString(2);
				double valor = rs.getInt(3);
				double quantidade = rs.getInt(4);
				item.add(new ItensBeans(codigoItem, descricao, valor, quantidade));
			}
			con.close();
			return item;
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
	}

	/** Método para cadastrar clientes **/
	/*public void cadastrarCliente(OrcamentosBeans cliente) {
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

	/** Método para excluir clientes **/
	public void removerCliente(int codigoCliente) {
		String sqlDelete = "DELETE from cliente WHERE codigoCliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pstmt = con.prepareStatement(sqlDelete);
			pstmt.setInt(1, codigoCliente);
			pstmt.execute();
			con.close();
			//JOptionPane.showOptionDialog(null, "Cliente removido com sucesso!", "Remover Cliente", -1, 1, null, null,	null);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<OrcamentosBeans> selecionarCliente(int codigo) {
		ArrayList<OrcamentosBeans> cliente = new ArrayList<OrcamentosBeans>();
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
				//cliente.add(new OrcamentosBeans(codigoCliente, nomeCliente, foneCliente, emailCliente, endCliente));
			}
			con.close();
			return cliente;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/*public void updateCliente(OrcamentosBeans cliente) {
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
	}*/
}
