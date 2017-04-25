import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class vue_CreerCompte extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JButton btnNewButton ;

	public vue_CreerCompte() {
		
		//setBounds(100, 100, 479, 414);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 98, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(346, 98, 89, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 164, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(346, 164, 89, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(364, 341, 89, 23);
//		btnNewButton.addActionListener((ActionListener) this);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setBounds(10, 341, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(Color.WHITE);
		lblNom.setBounds(10, 101, 70, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setBounds(271, 101, 46, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setBounds(10, 167, 89, 14);
		contentPane.add(lblDateDeNaissance);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setBounds(260, 167, 57, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblCreationDeCompte = new JLabel("CREATION DE COMPTE PSE");
		lblCreationDeCompte.setForeground(Color.WHITE);
		lblCreationDeCompte.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblCreationDeCompte.setBounds(123, 11, 244, 47);
		contentPane.add(lblCreationDeCompte);
		
		JLabel lblMdp = new JLabel("Mdp");
		lblMdp.setForeground(Color.WHITE);
		lblMdp.setBounds(10, 227, 70, 14);
		contentPane.add(lblMdp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 224, 86, 20);
		contentPane.add(passwordField);
	}

	/**
	 * @return the btnNewButton
	 */
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	
	
}
