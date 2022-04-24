package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.ClientesBeans;
import model.ClientesDao;
import view.cliente.Clientes;
import view.cliente.EditarCliente;

public class ClientesControl {

	private ClientesDao dao = new ClientesDao();

	public DefaultTableModel listarClientes() {
		// Método para preencher a tabela de dados cliente

		ArrayList<ClientesBeans> orcamento = dao.listarClientes();
		// Cria um objeto para receber os dados da classe Beans

		DefaultTableModel table = (DefaultTableModel) Clientes.tabelaClientes.getModel();
		// Cria uma tabela usando o modelo criado na view

		if (table.getRowCount() > 0) {
			table.setRowCount(0);
		} // Zera as tabela criada para adicionar os dados do banco

		for (ClientesBeans item : orcamento) {
			Object[] linha = new Object[5];
			linha[0] = ((ClientesBeans) item).getCodigoCliente();
			linha[1] = ((ClientesBeans) item).getNomeCliente();
			linha[2] = ((ClientesBeans) item).getFoneCliente();
			linha[3] = ((ClientesBeans) item).getEmailCliente();
			linha[4] = ((ClientesBeans) item).getEndCliente();
			table.addRow(linha);
			// Preenche a tabela com os dados recebidos da classe Beans
		}

		return table;
		// Retorna a tabela com os dados recebidos da classe Beans
	}

	public void salvar(ClientesBeans cliente) {
		dao.cadastrarCliente(cliente);
	}

	public void removerCliente(int codigoCliente) {
		dao.removerCliente(codigoCliente);
	}

	public ArrayList<ClientesBeans> selecionarCliente() {
		ArrayList<ClientesBeans> cliente = dao.listarClientes();
		for (ClientesBeans item : cliente) {
			Object[] linha = new Object[5];
			linha[0] = ((ClientesBeans) item).getCodigoCliente();
			linha[1] = ((ClientesBeans) item).getNomeCliente();
			linha[2] = ((ClientesBeans) item).getFoneCliente();
			linha[3] = ((ClientesBeans) item).getEmailCliente();
			linha[4] = ((ClientesBeans) item).getEndCliente();
		}
		return cliente;
	}

}
