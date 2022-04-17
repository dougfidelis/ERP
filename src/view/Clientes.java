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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

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
	private JTextField txtCodigoCliente;
	
	private void atualizaTabela() {
		tabelaClientes.setModel(control.atualizaCliente());
	}
	public Clientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabelaClientes.setModel(control.atualizaCliente());
			}
		});
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 468);

		/** _________________Elementos do frame_____________________ **/

		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {});
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 756, 211);
		contentPane.add(scrollPane);
		
		tabelaClientes = new JTable();
		tabelaClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { 
						"C\u00F3digo", "Nome", "Fone", "E-mail" })
				);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(259);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaClientes);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(615, 272, 86, 20);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		/** _________________Botões e suas funções_____________________ **/
		JButton btnAtualizar = new JButton("Atualizar lista ");
		btnAtualizar.setBounds(20, 271, 139, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaTabela();
				}
			});
		contentPane.add(btnAtualizar);

		JButton btnCadastrarNovoCliente = new JButton("Cadastrar novo cliente");
		btnCadastrarNovoCliente.setBounds(190, 271, 191, 23);
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
				int linha = tabelaClientes.getSelectedRow();
				String codigoCliente = tabelaClientes.getValueAt(linha, 0).toString();
				txtCodigoCliente.setText(codigoCliente);
				control.removerCliente((int) tabelaClientes.getValueAt(linha, 0));
				atualizaTabela();
			}
		});
		btnRemoverCliente.setBounds(414, 271, 191, 23);
		contentPane.add(btnRemoverCliente);
		
		
		
		
	}
}
