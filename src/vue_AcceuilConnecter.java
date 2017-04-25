import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class vue_AcceuilConnecter extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public vue_AcceuilConnecter(final Acceuil a1,final int ID) {

		
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		Modele.connexion();
		//System.out.print("connexion réussi" + ID);

		String nom_client = Modele.get_nom(ID);
		String prenom_client = Modele.get_prenom(ID);

		JLabel lblNewLabel = new JLabel("BONJOUR, " + nom_client + " " + prenom_client);
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(76, 11, 302, 44);
		add(lblNewLabel);

		JLabel lblPse = new JLabel("PSE");

		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 31, 23);

		add(lblPse);
		
		JButton btnGererCompte = new JButton("Gerer compte");
		btnGererCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel vue_GererCompte;
				vue_GererCompte = new vue_GererCompte(a1,ID);
            
				a1.setContentPane(vue_GererCompte);
				a1.revalidate();
			}
		});
		btnGererCompte.setBounds(180, 321, 222, 37);
		add(btnGererCompte);
		
		JButton btnFaireUnVirement = new JButton("Compte Epargne");
		btnFaireUnVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel vue_CompteEpargne;
				vue_CompteEpargne = new vue_CompteEpargne(a1,ID);
            
				a1.setContentPane(vue_CompteEpargne);
				a1.revalidate();
			}
		});
		btnFaireUnVirement.setBounds(63, 251, 157, 23);
		add(btnFaireUnVirement);
		
		JButton btnHistorique = new JButton("Compte Courant");
		btnHistorique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel vue_CompteCourant;
				vue_CompteCourant = new vue_CompteCourant(a1,ID);
            
				a1.setContentPane(vue_CompteCourant);
				a1.revalidate();
			}
		});
		btnHistorique.setBounds(377, 251, 127, 23);
		add(btnHistorique);
		
		JLabel lblCompteE = new JLabel("");
		lblCompteE.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\compte-epargne.jpg"));
		lblCompteE.setBounds(10, 104, 238, 136);
		add(lblCompteE);
		
		JLabel lblBorder = new JLabel("");
		lblBorder.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBorder.setBackground(Color.YELLOW);
		lblBorder.setForeground(Color.WHITE);
		lblBorder.setBounds(10, 285, 553, 14);
		add(lblBorder);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					setVisible(false);
					a1.setContentPane(a1.getContentPanel());
					JOptionPane.showMessageDialog(null, " Vous etes deconnecte merci d'avoir consulte vos comptes");
					
				}
			});
		btnDeconnexion.setBounds(438, 11, 125, 23);
		add(btnDeconnexion);
		
		JLabel lblCompteC = new JLabel("");
		lblCompteC.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\compte-courant.jpg"));
		lblCompteC.setBounds(328, 104, 222, 136);
		add(lblCompteC);
		
		JLabel lblVeuillezSlectionnerLe = new JLabel("Veuillez s\u00E9lectionner le type de compte:");
		lblVeuillezSlectionnerLe.setFont(new Font("Arial", Font.ITALIC, 12));
		lblVeuillezSlectionnerLe.setForeground(Color.WHITE);
		lblVeuillezSlectionnerLe.setBounds(180, 79, 238, 14);
		add(lblVeuillezSlectionnerLe);
		setVisible(true);

	}
}