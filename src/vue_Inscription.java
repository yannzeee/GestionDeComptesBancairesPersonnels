import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class vue_Inscription extends JPanel {
	private JTextField nom;
	private JTextField prenom;
	private JFormattedTextField datedenaiss;
	private JTextField mail;
	private JTextField tel;
	private JPasswordField passwordField;

	
	/**
	 * Create the panel.
	 */
	public vue_Inscription(final Acceuil a1) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		
		JLabel inscription = new JLabel("INSCRIPTION");
		inscription.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inscription.setBounds(222, 11, 136, 50);
		add(inscription);
		
		JLabel lblNom = new JLabel("NOM :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNom.setBounds(10, 89, 40, 50);
		add(lblNom);
		
		nom = new JTextField();
		nom.setBounds(49, 104, 200, 20);
		add(nom);
		nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM :");
		lblPrenom.setBounds(284, 89, 66, 50);
		add(lblPrenom);
		
		prenom = new JTextField();
		prenom.setBounds(346, 104, 200, 20);
		add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DATE DE NAISSANCE :");
		lblNewLabel_1.setBounds(10, 169, 118, 50);
		add(lblNewLabel_1);
		
		datedenaiss = new JFormattedTextField("AAAA-MM-JJ"); 
		datedenaiss.setBounds(131, 184, 118, 20); 
		add(datedenaiss);
		datedenaiss.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
		        {
		          JOptionPane.showMessageDialog(null, "Entré une date valide de format JJ/MM/AAAA");
		          e.consume();
		        }
		      }
		    });
		
		JLabel lblNewLabel_2 = new JLabel("ADRESSE MAIL :");
		lblNewLabel_2.setBounds(10, 244, 118, 41);
		add(lblNewLabel_2);
		
		mail = new JTextField();
		mail.setBounds(107, 254, 146, 20);
		add(mail);
		mail.setColumns(10);
		
		JLabel lblTelephone = new JLabel("TEL :");
		lblTelephone.setBounds(284, 169, 66, 50);
		add(lblTelephone);
		
		tel = new JTextField();
		tel.setBounds(324, 184, 222, 20);
		add(tel);
		tel.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(346, 254, 200, 20);
		add(passwordField);
		
		JLabel lblMdp = new JLabel("Mdp :");
		lblMdp.setBounds(302, 239, 48, 50);
		add(lblMdp);
		
		//JOptionPane.showMessageDialog(null, "le mail est :" + mail.getText() + "le nom est" + nom.getText());
		
		JButton btnNewButton = new JButton("Valider");
		
		btnNewButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(mail.getText().isEmpty() || nom.getText().isEmpty() || prenom.getText().isEmpty() || passwordField.getText().isEmpty() || tel.getText().isEmpty() || datedenaiss.getText().isEmpty()) 
					
					JOptionPane.showMessageDialog(null, " Tous les champs doivent être remplis ! ");
				
					else {
					Modele.connexion();
					
					Modele.Inscription(nom.getText(), prenom.getText(), datedenaiss.getText(), mail.getText(), tel.getText(), passwordField.getText());
				
					JPanel vue_Login;
					vue_Login = new vue_Login(a1);
					setVisible(false);
					a1.setContentPane(vue_Login);
				}
			}
			
		});
		btnNewButton.setBounds(428, 322, 118, 29);
		add(btnNewButton);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				a1.setContentPane(a1.getContentPanel());
				revalidate();
			}
		});
		btnRetour.setBounds(10, 325, 89, 23);
		add(btnRetour);
	}
}
