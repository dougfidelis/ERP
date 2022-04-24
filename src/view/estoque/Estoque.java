package view.estoque;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.MaterialControl;
import view.Principal;

public class Estoque extends JFrame {

	private JPanel contentPane;
	public static JTable tabela_Chapas;
	private JTable tabela_Fitas;
	private JTable tabela_Corredicas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabela_Chapas.setModel(MaterialControl.listarMaterial("chapas"));
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Principal frame = new Principal();
				frame.setVisible(true);
			}
		});
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 635);

		/** __________________Elementos do frame_______________________ **/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panel_estoque = new JPanel();
		scrollPane.setViewportView(panel_estoque);
		
		JPanel Info_Estoque = new JPanel();
		Info_Estoque.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informa\u00E7\u00F5es do estoque", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowBorder));
		
		JPanel painel_Mateirais = new JPanel();
		painel_Mateirais.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Materiais em estoque", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 100, 100)));
		
		JButton btnCadastrar = new JButton("Cadastrar Material");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMateria frame = new CadastrarMateria();
				frame.setVisible(true);
			}
		});
		painel_Mateirais.setLayout(new BoxLayout(painel_Mateirais, BoxLayout.X_AXIS));
		
		JTabbedPane painel_Categorias = new JTabbedPane(JTabbedPane.TOP);
		painel_Mateirais.add(painel_Categorias);
		painel_Categorias.setToolTipText("");
		
		JScrollPane scroll_Fitas = new JScrollPane();
		scroll_Fitas.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tabela_Fitas.setModel(MaterialControl.listarMaterial("fitas"));
			}
		});
		
		JPanel panel = new JPanel();
		painel_Categorias.addTab("Chapas", null, panel, null);
		
		JPanel panel_1_1 = new JPanel();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		tabela_Chapas = new JTable();
		scrollPane_2.setViewportView(tabela_Chapas);
		tabela_Chapas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor", "QTD"
			}
		));
		tabela_Chapas.getColumnModel().getColumn(0).setPreferredWidth(48);
		tabela_Chapas.getColumnModel().getColumn(1).setPreferredWidth(633);
		tabela_Chapas.getColumnModel().getColumn(2).setPreferredWidth(84);
		tabela_Chapas.getColumnModel().getColumn(3).setPreferredWidth(35);
		panel_1_1.setLayout(new BoxLayout(panel_1_1, BoxLayout.X_AXIS));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(scrollPane_2);
		panel.add(panel_1_1);
		painel_Categorias.addTab("Fitas", null, scroll_Fitas, null);
		
		tabela_Fitas = new JTable();
		tabela_Fitas.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor", "QTD"
				}
			));
		tabela_Fitas.getColumnModel().getColumn(0).setPreferredWidth(48);
		tabela_Fitas.getColumnModel().getColumn(1).setPreferredWidth(633);
		tabela_Fitas.getColumnModel().getColumn(2).setPreferredWidth(84);
		tabela_Fitas.getColumnModel().getColumn(3).setPreferredWidth(35);
		scroll_Fitas.setViewportView(tabela_Fitas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tabela_Corredicas.setModel(MaterialControl.listarMaterial("corredicas"));
			}
		});
		painel_Categorias.addTab("Corredi\u00E7as", null, scrollPane_1, null);
		
		tabela_Corredicas = new JTable();
		tabela_Corredicas.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor", "QTD"
				}
			));
		tabela_Corredicas.getColumnModel().getColumn(0).setPreferredWidth(48);
		tabela_Corredicas.getColumnModel().getColumn(1).setPreferredWidth(633);
		tabela_Corredicas.getColumnModel().getColumn(2).setPreferredWidth(84);
		tabela_Corredicas.getColumnModel().getColumn(3).setPreferredWidth(35);
		
		scrollPane_1.setViewportView(tabela_Corredicas);
		Info_Estoque.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 41, 595, 70);
		Info_Estoque.add(panel_1);
		panel_1.setLayout(null);
		GroupLayout gl_panel_estoque = new GroupLayout(panel_estoque);
		gl_panel_estoque.setHorizontalGroup(
			gl_panel_estoque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_estoque.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_estoque.createParallelGroup(Alignment.LEADING)
						.addComponent(Info_Estoque, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel_Mateirais, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_estoque.setVerticalGroup(
			gl_panel_estoque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_estoque.createSequentialGroup()
					.addGap(11)
					.addComponent(Info_Estoque, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnCadastrar)
					.addGap(6)
					.addComponent(painel_Mateirais, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
		);
		panel_estoque.setLayout(gl_panel_estoque);
		
		/** _________________Botões e suas funções_____________________ **/
		
		

	}
}
