package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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

		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 350);
		/** __________________Elementos do frame_______________________ **/

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/** _________________Botões e suas funções_____________________ **/
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(64, 164, 129, 23);
		contentPane.add(btnEstoque);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque frame = new Estoque();
				frame.setVisible(true);
			}
		});
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(64, 200, 129, 23);
		contentPane.add(btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes frame = new Clientes();
				frame.setVisible(true);
			}
		});
		JButton btnOrcamento = new JButton("Or\u00E7amentos");
		btnOrcamento.setBounds(64, 234, 129, 23);
		contentPane.add(btnOrcamento);
		btnOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orcamentos frame = new Orcamentos();
				frame.setVisible(true);
			}
		});

	}
}
