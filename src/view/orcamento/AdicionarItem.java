package view.orcamento;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ItensControl;
import model.ComboDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdicionarItem extends JFrame {

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
	ItensControl control = new ItensControl();
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarItem frame = new AdicionarItem();
					frame.setVisible(true);
					//tabelaItem.setModel(ItensControl.listarItens("mdf"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarItem() {
		setTitle("ERP - Adicionar Item");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Item");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 210, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 86, 708, 135);
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
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Detalhes", "Valor"
			}
		));
		tabelaItem.getColumnModel().getColumn(0).setPreferredWidth(46);
		tabelaItem.getColumnModel().getColumn(1).setPreferredWidth(216);
		tabelaItem.getColumnModel().getColumn(2).setPreferredWidth(417);
		tabelaItem.getColumnModel().getColumn(3).setPreferredWidth(94);
		scrollPane.setViewportView(tabelaItem);
		
		txt_cd_sel = new JTextField();
		txt_cd_sel.setEditable(false);
		txt_cd_sel.setBounds(21, 299, 46, 20);
		contentPane.add(txt_cd_sel);
		txt_cd_sel.setColumns(10);
		
		txt_desc_sel = new JTextField();
		txt_desc_sel.setColumns(10);
		txt_desc_sel.setBounds(77, 299, 401, 20);
		contentPane.add(txt_desc_sel);
		
		txt_valor_sel = new JTextField();
		txt_valor_sel.setColumns(10);
		txt_valor_sel.setBounds(488, 299, 86, 20);
		contentPane.add(txt_valor_sel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(21, 278, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1.setBounds(77, 278, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor UN");
		lblNewLabel_1_2.setBounds(488, 278, 46, 14);
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
					double sub = qtd*vlr;
					txt_sub_tot.setText(String.valueOf(sub));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		txt_qtd.setColumns(10);
		txt_qtd.setBounds(584, 299, 39, 20);
		contentPane.add(txt_qtd);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("QTD");
		lblNewLabel_1_2_1.setBounds(584, 278, 46, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		txt_sub_tot = new JTextField();
		txt_sub_tot.setColumns(10);
		txt_sub_tot.setBounds(633, 299, 96, 20);
		contentPane.add(txt_sub_tot);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Sub Total");
		lblNewLabel_1_2_2.setBounds(633, 278, 46, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(550, 361, 145, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblItensCadastrados = new JLabel("Itens cadastrados");
		lblItensCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItensCadastrados.setBounds(20, 54, 210, 32);
		contentPane.add(lblItensCadastrados);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Detalhes");
		lblNewLabel_1_1_1.setBounds(77, 330, 60, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(77, 349, 401, 67);
		contentPane.add(textField);
		
		JButton btnCadastrarNovoItem = new JButton("Cadastrar novo item");
		btnCadastrarNovoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarItem frame = new CadastrarItem();
				frame.setVisible(true);
			}
		});
		btnCadastrarNovoItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarNovoItem.setBounds(21, 232, 163, 30);
		contentPane.add(btnCadastrarNovoItem);
	}
}
