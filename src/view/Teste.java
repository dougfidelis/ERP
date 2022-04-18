package view;

import java.util.ArrayList;
import java.util.Iterator;

import model.Beans;
import model.DAO;

public class Teste {

	public static void main(String[] args) {
		// JOptionPane.showOptionDialog(null, "Cadastro realizado com sucesso!",
		// "Cadastro OK", -1, 1, null, null, null);
		// JOptionPane.showOptionDialog(null, "ACESSO NEGADO!", "ERRO", -1, 0, null,
		// null, null);
		// JOptionPane.showOptionDialog(null, "ALERT SEM ICONE!", "BEM VINDO!", -1, -1,
		// null, null, null);
		// JOptionPane.showOptionDialog(null, "Informe o e-mail!", "Atenção!", -1, 2,
		// null,null, null);

		// int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do contato
		// selecionado?", "Remover Contato",
		// JOptionPane.OK_CANCEL_OPTION);
		// if (op == JOptionPane.OK_OPTION)
		// System.out.println("OK");

		// if (op == JOptionPane.CANCEL_OPTION)
		// System.out.println("CANCEL");

		DAO dao = new DAO();
		// ArrayList<Beans> cliente = dao.selecionarCliente(37);
		// String nome = cliente.get(0).getNomeCliente();
		// System.out.println(nome);
		ArrayList<Beans> aux = dao.listarClientes();
		String nome = (aux.get(0).getNomeCliente());
		String fone = (aux.get(0).getFoneCliente());
		String email = (aux.get(0).getEmailCliente());
		String end = (aux.get(0).getEndCliente());
		for (int i = 0; i < aux.size(); i++) {
			System.out.println(aux.get(i).getCodigoCliente());
		}

	}

}
