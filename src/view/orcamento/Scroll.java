package view.orcamento;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class Scroll extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scroll frame = new Scroll();
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
	public Scroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Detalhes");
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.windowBorder));
		layeredPane_1.setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(163, 170, 89, 23);
		layeredPane_1.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(262, 170, 89, 23);
		layeredPane_1.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(361, 170, 89, 23);
		layeredPane_1.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAtributosDoItem_1_1 = new JButton("Custos do Item");
		btnAtributosDoItem_1_1.setForeground(SystemColor.windowBorder);
		btnAtributosDoItem_1_1.setBorder(null);
		btnAtributosDoItem_1_1.setBackground(SystemColor.menu);
		
		JLayeredPane layeredPane_1_1 = new JLayeredPane();
		layeredPane_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.windowBorder));
		layeredPane_1_1.setBackground(Color.GRAY);
		
		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.setBounds(163, 170, 89, 23);
		layeredPane_1_1.add(btnNewButton_2);
		
		JButton btnRemover_2 = new JButton("Remover");
		btnRemover_2.setBounds(262, 170, 89, 23);
		layeredPane_1_1.add(btnRemover_2);
		
		JButton btnEditar_2 = new JButton("Editar");
		btnEditar_2.setBounds(361, 170, 89, 23);
		layeredPane_1_1.add(btnEditar_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(502)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(75)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(512)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(336)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(scrollPane_1_1, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
						.addComponent(layeredPane_1_1, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(btnAtributosDoItem_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(76)
							.addComponent(lblNewLabel_1_1_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1)
							.addGap(7)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane_1_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(layeredPane_1_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAtributosDoItem_1_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}

}
