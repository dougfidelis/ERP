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

public class Orcamentos extends JFrame {

	private JPanel contentPane;
	public static JTable tabelaOrcamento;

	/**
	 * Launch the application.
	 */
	OrcamentosDao orcaDao = new OrcamentosDao();
	OrcamentosControl orcaControl = new OrcamentosControl();
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//ArrayList<OrcamentosBeans> orcamento = orcaDao.listarOrcamento();
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
				"C\u00F3digo", "Validade", "Entrega", "RT", "Imposto", "Valor", "Arquiteto", "Emissao", "Forma de pagamento", "Situa\u00E7\u00E3o", "Codigo Cliente"
			}
		));
		scrollPane.setViewportView(tabelaOrcamento);
		
		/** _________________Botões e suas funções_____________________ **/

	}
}
