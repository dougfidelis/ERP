package view.orcamento;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import model.ClientesBeans;
import model.OrcamentosBeans;
import model.OrcamentosDao;
import view.cliente.Clientes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Frame;
import java.awt.Toolkit;

public class CadastrarOrcamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtFoneCliente;
	private JTextField txtEmailCliente;
	private JTextField txtEndCliente;
	private JTextField txtNomeCliente;
	private JTextField txtData;
	private JTable table;
	private JTextField txtSituacao;
	private JTextField txtArquiteto;
	private JTextField txtRT;
	private JTextField txtImposto;
	private JTextField txtEntrega;
	private JTextField txtValidade;
	private JTextField txtValorTotal;
	private JTextField txtFormaPgto;
	private static JTextField txtCodCliente;
	private JLabel lblNumOrc = new JLabel("#");

	/**
	 * Launch the application.
	 */
	OrcamentosDao orcaDao = new OrcamentosDao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarOrcamento frame = new CadastrarOrcamento();
					// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					txtCodCliente.setText("1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public CadastrarOrcamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Gerar Or\u00E7amento");
		setExtendedState(Frame.MAXIMIZED_VERT);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
				ArrayList<ClientesBeans> cliente = Clientes.dao.selecionarCliente(Clientes.codigoSelecionado);
				ArrayList<OrcamentosBeans> orcamento = orcaDao.listarOrcamento();
					txtCodCliente.setText(String.valueOf(Clientes.codigoSelecionado));					
					lblNumOrc.setText(String.valueOf(orcamento.get(orcamento.size() - 1).getCodigoOrcamento() + 1));
					txtNomeCliente.setText(cliente.get(0).getNomeCliente());
					txtFoneCliente.setText(cliente.get(0).getFoneCliente());
					txtEmailCliente.setText(cliente.get(0).getEmailCliente());
					txtEndCliente.setText(cliente.get(0).getEndCliente());
				} catch (Exception e2) {
					txtCodCliente.setText("1");
				}
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date data = new Date();
				txtData.setText((String) dateFormat.format(data));

			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 712);
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
		txtNomeCliente.setText("Consumidor Final");
		txtNomeCliente.setColumns(10);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(347, 119, 53, 14);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtData = new JTextField();
		txtData.setBounds(395, 117, 194, 20);
		txtData.setColumns(10);

		JLabel lblMateriais = new JLabel("Itens");
		lblMateriais.setBounds(10, 238, 79, 20);
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarItem frame = new AdicionarItem();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(53, 239, 79, 23);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(142, 239, 79, 23);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(231, 239, 79, 23);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 579, 270);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "C\u00F3digo", "Descri\u00E7\u00E3o", "Valor Unidade", "QTD", "Sub Total" }));
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

		JLabel lblValorTotal = new JLabel("Valor total");
		lblValorTotal.setBounds(347, 192, 114, 20);
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtSituacao = new JTextField();
		txtSituacao.setText("Aberto");
		txtSituacao.setBounds(233, 170, 89, 20);
		txtSituacao.setColumns(10);

		JLabel lblArquiteto = new JLabel("Arquiteto ");
		lblArquiteto.setBounds(10, 146, 79, 14);
		lblArquiteto.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblImposto = new JLabel("Imposto %");
		lblImposto.setBounds(10, 172, 79, 14);
		lblImposto.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtArquiteto = new JTextField();
		txtArquiteto.setText("N\u00E3o");
		txtArquiteto.setBounds(94, 143, 114, 20);
		txtArquiteto.setColumns(10);

		txtRT = new JTextField();
		txtRT.setText("0");
		txtRT.setBounds(276, 143, 46, 20);
		txtRT.setColumns(10);

		txtImposto = new JTextField();
		txtImposto.setText("6");
		txtImposto.setBounds(94, 170, 46, 20);
		txtImposto.setColumns(10);

		JLabel lblPrazoEntrega = new JLabel("Prazo entrega");
		lblPrazoEntrega.setBounds(349, 145, 98, 14);
		lblPrazoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtEntrega = new JTextField();
		txtEntrega.setText("45");
		txtEntrega.setBounds(444, 143, 145, 20);
		txtEntrega.setColumns(10);

		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setBounds(482, 63, 63, 14);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtValidade = new JTextField();
		txtValidade.setText("10");
		txtValidade.setBounds(543, 62, 46, 18);
		txtValidade.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNovoOramento);
		contentPane.add(btnEditar);
		contentPane.add(lblMateriais);
		contentPane.add(btnRemover);
		contentPane.add(btnNewButton);
		contentPane.add(scrollPane);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 226, 311, 14);
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
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblPrazoEntrega);
		contentPane.add(txtArquiteto);
		contentPane.add(lblImposto);
		contentPane.add(txtImposto);
		contentPane.add(txtValidade);
		contentPane.add(lblValorTotal);
		contentPane.add(lblArquiteto);
		contentPane.add(txtSituacao);
		contentPane.add(txtEntrega);
		contentPane.add(lblValidade);
		contentPane.add(txtRT);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSituao.setBounds(162, 174, 63, 14);
		contentPane.add(lblSituao);

		txtValorTotal = new JTextField();
		txtValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(451, 192, 138, 23);
		contentPane.add(txtValorTotal);

		JLabel lblFormasDePagamento = new JLabel("Formas  pgto");
		lblFormasDePagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormasDePagamento.setBounds(10, 197, 145, 14);
		contentPane.add(lblFormasDePagamento);

		txtFormaPgto = new JTextField();
		txtFormaPgto.setText("\u00C0 Vista");
		txtFormaPgto.setColumns(10);
		txtFormaPgto.setBounds(94, 195, 228, 20);
		contentPane.add(txtFormaPgto);

		JLabel lblRt = new JLabel("RT");
		lblRt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRt.setBounds(245, 145, 29, 14);
		contentPane.add(lblRt);

		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		txtCodCliente.setBounds(430, 62, 35, 18);
		contentPane.add(txtCodCliente);

		JLabel lblCdigoCliente = new JLabel("C\u00F3d. Cliente");
		lblCdigoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoCliente.setBounds(347, 62, 100, 14);
		contentPane.add(lblCdigoCliente);

		lblNumOrc.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNumOrc.setBounds(276, 0, 269, 49);
		contentPane.add(lblNumOrc);

		JLabel lblNewLabel_1_1 = new JLabel("Observa\u00E7\u00F5es:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 554, 89, 14);
		contentPane.add(lblNewLabel_1_1);

		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBounds(10, 572, 580, 81);
		contentPane.add(txtObservacoes);

		JButton btnSalvar = new JButton("Salvar ");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int codigoOrcamento = Integer.parseInt(lblC.getText());
				int validade = Integer.parseInt(txtValidade.getText());
				int entrega = Integer.parseInt(txtEntrega.getText());
				double rt = Double.parseDouble(txtRT.getText());
				double imposto = Double.parseDouble(txtImposto.getText());
				double valor = Double.parseDouble(txtValorTotal.getText());
				String arquiteto = txtArquiteto.getText();
				String emissao = txtData.getText();
				String formPgto = txtFormaPgto.getText();
				String situacao = txtSituacao.getText();
				int codigoCliente = (Integer.parseInt(txtCodCliente.getText()));
				// int codigoCliente = Integer.parseInt(txtCodCliente.getText());
				OrcamentosBeans orcamento = new OrcamentosBeans(validade, entrega, rt, imposto, valor, arquiteto,
						emissao, formPgto, situacao, codigoCliente);
				OrcamentosDao orcaDao = new OrcamentosDao();
				orcaDao.salvarOrcamento(orcamento);
				dispose();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvar.setBounds(407, 231, 89, 35);
		contentPane.add(btnSalvar);
	}
}
