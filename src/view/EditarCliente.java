package view;

import static view.Clientes.tabelaClientes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Beans;
import model.DAO;

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
	private DAO dao = new DAO();
	private Controller control = new Controller();
	private Clientes cliente = new Clientes();
	private JTextField txtCodigo;
	public EditarCliente() {
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowOpened(WindowEvent e) {
				int linha = tabelaClientes.getSelectedRow();//
				int codigo = (int)tabelaClientes.getValueAt(linha, 0);
				ArrayList<Beans> cliente = dao.selecionarCliente(codigo);
				txtNomeCliente.setText(cliente.get(0).getNomeCliente());
				txtFoneCliente.setText(cliente.get(0).getFoneCliente());
				txtEmailCliente.setText(cliente.get(0).getEmailCliente());
				txtEndCliente.setText(cliente.get(0).getEndCliente());
				txtCodigo.setText(String.valueOf(cliente.get(0).getCodigoCliente()));
				
				
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
		txtNomeCliente.setBounds(61, 87, 186, 20);
		contentPane.add(txtNomeCliente);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(61, 140, 269, 20);
		contentPane.add(txtEmailCliente);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(10, 143, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEndCliente = new JTextField();
		txtEndCliente.setColumns(10);
		txtEndCliente.setBounds(61, 112, 439, 20);
		contentPane.add(txtEndCliente);
		
		JLabel lblNewLabel_2 = new JLabel("End.");
		lblNewLabel_2.setBounds(10, 115, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setBounds(277, 90, 53, 14);
		contentPane.add(lblFone);
		
		txtFoneCliente = new JTextField();
		txtFoneCliente.setColumns(10);
		txtFoneCliente.setBounds(309, 87, 191, 20);
		contentPane.add(txtFoneCliente);
		
		
		/** _________________Botões e suas funções_____________________ **/

		JButton btnSalvar = new JButton("Atualizar");
		btnSalvar.addActionListener(new ActionListener() {
			private Object frame;

			public void actionPerformed(ActionEvent e) {
				String nome = txtNomeCliente.getText();
				String fone = txtFoneCliente.getText();
				String email = txtEmailCliente.getText();
				String endereco =txtEndCliente.getText();
				Beans cliente = new Beans(nome, fone, email, endereco);
				if(txtNomeCliente.getText().equals("")) {
					JOptionPane.showOptionDialog(null, "Informe o nome do cliente!", "Atenção!",
							-1, 2, null,null, null);
				}else if( (txtFoneCliente.getText().equals("")) && (txtEmailCliente.getText().equals("")) ) {
					JOptionPane.showOptionDialog(null, "Informe o telefone ou o email do cliente!", "Atenção!",
							-1, 2, null,null, null);
				}else {
					dao.cadastrarCliente(cliente);
					txtNomeCliente.setText("");
					txtFoneCliente.setText("");
					txtEmailCliente.setText("");
					txtEndCliente.setText("");					
				}
			}
		});
		btnSalvar.setBounds(372, 183, 128, 23);
		contentPane.add(btnSalvar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(414, 140, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(366, 143, 53, 14);
		contentPane.add(lblCdigo);
		
		
	}

}
