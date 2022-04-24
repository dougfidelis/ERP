package view.estoque;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MaterialControl;
import model.MaterialBeans;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CadastrarMateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMateria frame = new CadastrarMateria();
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
	public static String tabela;
	private JTextField textField;

	public CadastrarMateria() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione uma categoria", "Chapas", "Fitas", "Corredicas", "Custos" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(10, 102, 240, 32);
		panel.add(comboBox);

		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1.setBounds(115, 50, 46, 14);
		panel.add(lblNewLabel_1_1);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(115, 71, 347, 20);
		panel.add(txtDescricao);

		JLabel lblNewLabel_1_2 = new JLabel("Valor UN");
		lblNewLabel_1_2.setBounds(472, 50, 46, 14);
		panel.add(lblNewLabel_1_2);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(568, 71, 39, 20);
		panel.add(txtQuantidade);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(472, 71, 86, 20);
		panel.add(txtValor);

		JLabel lblNewLabel_1_2_1 = new JLabel("QTD");
		lblNewLabel_1_2_1.setBounds(568, 50, 46, 14);
		panel.add(lblNewLabel_1_2_1);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque.tabela_Chapas.setModel(MaterialControl.listarMaterial("chapas"));
				Estoque.tabela_Chapas.setModel(MaterialControl.listarMaterial("chapas"));
				Estoque.tabela_Chapas.setModel(MaterialControl.listarMaterial("chapas"));
			}
		});

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				String combo;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					combo = e.getItem().toString().toLowerCase();

					btnAdicionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// System.out.println(combo.toLowerCase());
							String descricao = txtDescricao.getText();
							double valor = Double.parseDouble(txtValor.getText());
							double quantidade = Double.parseDouble(txtQuantidade.getText());

							MaterialBeans material = new MaterialBeans(descricao, valor, quantidade);
							MaterialControl c = new MaterialControl();
							c.cadastrarMaterial(combo, material);
							Estoque.tabela_Chapas.setModel(MaterialControl.listarMaterial("chapas"));
							dispose();
							// System.out.println("INSERT INTO "+combo+" `descricao`, `valor`, `quantidade`
							// VALUES (?, ?, ?)");
						}
					});
				}

			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdicionar.setBounds(462, 113, 145, 37);
		panel.add(btnAdicionar);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 71, 95, 20);
		panel.add(textField);

		JLabel lblNewLabel_1_1_1 = new JLabel("Categoria");
		lblNewLabel_1_1_1.setBounds(10, 50, 95, 14);
		panel.add(lblNewLabel_1_1_1);
	}
}
