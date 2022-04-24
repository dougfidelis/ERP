package view.orcamento;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ItensControl;
import model.ClientesBeans;
import model.MaterialBeans;
import view.cliente.CadastrarCliente;
import view.cliente.Clientes;

public class AdicionarMaterial extends JFrame {

	private JPanel contentPane;
	public static JTable tabelaItem;
	private JTextField txt_cd_sel;
	private JTextField txt_desc_sel;
	private JTextField txt_valor_sel;
	private JTextField txt_qtd;
	private JTextField txt_sub_tot;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarMaterial frame = new AdicionarMaterial();
					frame.setVisible(true);
					// tabelaItem.setModel(ItensControl.listarItens("mdf"));
					// tabelaItem.setModel(control.listarItens("chapas"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	static ItensControl control = new ItensControl();

	public AdicionarMaterial() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Adicionar Material");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tabelaItem.setModel(control.listarItens(e.getItem().toString()));
				}
			}
		});

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma categoria", "Chapas", "Fitas", "Corredicas", "Custos"}));
		comboBox.setBounds(21, 72, 240, 32);
		contentPane.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 129, 708, 165);
		contentPane.add(scrollPane);

		tabelaItem = new JTable();
		tabelaItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaItem.getSelectedRow();
				txt_cd_sel.setText(tabelaItem.getValueAt(linha, 0).toString());
				txt_desc_sel.setText(tabelaItem.getValueAt(linha, 1).toString());
				txt_valor_sel.setText(tabelaItem.getValueAt(linha, 2).toString());
			}
		});

		tabelaItem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor"
			}
		));
		tabelaItem.getColumnModel().getColumn(1).setPreferredWidth(632);
		tabelaItem.getColumnModel().getColumn(2).setPreferredWidth(94);
		scrollPane.setViewportView(tabelaItem);

		txt_cd_sel = new JTextField();
		txt_cd_sel.setBounds(21, 350, 77, 20);
		contentPane.add(txt_cd_sel);
		txt_cd_sel.setColumns(10);

		txt_desc_sel = new JTextField();
		txt_desc_sel.setColumns(10);
		txt_desc_sel.setBounds(108, 350, 370, 20);
		contentPane.add(txt_desc_sel);

		txt_valor_sel = new JTextField();
		txt_valor_sel.setColumns(10);
		txt_valor_sel.setBounds(488, 350, 86, 20);
		contentPane.add(txt_valor_sel);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(21, 329, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1.setBounds(108, 329, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Valor UN");
		lblNewLabel_1_2.setBounds(488, 329, 46, 14);
		contentPane.add(lblNewLabel_1_2);

		txt_qtd = new JTextField();
		txt_qtd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					double qtd = Double.parseDouble(txt_qtd.getText());
					double vlr = Double.parseDouble(txt_valor_sel.getText());
					double sub = qtd * vlr;
					txt_sub_tot.setText(String.valueOf(sub));
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		txt_qtd.setColumns(10);
		txt_qtd.setBounds(584, 350, 39, 20);
		contentPane.add(txt_qtd);

		JLabel lblNewLabel_1_2_1 = new JLabel("QTD");
		lblNewLabel_1_2_1.setBounds(584, 329, 46, 14);
		contentPane.add(lblNewLabel_1_2_1);

		txt_sub_tot = new JTextField();
		txt_sub_tot.setColumns(10);
		txt_sub_tot.setBounds(633, 350, 96, 20);
		contentPane.add(txt_sub_tot);

		JLabel lblNewLabel_1_2_2 = new JLabel("Sub Total");
		lblNewLabel_1_2_2.setBounds(633, 329, 46, 14);
		contentPane.add(lblNewLabel_1_2_2);

		
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int item = CadastrarItem.tabMat.getRowCount()+1;				
				int codigoMaterial = Integer.parseInt(txt_cd_sel.getText());
				String descricaoMaterial = txt_desc_sel.getText();
				double valorMaterial = Double.parseDouble(txt_valor_sel.getText());
				double quantidadeMaterial = Double.parseDouble(txt_qtd.getText());
				double subTotalMateiral = Double.parseDouble(txt_sub_tot.getText());
				Object[] material = new Object[6];
				material[0] = item;
				material[1] = codigoMaterial;
				material[2] = descricaoMaterial;
				material[3] = valorMaterial;
				material[4] = quantidadeMaterial;
				material[5] = subTotalMateiral;
				DefaultTableModel table = (DefaultTableModel) CadastrarItem.tabMat.getModel();
				table.addRow(material);
				dispose();

			}
		});
		
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdicionar.setBounds(584, 381, 145, 37);
		contentPane.add(btnAdicionar);
	}
}
