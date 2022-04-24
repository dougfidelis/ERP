package view.orcamento;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;

public class CadastrarItem extends JFrame {
	static JTable tabMat;
	private JTextField txtCodigoItem;
	private JTextField txtDescricao;
	private JTextField txtValor;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Cadastrar Item");
		setBounds(100, 100, 650, 643);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel painel_atributos = new JPanel();
		painel_atributos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos do Item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 100, 100)));
		painel_atributos.setLayout(null);
		
		JScrollPane scrollPane_Detalhes = new JScrollPane();
		scrollPane_Detalhes.setBounds(22, 90, 568, 66);
		painel_atributos.add(scrollPane_Detalhes);
		
		JTextArea textArea = new JTextArea();
		scrollPane_Detalhes.setViewportView(textArea);
		textArea.setBorder(null);
		
		txtCodigoItem = new JTextField();
		txtCodigoItem.setBounds(22, 45, 46, 20);
		painel_atributos.add(txtCodigoItem);
		txtCodigoItem.setEditable(false);
		txtCodigoItem.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(78, 45, 417, 20);
		painel_atributos.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(505, 45, 85, 20);
		painel_atributos.add(txtValor);
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1.setBounds(78, 24, 58, 14);
		painel_atributos.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(22, 24, 46, 14);
		painel_atributos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor");
		lblNewLabel_1_2.setBounds(505, 24, 86, 14);
		painel_atributos.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Detalhes");
		lblNewLabel_1_1_1.setBounds(22, 76, 58, 14);
		painel_atributos.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("OSBE M\u00F3veis sob medida \u00A92022 ");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel painel_materiais = new JPanel();
		painel_materiais.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Materiais do Item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 100, 100)));
		painel_materiais.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 20, 580, 250);
		painel_materiais.add(scrollPane);
		
		tabMat = new JTable();
		tabMat.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "C\u00F3digo", "Descri\u00E7\u00E3o", "Valor Unidade", "QTD", "Sub Total"
			}
		));
		tabMat.getColumnModel().getColumn(0).setPreferredWidth(45);
		tabMat.getColumnModel().getColumn(0).setMinWidth(45);
		tabMat.getColumnModel().getColumn(1).setPreferredWidth(45);
		tabMat.getColumnModel().getColumn(1).setMinWidth(45);
		tabMat.getColumnModel().getColumn(2).setPreferredWidth(441);
		tabMat.getColumnModel().getColumn(2).setMinWidth(100);
		tabMat.getColumnModel().getColumn(3).setPreferredWidth(97);
		tabMat.getColumnModel().getColumn(3).setMinWidth(70);
		tabMat.getColumnModel().getColumn(4).setPreferredWidth(45);
		tabMat.getColumnModel().getColumn(4).setMinWidth(45);
		tabMat.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabMat.getColumnModel().getColumn(5).setMinWidth(110);
		scrollPane.setViewportView(tabMat);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarMaterial frame = new AdicionarMaterial();
				frame.setVisible(true);
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnEditar = new JButton("Editar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(painel_atributos, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(170)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(painel_materiais, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(246)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(painel_atributos, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnRemover)
						.addComponent(btnEditar))
					.addGap(6)
					.addComponent(painel_materiais, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel))
		);
		panel.setLayout(gl_panel);
		getContentPane().add(scrollPane_2);

	}
}
