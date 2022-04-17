package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Clientes extends JFrame {

	private JPanel contentPane;
	public static JTable tabelaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	private Controller control = new Controller();

	public Clientes() {
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 468);

		/** _________________Botões e suas funções_____________________ **/
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(20, 180, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaClientes.setModel(control.atualizaCliente());
				}
			});

		JButton btnCadastrarNovoCliente = new JButton("Cadastrar novo cliente");
		btnCadastrarNovoCliente.setBounds(119, 180, 157, 23);
		contentPane.add(btnCadastrarNovoCliente);
		btnCadastrarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente frame = new CadastrarCliente();
				frame.setVisible(true);
				}
			});
		
		
		/** _________________Elementos do frame_____________________ **/

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabelaClientes);
		scrollPane.setBounds(20, 214, 756, 191);
		tabelaClientes = new JTable();
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(259);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { 
						"C\u00F3digo", "Nome", "Fone", "E-mail" })
				);
	}
}
