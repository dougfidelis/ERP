package view.orcamento;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.OrcamentosControl;
import model.OrcamentosBeans;
import model.OrcamentosDao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;

public class Orcamentos extends JFrame {

	private JPanel contentPane;
	public static JTable tabelaOrcamento;

	/**
	 * Launch the application.
	 */
	OrcamentosDao orcaDao = new OrcamentosDao();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orcamentos frame = new Orcamentos();
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
	public Orcamentos() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				OrcamentosControl orcaControl = new OrcamentosControl();
				tabelaOrcamento.setModel(orcaControl.listarOrcamentos());
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//ArrayList<OrcamentosBeans> orcamento = orcaDao.listarOrcamento();
				OrcamentosControl orcaControl = new OrcamentosControl();
				tabelaOrcamento.setModel(orcaControl.listarOrcamentos());
			}
		});
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Orçamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 847, 529);
		
		/** __________________Elementos do frame_______________________ **/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Novo or\u00E7amento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarOrcamento frame = new CadastrarOrcamento();
				//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				// dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 116, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 58, 787, 385);
		contentPane.add(scrollPane);
		
		tabelaOrcamento = new JTable();
		tabelaOrcamento.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, "", null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo Or\u00E7amento", "Validade", "Entrega", "RT", "Imposto", "Valor", "Arquiteto", "Emissao", "Forma de pagamento", "Situa\u00E7\u00E3o", "Codigo Cliente"
			}
		));
		tabelaOrcamento.getColumnModel().getColumn(0).setPreferredWidth(105);
		tabelaOrcamento.getColumnModel().getColumn(1).setPreferredWidth(53);
		tabelaOrcamento.getColumnModel().getColumn(2).setPreferredWidth(53);
		tabelaOrcamento.getColumnModel().getColumn(3).setPreferredWidth(30);
		tabelaOrcamento.getColumnModel().getColumn(4).setPreferredWidth(51);
		tabelaOrcamento.getColumnModel().getColumn(5).setPreferredWidth(78);
		tabelaOrcamento.getColumnModel().getColumn(6).setPreferredWidth(81);
		tabelaOrcamento.getColumnModel().getColumn(8).setPreferredWidth(112);
		tabelaOrcamento.getColumnModel().getColumn(9).setPreferredWidth(82);
		tabelaOrcamento.getColumnModel().getColumn(10).setPreferredWidth(83);
		scrollPane.setViewportView(tabelaOrcamento);
		
		/** _________________Botões e suas funções_____________________ **/

	}
}
