package view.orcamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CadastrarItem extends JFrame {
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarItem frame = new CadastrarItem();
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
	public CadastrarItem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Cadastrar Item");
		setBounds(100, 100, 712, 674);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(309, 250, 89, 23);
		getContentPane().add(btnEditar);
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateriais.setBounds(45, 249, 79, 20);
		getContentPane().add(lblMateriais);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(210, 250, 89, 23);
		getContentPane().add(btnRemover);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarMaterial frame = new AdicionarMaterial();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(111, 250, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 280, 579, 143);
		getContentPane().add(scrollPane);
		
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
		separator_1.setBounds(45, 241, 579, 203);
		getContentPane().add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 481, 579, 143);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
		scrollPane_1.setViewportView(table_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setBounds(299, 447, 89, 23);
		getContentPane().add(btnEditar_1);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(101, 447, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.setBounds(200, 447, 89, 23);
		getContentPane().add(btnRemover_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(45, 434, 579, 163);
		getContentPane().add(separator_2);
		
		JLabel lblCustos = new JLabel("Custos");
		lblCustos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustos.setBounds(45, 450, 114, 20);
		getContentPane().add(lblCustos);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(45, 92, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(45, 113, 46, 20);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1.setBounds(101, 92, 58, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 113, 427, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor UN");
		lblNewLabel_1_2.setBounds(538, 92, 86, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(538, 113, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(45, 163, 579, 67);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Datalhes");
		lblNewLabel_1_1_1.setBounds(45, 138, 58, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblCadastrarItem = new JLabel("Cadastrar item");
		lblCadastrarItem.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCadastrarItem.setBounds(26, 23, 210, 32);
		getContentPane().add(lblCadastrarItem);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalvar.setBounds(484, 34, 140, 32);
		getContentPane().add(btnSalvar);

	}
}
