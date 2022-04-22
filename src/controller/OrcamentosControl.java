package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.OrcamentosBeans;
import model.OrcamentosDao;
import view.orcamento.Orcamentos;

public class OrcamentosControl {
	
	private OrcamentosDao  orcaDao = new OrcamentosDao();
	public DefaultTableModel listarOrcamentos() {
		ArrayList<OrcamentosBeans> orcamento = orcaDao.listarOrcamento();
		DefaultTableModel table = (DefaultTableModel) Orcamentos.tabelaOrcamento.getModel();
		if (table.getRowCount() > 0) {
			table.setRowCount(0);
		}	
		for (OrcamentosBeans item : orcamento) {
			Object[] linha = new Object[11];
			linha[0] = ((OrcamentosBeans) item).getCodigoOrcamento();
			linha[1] = ((OrcamentosBeans) item).getValidade();
			linha[2] = ((OrcamentosBeans) item).getEntrega();
			linha[3] = ((OrcamentosBeans) item).getRt();
			linha[4] = ((OrcamentosBeans) item).getImposto();
			linha[5] = ((OrcamentosBeans) item).getValor();
			linha[6] = ((OrcamentosBeans) item).getArquiteto();
			linha[7] = ((OrcamentosBeans) item).getEmissao();
			linha[8] = ((OrcamentosBeans) item).getFormPgto();
			linha[9] = ((OrcamentosBeans) item).getSituacao();
			linha[10] = ((OrcamentosBeans) item).getCodigoCliente();
			table.addRow(linha);
		}
		return table;
	}	
	public void salvar(OrcamentosBeans cliente) {
		//dao.cadastrarCliente(cliente);
	}
	
	public void removerCliente(int codigoCliente) {
		//OrcamentosDao.removerCliente(codigoCliente);
	}	
	
	/*public ArrayList<OrcamentosBeans> selecionarCliente() {
		ArrayList<OrcamentosBeans> cliente = dao.listarClientes();
		for (OrcamentosBeans item : cliente) {
			Object[] linha = new Object[5];
			linha[0] = ((OrcamentosBeans) item).getCodigoCliente();
			linha[1] = ((OrcamentosBeans) item).getNomeCliente();
			linha[2] = ((OrcamentosBeans) item).getFoneCliente();
			linha[3] = ((OrcamentosBeans) item).getEmailCliente();
			linha[4] = ((OrcamentosBeans) item).getEndCliente();
		}
		return cliente;
	}*/
	
	

}
