import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class vue_AcceuilConnecterCS extends JPanel {

	/**
	 * Create the panel.
	 */
	public vue_AcceuilConnecterCS(final Acceuil a1,final int ID) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		Modele.connexion();
		System.out.print("connexion réussi" + ID);
		String nom_client = Modele.get_nom(ID);
		String prenom_client = Modele.get_prenom(ID);
		JLabel lblNewLabel = new JLabel("BONJOUR, " + nom_client + " " + prenom_client);
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(94, 11, 302, 44);
		add(lblNewLabel);
		
		JLabel lblPse = new JLabel("PSE");
		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 32, 25);
		add(lblPse);
		
		JLabel lblphoto = new JLabel("New label");
		lblphoto.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\CS.jpg"));
		lblphoto.setBounds(146, 90, 272, 143);
		add(lblphoto);
		
		JButton btnCompteSimple = new JButton("COMPTE SIMPLE");
		btnCompteSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel vue_CompteSimple;
				vue_CompteSimple = new vue_CompteCourant(a1,ID);
            
				a1.setContentPane(vue_CompteSimple);
				a1.revalidate();
			}
		});
		btnCompteSimple.setBounds(156, 244, 205, 23);
		add(btnCompteSimple);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		
		// Action sur le button
		btnDeconnexion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			setVisible(false);
			a1.setContentPane(a1.getContentPanel());
			JOptionPane.showMessageDialog(null, " Vous etes deconnecte merci d'avoir consulte vos comptes");
			
		}
		});
		btnDeconnexion.setBounds(449, 11, 113, 23);
		add(btnDeconnexion);
		
		// Button Gerer
		JButton btnGerer = new JButton("Gerer Compte");
		btnGerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel vue_GererCompte;
				vue_GererCompte = new vue_GererCompte(a1,ID);
            
				a1.setContentPane(vue_GererCompte);
				a1.revalidate();
			}
		});
		btnGerer.setBounds(211, 323, 150, 34);
		add(btnGerer);
		// Button "X"
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, " Votre compte ne peux pas être clos pour le moment veuillez nous escusez.");
			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnX.setForeground(Color.RED);
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(371, 244, 54, 25);
		add(btnX);
		
		JLabel lblBordure = new JLabel("New label");
		lblBordure.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBordure.setBounds(10, 289, 552, 14);
		add(lblBordure);
	}

}