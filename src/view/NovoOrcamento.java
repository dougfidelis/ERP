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
import javax.swing.JTextPane;

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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoOramento = new JLabel("Novo or\u00E7amento");
		lblNovoOramento.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNovoOramento.setBounds(10, 11, 227, 42);
		contentPane.add(lblNovoOramento);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 119, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 147, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(350, 89, 53, 14);
		contentPane.add(lblFone);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(395, 88, 194, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 145, 269, 20);
		contentPane.add(textField_1);
		
		txtEndCliente = new JTextField();
		txtEndCliente.setText("End Cliente");
		txtEndCliente.setColumns(10);
		txtEndCliente.setBounds(53, 117, 269, 20);
		contentPane.add(txtEndCliente);
		
		txtNomeDoCliente = new JTextField();
		txtNomeDoCliente.setText("Nome Cliente");
		txtNomeDoCliente.setColumns(10);
		txtNomeDoCliente.setBounds(53, 89, 269, 20);
		contentPane.add(txtNomeDoCliente);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(350, 121, 53, 14);
		contentPane.add(lblData);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(395, 118, 194, 20);
		contentPane.add(textField_4);
		
		txtCodclientecodorcamento = new JTextField();
		txtCodclientecodorcamento.setText("codCliente+codOrcamento");
		txtCodclientecodorcamento.setColumns(10);
		txtCodclientecodorcamento.setBounds(444, 146, 145, 20);
		contentPane.add(txtCodclientecodorcamento);
		
		JLabel lblNumero = new JLabel("N\u00B0 or\u00E7amento");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero.setBounds(350, 149, 98, 14);
		contentPane.add(lblNumero);
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateriais.setBounds(10, 202, 79, 20);
		contentPane.add(lblMateriais);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(112, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(227, 203, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(336, 203, 89, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 579, 113);
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
		lblCustos.setBounds(10, 379, 114, 20);
		contentPane.add(lblCustos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 410, 579, 113);
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
		btnNewButton_1.setBounds(112, 379, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.setBounds(227, 379, 89, 23);
		contentPane.add(btnRemover_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setBounds(336, 379, 89, 23);
		contentPane.add(btnEditar_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Informa\u00E7\u00F5es do cliente");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 64, 205, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 579, 126);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 181, 579, 151);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 363, 579, 163);
		contentPane.add(separator_2);
		
		JLabel lblValorTotal = new JLabel("Valor total");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorTotal.setBounds(475, 549, 114, 20);
		contentPane.add(lblValorTotal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(451, 576, 138, 20);
		contentPane.add(textField_2);
		
		JLabel lblArquiteto = new JLabel("Arquiteto - %");
		lblArquiteto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArquiteto.setBounds(10, 549, 98, 14);
		contentPane.add(lblArquiteto);
		
		JLabel lblImposto = new JLabel("Imposto %");
		lblImposto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImposto.setBounds(312, 549, 79, 14);
		contentPane.add(lblImposto);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 549, 114, 20);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(236, 549, 46, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(395, 547, 46, 20);
		contentPane.add(textField_6);
		
		JLabel lblPrazoEntrega = new JLabel("Prazo entrega");
		lblPrazoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrazoEntrega.setBounds(10, 578, 98, 14);
		contentPane.add(lblPrazoEntrega);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(112, 576, 170, 20);
		contentPane.add(textField_7);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValidade.setBounds(312, 578, 79, 14);
		contentPane.add(lblValidade);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(395, 576, 46, 20);
		contentPane.add(textField_8);
		
		JTextPane txtpnKjbidhnfabsadpiSdkfjhasfhasf = new JTextPane();
		txtpnKjbidhnfabsadpiSdkfjhasfhasf.setText("kjbidhnfa\u00E7bsadpi\r\nsdkfjhasfhasf");
		txtpnKjbidhnfabsadpiSdkfjhasfhasf.setBounds(10, 603, 579, 57);
		contentPane.add(txtpnKjbidhnfabsadpiSdkfjhasfhasf);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 536, 579, 135);
		contentPane.add(separator_3);
	}
}
