package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class NovoOrcamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEndCliente;
	private JTextField txtNomeDoCliente;
	private JTextField textField_4;
	private JTextField txtCodclientecodorcamento;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoOrcamento frame = new NovoOrcamento();
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
	public NovoOrcamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoOramento = new JLabel("Novo or\u00E7amento");
		lblNovoOramento.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNovoOramento.setBounds(10, 21, 227, 42);
		contentPane.add(lblNovoOramento);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 133, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 163, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 191, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(350, 133, 53, 14);
		contentPane.add(lblFone);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(395, 132, 194, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 189, 269, 20);
		contentPane.add(textField_1);
		
		txtEndCliente = new JTextField();
		txtEndCliente.setText("End Cliente");
		txtEndCliente.setColumns(10);
		txtEndCliente.setBounds(53, 161, 269, 20);
		contentPane.add(txtEndCliente);
		
		txtNomeDoCliente = new JTextField();
		txtNomeDoCliente.setText("Nome Cliente");
		txtNomeDoCliente.setColumns(10);
		txtNomeDoCliente.setBounds(53, 133, 269, 20);
		contentPane.add(txtNomeDoCliente);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(350, 165, 53, 14);
		contentPane.add(lblData);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(395, 162, 194, 20);
		contentPane.add(textField_4);
		
		txtCodclientecodorcamento = new JTextField();
		txtCodclientecodorcamento.setText("codCliente+codOrcamento");
		txtCodclientecodorcamento.setColumns(10);
		txtCodclientecodorcamento.setBounds(444, 190, 145, 20);
		contentPane.add(txtCodclientecodorcamento);
		
		JLabel lblNumero = new JLabel("N\u00B0 or\u00E7amento");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero.setBounds(350, 193, 98, 14);
		contentPane.add(lblNumero);
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateriais.setBounds(10, 252, 79, 20);
		contentPane.add(lblMateriais);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(112, 253, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(227, 253, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(336, 253, 89, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 579, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor Unidade", "QTD", "Sub Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setMinWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(441);
		table.getColumnModel().getColumn(1).setMinWidth(330);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setMinWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(104);
		table.getColumnModel().getColumn(4).setMinWidth(70);
		scrollPane.setViewportView(table);
		
		JLabel lblCustos = new JLabel("Custos");
		lblCustos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustos.setBounds(10, 434, 114, 20);
		contentPane.add(lblCustos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 465, 579, 113);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null},
			},
			new String[] {
				"C\u00F3digo", "Tipo", "Descri\u00E7\u00E3o", "Valor Unidade", "QTD", "Sub Total"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(0).setMinWidth(45);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(1).setMinWidth(80);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(300);
		table_1.getColumnModel().getColumn(2).setMinWidth(250);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(3).setMinWidth(70);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(4).setMinWidth(45);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(5).setMinWidth(70);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(112, 434, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.setBounds(227, 434, 89, 23);
		contentPane.add(btnRemover_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setBounds(336, 434, 89, 23);
		contentPane.add(btnEditar_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Informa\u00E7\u00F5es do cliente");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 108, 205, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 88, 579, 126);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 225, 579, 151);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 410, 579, 163);
		contentPane.add(separator_2);
	}
}
