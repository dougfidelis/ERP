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
	public static Controller control = new Controller();
	public static DAO dao = new DAO();

	static JTextField txtCod;
	public static int codigoSelecionado = 0;
	public static String codigoSelecionadoString = String.valueOf(codigoSelecionado);

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
		JButton btnEditarCliente = new JButton("Editar cliente");
		JButton btnRemoverCliente = new JButton("Remover cliente");

		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaClientes.getSelectedRow();
				codigoSelecionado = ((Integer) tabelaClientes.getValueAt(linha, 0));
				ArrayList<Beans> aux = dao.selecionarCliente(Clientes.codigoSelecionado);
				txtCod.setText(String.valueOf(codigoSelecionado));
				btnEditarCliente.setText("Editar cliente" + " " + String.valueOf(aux.get(0).getCodigoCliente()));
				btnRemoverCliente.setText("Remover cliente" + " " + String.valueOf(aux.get(0).getCodigoCliente()));
			}
		});
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "C\u00F3digo", "Nome", "Fone", "E-mail", "Endere\u00E7o" }));
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(114);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(177);
		tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(263);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaClientes);

		JButton btnCadastrarNovoCliente = new JButton("Cadastrar novo cliente");
		btnCadastrarNovoCliente.setPreferredSize(new Dimension(100, 23));
		btnCadastrarNovoCliente.setBounds(205, 271, 187, 23);
		btnCadastrarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente frame = new CadastrarCliente();
				frame.setVisible(true);
				// dispose();
			}
		});
		contentPane.add(btnCadastrarNovoCliente);
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
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (codigoSelecionado <= 0) {
					JOptionPane.showOptionDialog(null, "Selecione um cliente!", "Atenção!", -1, 2, null, null, null);
				} else {
					EditarCliente frame = new EditarCliente();
					frame.setVisible(true);
					// dispose();
				}

			}
		});
		btnEditarCliente.setBounds(432, 271, 141, 23);
		contentPane.add(btnEditarCliente);
		JButton btnAtualiza = new JButton("Novo orcamento");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (codigoSelecionado <= 0) {
					JOptionPane.showOptionDialog(null, "Selecione um cliente!", "Atenção!", -1, 2, null, null, null);
				} else {
					NovoOrcamento frame = new NovoOrcamento();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					// dispose();
				}
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
