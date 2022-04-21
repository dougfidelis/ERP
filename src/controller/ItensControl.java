package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.ClientesBeans;
import model.ComboDao;
import model.ItensBeans;
import view.orcamento.AdicionarMaterial;

public class ItensControl {
	
	private static ComboDao dao = new ComboDao();
	public static DefaultTableModel listarItens(String sql) {
		ArrayList<ItensBeans> tabela = dao.listarItens(sql);		
		DefaultTableModel table = (DefaultTableModel) AdicionarMaterial.tabelaItem.getModel();
		if (table.getRowCount() > 0) {
			table.setRowCount(0);
		}
		
		for (ItensBeans item : tabela) {
			Object[] linha = new Object[4];
			linha[0] = ((ItensBeans) item).getCodigoItem();
			linha[1] = ((ItensBeans) item).getDescricao();
			linha[2] = ((ItensBeans) item).getQuantidade();
			linha[3] = ((ItensBeans) item).getValor();
			table.addRow(linha);
		}

		return table;
	}	
	
	/*public void salvar(ClientesBeans cliente) {
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
	}*/
	
	

}
