package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		// JOptionPane.showOptionDialog(null, "Cadastro realizado com sucesso!",
		// "Cadastro OK", -1, 1, null, null, null);
		// JOptionPane.showOptionDialog(null, "ACESSO NEGADO!", "ERRO", -1, 0, null,
		// null, null);
		// JOptionPane.showOptionDialog(null, "ALERT SEM ICONE!", "BEM VINDO!", -1, -1,
		// null, null, null);
		// JOptionPane.showOptionDialog(null, "Informe o e-mail!", "Aten��o!", -1, 2,
		// null,null, null);

		// int op = JOptionPane.showConfirmDialog(null, "Confirma a exclus�o do contato
		// selecionado?", "Remover Contato",
		// JOptionPane.OK_CANCEL_OPTION);
		// if (op == JOptionPane.OK_OPTION)
		// System.out.println("OK");

		// if (op == JOptionPane.CANCEL_OPTION)
		// System.out.println("CANCEL");

		

		
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();			
			String data = dateFormat.format(date);
			System.out.println(data);
	

	}

}
