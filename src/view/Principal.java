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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque frame = new Estoque();
				frame.setVisible(true);
			}
		});
		btnEstoque.setBounds(31, 100, 129, 23);
		contentPane.add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes frame = new Clientes();
				frame.setVisible(true);
			}
		});
		btnClientes.setBounds(31, 136, 129, 23);
		contentPane.add(btnClientes);
		
		JButton btnOrcamento = new JButton("Or\u00E7amentos");
		btnOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orcamentos frame = new Orcamentos();
				frame.setVisible(true);
			}
		});
		btnOrcamento.setBounds(31, 170, 129, 23);
		contentPane.add(btnOrcamento);
	}
}
