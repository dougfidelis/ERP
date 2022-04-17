package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Beans;
import model.DAO;
import view.Clientes;

public class Controller {
	
	private DAO dao = new DAO();
	public DefaultTableModel listarClientes() {
		// Método para preencher a tabela de dados cliente

		ArrayList<Beans> orcamento = dao.listarClientes();
		// Cria um objeto para receber os dados da classe Beans

		DefaultTableModel table = (DefaultTableModel) Clientes.tabelaClientes.getModel();
		// Cria uma tabela usando o modelo criado na view

		if (table.getRowCount() > 0) {
			table.setRowCount(0);
		}// Zera as tabela criada para adicionar os dados do banco		

		for (Beans item : orcamento) {
			Object[] linha = new Object[4];
			linha[0] = ((Beans) item).getCodigoCliente();
			linha[1] = ((Beans) item).getNomeCliente();
			linha[2] = ((Beans) item).getFoneCliente();
			linha[3] = ((Beans) item).getEmailCliente();
			table.addRow(linha);
			// Preenche a tabela com os dados recebidos da classe Beans
		}

		return table;
		// Retorna a tabela com os dados recebidos da classe Beans
	}
	
	public void salvar(Beans cliente) {
		dao.cadastrarCliente(cliente);
	}
	
	public void removerCliente(int codigoCliente) {
		dao.removerCliente(codigoCliente);
	}	
	
	public ArrayList<Beans> selecionarCliente() {
		ArrayList<Beans> cliente = dao.listarClientes();
		for (Beans item : cliente) {
			Object[] linha = new Object[5];
			linha[0] = ((Beans) item).getCodigoCliente();
			linha[1] = ((Beans) item).getNomeCliente();
			linha[2] = ((Beans) item).getFoneCliente();
			linha[3] = ((Beans) item).getEmailCliente();
			linha[4] = ((Beans) item).getEndCliente();
		}
		return cliente;
	}

}
