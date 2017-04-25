import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class vue_CompteInscris extends JPanel {

	/**
	 * Create the panel.
	 */
	public vue_CompteInscris(final Acceuil a1,final int ID) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		Modele.connexion();
		System.out.print("connexion réussi" + ID);
		String nom_client = Modele.get_nom(ID);
		String prenom_client = Modele.get_prenom(ID);
		JLabel lblNewLabel = new JLabel("BONJOUR, " + nom_client + " " + prenom_client);
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(78, 11, 302, 44);
		add(lblNewLabel);
		
		JLabel lblPse = new JLabel("PSE");
		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 32, 25);
		add(lblPse);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					setVisible(false);
					a1.setContentPane(a1.getContentPanel());
					JOptionPane.showMessageDialog(null, " Vous etes deconnecte merci d'avoir consulte vos comptes");
					
				}
			});
		btnDeconnexion.setBounds(433, 11, 104, 23);
		add(btnDeconnexion);
		
		JButton btnCompteS = new JButton("OUVRIR UN COMPTE SIMPLE");
		btnCompteS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel vue_AcceuilConnecter;
				Modele.connexion();
				Modele.InsertionCompteSimple(ID);
				vue_AcceuilConnecter = new vue_AcceuilConnecterCS(a1,ID);
				setVisible(false);
				a1.setContentPane(vue_AcceuilConnecter);
				revalidate();
			}
			
		});
		btnCompteS.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCompteS.setForeground(new Color(0, 0, 0));
		btnCompteS.setBounds(102, 118, 338, 44);
		add(btnCompteS);
		
		JButton btnCompteCE = new JButton("OUVRIR UN COMPTE COURANT ET UN COMPTE EPARGNE");
		btnCompteCE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel vue_AcceuilConnecter1;
				Modele.connexion();
				Modele.InsertionCompteEpargneCourant(ID);
				vue_AcceuilConnecter1 = new vue_AcceuilConnecter(a1,ID);
				//System.out.println("CAS SIMPLE");
				setVisible(false);
				a1.setContentPane(vue_AcceuilConnecter1);
				revalidate();
			}
			
		});
		btnCompteCE.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCompteCE.setBounds(102, 221, 338, 50);
		add(btnCompteCE);
		
		JLabel lblBorder = new JLabel("New label");
		lblBorder.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBorder.setBounds(102, 183, 338, 15);
		add(lblBorder);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				a1.setContentPane(a1.getContentPanel());
				revalidate();
			}
		});
		btnRetour.setBounds(10, 309, 89, 23);
		add(btnRetour);
		
		JLabel lblQuestion = new JLabel("Que souhaitez-vous faire :");
		lblQuestion.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setBounds(10, 81, 179, 14);
		add(lblQuestion);
	}

}