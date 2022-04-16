package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(31, 100, 129, 23);
		contentPane.add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(31, 136, 129, 23);
		contentPane.add(btnClientes);
		
		JButton btnOrcamento = new JButton("Or\u00E7amentos");
		btnOrcamento.setBounds(31, 170, 129, 23);
		contentPane.add(btnOrcamento);
	}
}
