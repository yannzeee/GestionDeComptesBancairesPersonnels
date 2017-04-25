import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class vue_Login extends JPanel {
	
	private JTextField textField_login;
	private JPasswordField passwordField_Mdp;

	//private Acceuil a1;
	/**
	 * Create the panel.
	 */
	public vue_Login(final Acceuil a1) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		
		textField_login = new JTextField();
		textField_login.setBounds(219, 188, 149, 20);
		add(textField_login);
		textField_login.setColumns(10);
		
		JLabel login = new JLabel("Login :");
		login.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 18));
		login.setForeground(new Color(255, 255, 255));
		login.setBounds(176, 177, 61, 36);
		add(login);
		
		JLabel mdp = new JLabel("Mdp :");
		mdp.setForeground(new Color(255, 255, 255));
		mdp.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 18));
		mdp.setBackground(new Color(255, 0, 0));
		mdp.setBounds(176, 219, 61, 36);
		add(mdp);
		
		passwordField_Mdp = new JPasswordField();
		passwordField_Mdp.setBounds(219, 230, 149, 20);
		add(passwordField_Mdp);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				Modele.connexion();
				
				if(textField_login.getText()!="" && passwordField_Mdp.getText()!=""){
					
					int i= Modele.SeConnecter(textField_login.getText(), passwordField_Mdp.getText());
					JPanel vue_AcceuilConnecter;JPanel vue_AcceuilConnecterCS;
					
					if(Modele.SeConnecter(textField_login.getText(), passwordField_Mdp.getText()) != 0){
					
						if(Modele.getIdcompte(i) != 0){
							
							int affichage = Modele.getEpargne(i);
							System.out.println(affichage);
						
							switch (affichage)
							{
							  case 0:
								  vue_AcceuilConnecterCS = new vue_AcceuilConnecterCS(a1,i);
								  setVisible(false);
									a1.setContentPane(vue_AcceuilConnecterCS);
									revalidate();
							    break;
							  case 1:
								  vue_AcceuilConnecter = new vue_AcceuilConnecter(a1,i);
								  setVisible(false);
									a1.setContentPane(vue_AcceuilConnecter);
									revalidate();
							    break;
							  default:
								  vue_AcceuilConnecter = new vue_CompteInscris(a1,i);
								  setVisible(false);
									a1.setContentPane(vue_AcceuilConnecter);
									revalidate();
							}
							
							}else if(Modele.getIdcompte(i) == -1) JOptionPane.showMessageDialog(null, " CAS IMPOSSIBLE ");
							 else {
								vue_AcceuilConnecter = new vue_CompteInscris(a1,i);
								  setVisible(false);
									a1.setContentPane(vue_AcceuilConnecter);
									revalidate();
							
							}	
						
					}else JOptionPane.showMessageDialog(null, " Les identifiants entr�s sont faux, veuillez recommencer");
					
				}else JOptionPane.showMessageDialog(null, " Le login ou le mot de passe n'a pas �t� entr�");

			}
			
		});
		btnSeConnecter.setBounds(440, 335, 123, 23);
		add(btnSeConnecter);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				a1.setContentPane(a1.getContentPanel());
				revalidate();
			}
		});
		btnRetour.setBounds(10, 335, 123, 23);
		add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\log.png"));
		lblNewLabel.setBounds(243, 95, 86, 72);
		add(lblNewLabel);
		
		JLabel lblPse = new JLabel("PSE");
		lblPse.setForeground(Color.WHITE);
		lblPse.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 18));
		lblPse.setBounds(10, 11, 74, 14);
		add(lblPse);

	}
	

}