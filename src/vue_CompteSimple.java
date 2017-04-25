import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class vue_CompteSimple extends JPanel {

	/**
	 * Create the panel.
	 */
	public vue_CompteSimple(final Acceuil a1,final int ID) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		Modele.connexion();
		//System.out.print("connexion réussi" + ID);
		String nom_client = Modele.get_nom(ID);
		String prenom_client = Modele.get_prenom(ID);
		
		JLabel lblPse = new JLabel("PSE");
		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 32, 25);
		add(lblPse);
		JLabel lblNewLabel = new JLabel("BONJOUR, " + nom_client + " " + prenom_client);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(59, 11, 302, 44);
		add(lblNewLabel);
		
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
		
		JLabel lblVoulezvousEffectuerUn = new JLabel("Voulez-vous effectuer un virement :");
		lblVoulezvousEffectuerUn.setFont(new Font("Arial", Font.ITALIC, 13));
		lblVoulezvousEffectuerUn.setForeground(Color.WHITE);
		lblVoulezvousEffectuerUn.setBounds(28, 94, 333, 14);
		add(lblVoulezvousEffectuerUn);
		
		JButton btnVirement = new JButton("VIREMENT");
		btnVirement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel vue_Virement;
				vue_Virement = new vue_Virement(a1,ID);
				setVisible(false);
				a1.setContentPane(vue_Virement);
				revalidate();
				
			}
		});
		btnVirement.setFont(new Font("Agency FB", Font.PLAIN, 25));
		btnVirement.setBounds(120, 129, 333, 36);
		add(btnVirement);
		
		JLabel lblBorder = new JLabel("New label");
		lblBorder.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBorder.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBorder.setBounds(120, 188, 333, 14);
		add(lblBorder);
		
		double solde = Modele.get_solde_compte_simple(ID);
		JLabel lblSolde = new JLabel("SOLDE : " + solde);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolde.setBounds(159, 220, 294, 36);
		add(lblSolde);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel vue_AcceuilConnecter;
				JPanel vue_AcceuilConnecterCS;
				
				int affichage = Modele.getEpargne(ID);
				System.out.println(affichage);
			
				switch (affichage)
				{
				  case 0:
					  vue_AcceuilConnecterCS = new vue_AcceuilConnecterCS(a1,ID);
					  setVisible(false);
						a1.setContentPane(vue_AcceuilConnecterCS);
						revalidate();
				    break;
				  case 1:
					  vue_AcceuilConnecter = new vue_AcceuilConnecter(a1,ID);
					  setVisible(false);
						a1.setContentPane(vue_AcceuilConnecter);
						revalidate();
				    break;
				  default:
				    System.out.println("Cas IMPOSSIBLE");
				}
				
				}
				
			
		});
				
		
		btnRetour.setBounds(10, 298, 89, 23);
		add(btnRetour);

}
}