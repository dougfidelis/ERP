package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OrcamentosDao {

	/** ______Atributos Conexão_______ **/

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_erp?useTimezone=true&serverTimezone=UTC";
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
	public ArrayList<OrcamentosBeans> listarOrcamento() {
		ArrayList<OrcamentosBeans> orcamento = new ArrayList<>();
		String sql = "select * from orcamento order by codigoOrcamento";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int codigoOrcamento = rs.getInt(1);
				int validade = rs.getInt(2);
				int entrega = rs.getInt(3);
				double rt = rs.getInt(4);
				double imposto = rs.getInt(5);
				double valor = rs.getInt(6);
				String arquiteto = rs.getString(7);
				String emissao = rs.getString(8);
				String formPgto = rs.getString(9);
				String situacao = rs.getString(10);
				int codigoCliente = rs.getInt(11);
				orcamento.add(new OrcamentosBeans(codigoOrcamento, validade, entrega, rt, imposto, valor,
						arquiteto, emissao, formPgto, situacao, codigoCliente));
			}
			con.close();
			return orcamento;
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
