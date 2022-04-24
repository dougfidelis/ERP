package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MaterialDao {

	/** ______Atributos Conex�o_______ **/

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_osbe?useTimezone=true&serverTimezone=UTC";
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

	/** M�todo para listar chapas **/
	public ArrayList<MaterialBeans> listarChapas(String categoria) {
		ArrayList<MaterialBeans> material = new ArrayList<>();
		String sql = "select * from "+categoria+" order by descricao";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {				
				int codigoItem = rs.getInt(1);
				String descricao = rs.getString(2);
				double valor = rs.getInt(3);
				double quantidade = rs.getInt(4);
				material.add(new MaterialBeans(codigoItem, descricao, valor, quantidade));
			}
			con.close();
			return material;
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
	}

	/** M�todo para cadastrar material **/
	public void cadastrarMaterial(String tabela, MaterialBeans material) {
		String insert = "INSERT INTO "+tabela+"( `descricao`, `valor`, `quantidade`) VALUES (?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, material.getDescricaoMaterial());
			pst.setDouble(2, material.getQuantidadeMaterial());			
			pst.setDouble(3, material.getValorMaterial());
			pst.execute();
			con.close();
			JOptionPane.showOptionDialog(null, "Or�amento salvo com sucesso!", "Cadastro OK", -1, 1, null, null,
					null);
		} catch (Exception e) {
			JOptionPane.showOptionDialog(null, "Falha ao salvar \n Erro: "+e, "Falhou", -1, 1, null, null,
					null);
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
			//JOptionPane.showOptionDialog(null, "Cliente removido com sucesso!", "Remover Cliente", -1, 1, null, null,	null);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<MaterialBeans> selecionarCliente(int codigo) {
		ArrayList<MaterialBeans> cliente = new ArrayList<MaterialBeans>();
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
