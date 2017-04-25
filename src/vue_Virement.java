import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class vue_Virement extends JPanel {
	private JTextField textField_IBAN;
	private JTextField textField_MONTANT;
	private JTextField textField_LIBELLE;

	/**
	 * Create the panel.
	 */
	public vue_Virement(final Acceuil a1, final int iD) {
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		
		JLabel lblPse = new JLabel("PSE");
		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 32, 25);
		add(lblPse);
		
		// JLabel gestion de virement
		JLabel lblGestion = new JLabel("Gestion du virement");
		lblGestion.setForeground(Color.WHITE);
		lblGestion.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblGestion.setBounds(201, 0, 207, 54);
		add(lblGestion);
		
		// JLabel IBAN
		JLabel lblIBAN = new JLabel("IBAN Destination :");
		lblIBAN.setFont(new Font("Arial", Font.BOLD, 12));
		lblIBAN.setBounds(83, 95, 100, 14);
		add(lblIBAN);
		
		textField_IBAN = new JTextField();
		textField_IBAN.setBounds(233, 93, 104, 20);
		add(textField_IBAN);
		textField_IBAN.setColumns(10);
		
		// JLabel Separation (Border)
		JLabel lblBorder = new JLabel("");
		lblBorder.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBorder.setBounds(48, 141, 453, 14);
		add(lblBorder);
		
		// JLabel Montant
		JLabel lblMONTANT = new JLabel("MONTANT :");
		lblMONTANT.setFont(new Font("Arial", Font.BOLD, 12));
		lblMONTANT.setBounds(83, 178, 82, 14);
		add(lblMONTANT);
		
		textField_MONTANT = new JTextField();
		textField_MONTANT.setBounds(233, 176, 104, 21);
		add(textField_MONTANT);
		textField_MONTANT.setColumns(10);
		
		JLabel lblBorder2 = new JLabel("");
		lblBorder2.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\Fond_blanc.svg"));
		lblBorder2.setBounds(48, 222, 453, 14);
		add(lblBorder2);
		
		JLabel lblLIBELLE = new JLabel("LIBELLE :");
		lblLIBELLE.setFont(new Font("Arial", Font.BOLD, 12));
		lblLIBELLE.setBounds(83, 249, 73, 14);
		add(lblLIBELLE);
		
		textField_LIBELLE = new JTextField();
		textField_LIBELLE.setBounds(233, 247, 104, 20);
		add(textField_LIBELLE);
		textField_LIBELLE.setColumns(10);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				// TODO Auto-generated method stub
				JPanel vue_AcceuilConnecter;
				JPanel vue_AcceuilConnecterCS;
				
				int affichage = Modele.getEpargne(iD);
				System.out.println(affichage);
			
				switch (affichage)
				{
				  case 0:
					  vue_AcceuilConnecterCS = new vue_AcceuilConnecterCS(a1,iD);
					  setVisible(false);
						a1.setContentPane(vue_AcceuilConnecterCS);
						revalidate();
				    break;
				  case 1:
					  vue_AcceuilConnecter = new vue_AcceuilConnecter(a1,iD);
					  setVisible(false);
						a1.setContentPane(vue_AcceuilConnecter);
						revalidate();
				    break;
				  default:
				    System.out.println("Cas IMPOSSIBLE");
				}
				
				}
				
			
		});
		btnRetour.setBounds(10, 306, 89, 23);
		add(btnRetour);
		
		JButton btnVirer = new JButton("Virer");
		btnVirer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Modele.connexion();
				Modele.faireVirement(textField_IBAN.getText(), textField_LIBELLE.getText(), textField_MONTANT.getText(), iD);
				
				//setVisible(false);
				//a1.setContentPane(vueAccu);
				//revalidate();
				
			}
		});
		btnVirer.setBounds(444, 306, 120, 23);
		add(btnVirer);

	}

	
}
