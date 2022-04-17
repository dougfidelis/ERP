package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Orcamentos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		/** _________________Configurações do frame_____________________ **/
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\toni\\Desktop\\Programa\u00E7\u00E3o\\Eclipse\\ERP\\Imagens\\brasil.png"));
		setTitle("ERP - Orçamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/** __________________Elementos do frame_______________________ **/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/** _________________Botões e suas funções_____________________ **/

	}

}
