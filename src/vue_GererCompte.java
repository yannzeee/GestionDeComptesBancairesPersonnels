import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;


public class vue_GererCompte extends JPanel {
	private JTextField champ_mail;
	private JPasswordField champ_mdp;
	private JTextField champ_telephone;

	/**
	 * Create the panel.
	 */
	public vue_GererCompte(final Acceuil a1, final int ID) {
		
		String info_compte[] = Modele.get_info_gestion_compte(ID);
		String mail = info_compte[0];
		String telephone = info_compte[1];
		String mdp = info_compte[2];
		String IBAN = info_compte[3];
		String numero_cb = info_compte[4];
		String bic = info_compte[5];
		String epargne = info_compte[6];
		
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		Modele.get_info_gestion_compte(ID);
		JLabel lblPse = new JLabel("PSE");
		lblPse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPse.setForeground(new Color(255, 250, 250));
		lblPse.setBounds(0, 0, 32, 25);
		add(lblPse);
		
		JLabel lblGestionDeVotre = new JLabel("Gestion de votre compte");
		lblGestionDeVotre.setFont(new Font("Agency FB", Font.PLAIN, 33));
		lblGestionDeVotre.setForeground(new Color(255, 250, 250));
		lblGestionDeVotre.setBounds(167, 11, 261, 50);
		add(lblGestionDeVotre);
		
		JLabel lblChangerDeMail = new JLabel("Changer Adresse mail :");
		lblChangerDeMail.setForeground(Color.WHITE);
		lblChangerDeMail.setBounds(23, 84, 120, 50);
		add(lblChangerDeMail);
		
		champ_mail = new JTextField();
		champ_mail.setBounds(23, 120, 157, 25);
		champ_mail.setText(mail);
		add(champ_mail);
		champ_mail.setColumns(10);
		
		JLabel lblChangerTel = new JLabel("Changer Tel :");
		lblChangerTel.setForeground(Color.WHITE);
		lblChangerTel.setBounds(23, 158, 86, 50);
		add(lblChangerTel);
		
		champ_telephone = new JTextField();
		champ_telephone.setBounds(23, 195, 157, 25);
		champ_telephone.setText(telephone);
		add(champ_telephone);
		champ_telephone.setColumns(10);
		
		JLabel lblChangerMdp = new JLabel("Changer Mdp :");
		lblChangerMdp.setForeground(Color.WHITE);
		lblChangerMdp.setBounds(23, 219, 90, 50);
		add(lblChangerMdp);
		
		champ_mdp = new JPasswordField();
		champ_mdp.setBounds(23, 260, 157, 25);
		champ_mdp.setText(mdp);
		add(champ_mdp);
		
		// JLabel IBAN
		JLabel label_IBAN = new JLabel("IBAN :");
		label_IBAN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_IBAN.setForeground(new Color(255, 250, 250));
		label_IBAN.setBounds(283, 103, 290, 50);
		label_IBAN.setText("IBAN: " + IBAN);
		add(label_IBAN);
		
		JLabel lblNcb = new JLabel("N\u00B0CB :");
		lblNcb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNcb.setForeground(new Color(255, 250, 250));
		lblNcb.setBounds(283, 154, 290, 50);
		lblNcb.setText("N\u00B0CB: + <dynamic>");
		add(lblNcb);
		
		JLabel label_BIC = new JLabel("BIC : ");
		label_BIC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_BIC.setForeground(new Color(255, 250, 250));
		label_BIC.setBounds(283, 207, 290, 25);
		label_BIC.setText("Code BIC: " + bic);
		add(label_BIC);
		
		JLabel label_epargne = new JLabel("Epargne :");
		label_epargne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_epargne.setForeground(new Color(255, 250, 250));
		label_epargne.setBounds(283, 243, 290, 50);
		if (epargne.equals("1"))
			epargne = "Oui";
		else 
			epargne = "Non";
		
		label_epargne.setText("Epargne: " + epargne);
		add(label_epargne);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(10, 335, 89, 23);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		add(btnRetour);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(474, 335, 89, 23);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modele.mettre_a_jour_info(ID, champ_mail.getText(), champ_telephone.getText(), champ_mdp.getText());
				a1.setContentPane(new vue_AcceuilConnecter(a1, ID));
				a1.revalidate();
			}
		});
		add(btnValider);

	}
}