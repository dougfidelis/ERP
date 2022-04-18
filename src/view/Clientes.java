package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Beans;
import model.DAO;
import java.awt.event.WindowEvent;
import javax.swing.JScrollBar;

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

	static JTextField txtCod;
	public static int codDao = 0;
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
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaClientes.getSelectedRow();
				txtCod.setText((tabelaClientes.getValueAt(linha, 0)).toString());
			}
		});
		tabelaClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Fone", "E-mail" }));
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(259);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaClientes);

		JButton btnCadastrarNovoCliente = new JButton("Cadastrar novo cliente");
		btnCadastrarNovoCliente.setPreferredSize(new Dimension(100, 23));
		btnCadastrarNovoCliente.setBounds(228, 271, 141, 23);
		btnCadastrarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente frame = new CadastrarCliente();
				frame.setVisible(true);
				dispose();
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
					tabelaClientes.setModel(control.listarClientes());
				}
			}
		});
		btnRemoverCliente.setBounds(635, 271, 141, 23);
		contentPane.add(btnRemoverCliente);

		// int linha = tabelaClientes.getSelectedRow();
		// int codigo = (int) tabelaClientes.getValueAt(linha, 0);

		JButton btnEditarCliente = new JButton("Editar cliente");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				EditarCliente frame = new EditarCliente();
				frame.setVisible(true);
				dispose();
				DAO dao = new DAO();
				//Clientes c = new Clientes();
				int linha = tabelaClientes.getSelectedRow();
				int aux = (int)tabelaClientes.getValueAt(linha, 0);
				ArrayList<Beans> cliente = dao.selecionarCliente(aux);
				codDao = cliente.get(0).getCodigoCliente();
				

				//int codInt = ( tabelaClientes.getValueAt(linha, 0))));
			}
		});
		btnEditarCliente.setBounds(432, 271, 141, 23);
		contentPane.add(btnEditarCliente);

		JButton btnAtualiza = new JButton("Atualizar lista");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaClientes.setModel(control.listarClientes());
			}
		});
		btnAtualiza.setBounds(20, 271, 141, 23);
		contentPane.add(btnAtualiza);

		txtCod = new JTextField();
		txtCod.setBounds(511, 305, 60, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnVoltarAoInicio = new JButton("Voltar ao inicio");
		btnVoltarAoInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal frame = new Principal();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltarAoInicio.setBounds(635, 377, 141, 23);
		contentPane.add(btnVoltarAoInicio);

	}
}
