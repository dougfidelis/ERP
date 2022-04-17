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
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.Dimension;

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

	private void atualizaTabela() {
		tabelaClientes.setModel(control.listarClientes());
	}

	public Clientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabelaClientes.setModel(control.listarClientes());
			}
		});
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 468);

		/** _________________Elementos do frame_____________________ **/

		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
		});
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 756, 211);
		contentPane.add(scrollPane);

		tabelaClientes = new JTable();
		tabelaClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Fone", "E-mail" }));
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(259);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaClientes);

		/** _________________Botões e suas funções_____________________ **/
		JButton btnAtualizar = new JButton("Atualizar lista ");
		btnAtualizar.setPreferredSize(new Dimension(100, 23));
		btnAtualizar.setBounds(30, 271, 141, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaTabela();
			}
		});
		contentPane.add(btnAtualizar);

		JButton btnCadastrarNovoCliente = new JButton("Cadastrar novo cliente");
		btnCadastrarNovoCliente.setPreferredSize(new Dimension(100, 23));
		btnCadastrarNovoCliente.setBounds(228, 271, 141, 23);
		btnCadastrarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente frame = new CadastrarCliente();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnCadastrarNovoCliente);

		JButton btnRemoverCliente = new JButton("Remover cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente selecionado?",
						"Remover Cliente", JOptionPane.OK_CANCEL_OPTION);
				if (op == JOptionPane.OK_OPTION) {
					int linha = tabelaClientes.getSelectedRow();
					control.removerCliente((int) tabelaClientes.getValueAt(linha, 0));
					atualizaTabela();
				}
			}
		});
		btnRemoverCliente.setBounds(635, 271, 141, 23);
		contentPane.add(btnRemoverCliente);

		JButton btnEditarCliente = new JButton("Editar cliente");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCliente frame = new EditarCliente();
				frame.setVisible(true);
			}
		});
		btnEditarCliente.setBounds(432, 271, 141, 23);
		contentPane.add(btnEditarCliente);

	}
}
