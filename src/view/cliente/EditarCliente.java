package view.cliente;

import static view.cliente.Clientes.tabelaClientes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClientesControl;
import model.ClientesBeans;
import model.ClientesDao;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class EditarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtEmailCliente;
	private JTextField txtEndCliente;
	private JTextField txtFoneCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					EditarCliente frame = new EditarCliente();
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
	private ClientesDao dao = new ClientesDao();
	JLabel lblcodDao = new JLabel();
	public EditarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ArrayList<ClientesBeans> aux = dao.selecionarCliente(Clientes.codigoSelecionado);
				lblcodDao.setText(String.valueOf(aux.get(0).getCodigoCliente()));
				txtNomeCliente.setText(aux.get(0).getNomeCliente());
				txtFoneCliente.setText(aux.get(0).getFoneCliente());
				txtEmailCliente.setText(aux.get(0).getEmailCliente());
				txtEndCliente.setText(aux.get(0).getEndCliente());
			}
		});

		/** _________________Configurações do frame_____________________ **/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 256);

		/** __________________Elementos do frame_______________________ **/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroCliente = new JLabel("Atualizar Cliente");
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCadastroCliente.setBounds(10, 11, 227, 46);
		contentPane.add(lblCadastroCliente);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(61, 84, 269, 20);
		contentPane.add(txtNomeCliente);

		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(61, 140, 269, 20);
		contentPane.add(txtEmailCliente);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 143, 48, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 85, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtEndCliente = new JTextField();
		txtEndCliente.setColumns(10);
		txtEndCliente.setBounds(61, 112, 269, 20);
		contentPane.add(txtEndCliente);

		JLabel lblNewLabel_2 = new JLabel("End.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 115, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFone.setBounds(10, 171, 53, 14);
		contentPane.add(lblFone);

		txtFoneCliente = new JTextField();
		txtFoneCliente.setColumns(10);
		txtFoneCliente.setBounds(61, 168, 269, 20);
		contentPane.add(txtFoneCliente);

		/** _________________Botões e suas funções_____________________ **/

		JButton btnSalvar = new JButton("Atualizar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvar.addActionListener(new ActionListener() {
			private Object frame;

			public void actionPerformed(ActionEvent e) {
				ClientesBeans cliente = new ClientesBeans();
				cliente.setNomeCliente(txtNomeCliente.getText());
				cliente.setFoneCliente(txtFoneCliente.getText());
				cliente.setEmailCliente(txtEmailCliente.getText());
				cliente.setEndCliente(txtEndCliente.getText());
				cliente.setCodigoCliente(Clientes.codigoSelecionado);
				if (txtNomeCliente.getText().equals("")) {
					JOptionPane.showOptionDialog(null, "Informe o nome do cliente!", "Atenção!", -1, 2, null, null,
							null);
				} else if ((txtFoneCliente.getText().equals("")) && (txtEmailCliente.getText().equals(""))) {
					JOptionPane.showOptionDialog(null, "Informe o telefone ou o email do cliente!", "Atenção!", -1, 2,
							null, null, null);
				} else {
					dao.updateCliente(cliente);
					Clientes.codigoSelecionado = 0;
					tabelaClientes.setModel(Clientes.control.listarClientes());
					dispose();
				}
			}
		});
		btnSalvar.setBounds(360, 103, 128, 38);
		contentPane.add(btnSalvar);
		JComboBox comboBox = new JComboBox();
		comboBox.setVisible(true);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Cliente" }));
		comboBox.setBounds(61, 54, 269, 22);
		contentPane.add(comboBox);
		
		
		lblcodDao.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblcodDao.setBounds(208, 11, 227, 46);
		contentPane.add(lblcodDao);

	}
}

