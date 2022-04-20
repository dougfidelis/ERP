package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NovoItem extends JFrame {
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoItem frame = new NovoItem();
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
	public NovoItem() {
		setBounds(100, 100, 712, 583);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(378, 71, 89, 23);
		getContentPane().add(btnEditar);
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateriais.setBounds(52, 70, 79, 20);
		getContentPane().add(lblMateriais);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(269, 71, 89, 23);
		getContentPane().add(btnRemover);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(154, 71, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 101, 579, 201);
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
		separator_1.setBounds(52, 59, 579, 264);
		getContentPane().add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(52, 360, 579, 113);
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
		btnEditar_1.setBounds(378, 329, 89, 23);
		getContentPane().add(btnEditar_1);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(154, 329, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.setBounds(269, 329, 89, 23);
		getContentPane().add(btnRemover_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(52, 313, 579, 163);
		getContentPane().add(separator_2);
		
		JLabel lblCustos = new JLabel("Custos");
		lblCustos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustos.setBounds(52, 329, 114, 20);
		getContentPane().add(lblCustos);

	}
}
