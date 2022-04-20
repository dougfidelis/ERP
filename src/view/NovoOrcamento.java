package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.CharacterData;

import model.Beans;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoOrcamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtFoneCliente;
	private JTextField txtEmailCliente;
	private JTextField txtEndCliente;
	private JTextField txtNomeCliente;
	private JTextField txtData;
	private JTextField txtCodigoOrcamento;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoOrcamento frame = new NovoOrcamento();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ArrayList<Beans> cliente = Clientes.dao.selecionarCliente(Clientes.codigoSelecionado);
				//lblcodDao.setText(String.valueOf(aux.get(0).getCodigoCliente()));
				txtNomeCliente.setText(cliente.get(0).getNomeCliente());
				txtFoneCliente.setText(cliente.get(0).getFoneCliente());
				txtEmailCliente.setText(cliente.get(0).getEmailCliente());
				txtEndCliente.setText(cliente.get(0).getEndCliente());
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date data = new Date();				 
				txtData.setText((String) dateFormat.format(data));
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNovoOramento = new JLabel("Or\u00E7amento Numero:");
		lblNovoOramento.setBounds(10, 0, 269, 49);
		lblNovoOramento.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("End.");
		lblNewLabel_2.setBounds(10, 91, 46, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(10, 119, 48, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setBounds(347, 91, 53, 14);
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtFoneCliente = new JTextField();
		txtFoneCliente.setBounds(395, 89, 194, 20);
		txtFoneCliente.setColumns(10);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(53, 117, 269, 20);
		txtEmailCliente.setColumns(10);
		
		txtEndCliente = new JTextField();
		txtEndCliente.setBounds(53, 89, 269, 20);
		txtEndCliente.setText("End Cliente");
		txtEndCliente.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(53, 61, 269, 20);
		txtNomeCliente.setText("Nome Cliente");
		txtNomeCliente.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(347, 119, 53, 14);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtData = new JTextField();
		txtData.setBounds(395, 117, 194, 20);
		txtData.setColumns(10);
		
		txtCodigoOrcamento = new JTextField();
		txtCodigoOrcamento.setBounds(274, 11, 46, 30);
		txtCodigoOrcamento.setText("codCliente+codOrcamento");
		txtCodigoOrcamento.setColumns(10);
		
		JLabel lblMateriais = new JLabel("Itens");
		lblMateriais.setBounds(10, 283, 79, 20);
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(112, 284, 89, 23);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(227, 284, 89, 23);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(336, 284, 89, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 318, 579, 341);
		
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
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 271, 579, 36);
		
		JLabel lblValorTotal = new JLabel("Valor total");
		lblValorTotal.setBounds(413, 170, 114, 20);
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 170, 89, 20);
		textField_2.setColumns(10);
		
		JLabel lblArquiteto = new JLabel("Arquiteto ");
		lblArquiteto.setBounds(10, 146, 79, 14);
		lblArquiteto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblImposto = new JLabel("Imposto %");
		lblImposto.setBounds(10, 172, 79, 14);
		lblImposto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 143, 114, 20);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(276, 143, 46, 20);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(94, 170, 46, 20);
		textField_6.setColumns(10);
		
		JLabel lblPrazoEntrega = new JLabel("Prazo entrega");
		lblPrazoEntrega.setBounds(349, 145, 98, 14);
		lblPrazoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_7 = new JTextField();
		textField_7.setBounds(444, 143, 145, 20);
		textField_7.setColumns(10);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setBounds(482, 63, 63, 14);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_8 = new JTextField();
		textField_8.setBounds(543, 62, 46, 18);
		textField_8.setColumns(10);
		
		JTextPane txtpnKjbidhnfabsadpiSdkfjhasfhasf = new JTextPane();
		txtpnKjbidhnfabsadpiSdkfjhasfhasf.setBounds(10, 690, 579, 57);
		txtpnKjbidhnfabsadpiSdkfjhasfhasf.setText("kjbidhnfa\u00E7bsadpi\r\nsdkfjhasfhasf");
		contentPane.setLayout(null);
		contentPane.add(lblNovoOramento);
		contentPane.add(btnEditar);
		contentPane.add(lblMateriais);
		contentPane.add(btnRemover);
		contentPane.add(btnNewButton);
		contentPane.add(scrollPane);
		contentPane.add(separator_1);
		contentPane.add(txtNomeCliente);
		contentPane.add(lblNewLabel_2);
		contentPane.add(txtEndCliente);
		contentPane.add(lblNewLabel_3);
		contentPane.add(txtEmailCliente);
		contentPane.add(txtFoneCliente);
		contentPane.add(lblFone);
		contentPane.add(txtData);
		contentPane.add(lblData);
		contentPane.add(txtCodigoOrcamento);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblPrazoEntrega);
		contentPane.add(textField_3);
		contentPane.add(lblImposto);
		contentPane.add(textField_6);
		contentPane.add(textField_8);
		contentPane.add(lblValorTotal);
		contentPane.add(lblArquiteto);
		contentPane.add(textField_2);
		contentPane.add(textField_7);
		contentPane.add(txtpnKjbidhnfabsadpiSdkfjhasfhasf);
		contentPane.add(lblValidade);
		contentPane.add(textField_5);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSituao.setBounds(162, 174, 63, 14);
		contentPane.add(lblSituao);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(389, 195, 138, 20);
		contentPane.add(textField);
		
		JLabel lblFormasDePagamento = new JLabel("Formas  pgto");
		lblFormasDePagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormasDePagamento.setBounds(10, 197, 145, 14);
		contentPane.add(lblFormasDePagamento);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 195, 228, 20);
		contentPane.add(textField_1);
		
		JLabel lblRt = new JLabel("RT");
		lblRt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRt.setBounds(245, 145, 29, 14);
		contentPane.add(lblRt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(430, 62, 35, 18);
		contentPane.add(textField_4);
		
		JLabel lblCdigoCliente = new JLabel("C\u00F3d. Cliente");
		lblCdigoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoCliente.setBounds(347, 62, 100, 14);
		contentPane.add(lblCdigoCliente);
	}
}
