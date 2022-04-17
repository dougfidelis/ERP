package view;

import java.util.ArrayList;

import model.Beans;
import model.DAO;

public class Teste {

	public static void main(String[] args) {
		//JOptionPane.showOptionDialog(null, "Cadastro realizado com sucesso!", "Cadastro OK", -1, 1, null,	null, null);
		//JOptionPane.showOptionDialog(null, "ACESSO NEGADO!", "ERRO", -1, 0, null,	null, null);
		//JOptionPane.showOptionDialog(null, "ALERT SEM ICONE!", "BEM VINDO!", -1, -1, null, null, null);
		//JOptionPane.showOptionDialog(null, "Informe o e-mail!", "Atenção!", -1, 2, null,null, null);
		
	//	int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do contato selecionado?", "Remover Contato", 
		//		JOptionPane.OK_CANCEL_OPTION);
		//if (op == JOptionPane.OK_OPTION)
		//	System.out.println("OK");

	//	if (op == JOptionPane.CANCEL_OPTION)
		//	System.out.println("CANCEL");
		
		DAO dao = new DAO();
		ArrayList<Beans> cliente = dao.selecionarCliente(37);
		String nome = cliente.get(0).getNomeCliente();
		System.out.println(nome);
		
		
	}

}
