package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.MaterialBeans;
import model.MaterialDao;
import view.estoque.Estoque;
import view.orcamento.AdicionarMaterial;

public class MaterialControl {
	
	private static MaterialDao dao = new MaterialDao();
	
	public static DefaultTableModel listarMaterial(String categoria) {
		ArrayList<MaterialBeans> tabela = dao.listarChapas(categoria);		
		DefaultTableModel table = (DefaultTableModel) Estoque.tabela_Chapas.getModel();
		if (table.getRowCount() > 0) {
			table.setRowCount(0);
		}
		
		for (MaterialBeans item : tabela) {
			Object[] linha = new Object[4];
			linha[0] = ((MaterialBeans) item).getCodigoMaterial();
			linha[1] = ((MaterialBeans) item).getDescricaoMaterial();
			linha[2] = ((MaterialBeans) item).getQuantidadeMaterial();
			linha[3] = ((MaterialBeans) item).getValorMaterial();
			table.addRow(linha);
		}

		return table;
	}	
	
	public void cadastrarMaterial(String tabela, MaterialBeans material) {
		dao.cadastrarMaterial(tabela, material);
	}
	
	/*public void removerCliente(int codigoCliente) {
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
