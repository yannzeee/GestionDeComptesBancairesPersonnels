import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


public class Acceuil extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public Acceuil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Button s'inscrire
		JButton btnInscire = new JButton("S'inscrire");
		final Acceuil f1 = this;
		
		// Action du boutton pour passer à la page suivante
		btnInscire.addActionListener(new ActionListener() {
			// Action sur le button s'incrire 
			public void actionPerformed(ActionEvent e) { 
				JPanel vue_Inscription;
				vue_Inscription = new vue_Inscription(f1);
            
				setContentPane(vue_Inscription);
				revalidate();
			}
		});
		btnInscire.setBounds(437, 335, 126, 23);
		contentPane.add(btnInscire);
		
		// Boutton Connexion
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			//Action sur le button Connexion
			public void actionPerformed(ActionEvent e) {
				JPanel vue_Login;
				vue_Login = new vue_Login(f1);
            
				setContentPane(vue_Login);
				revalidate();
			}

		});
		btnConnexion.setBounds(10, 335, 112, 23);
		contentPane.add(btnConnexion);
		
		// JLabel "BIENVENUE CHEZ PSE"
		JLabel lblBienvenueChezPse = new JLabel("BIENVENUE CHEZ PSE");
		lblBienvenueChezPse.setForeground(new Color(255, 255, 255));
		lblBienvenueChezPse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 35));
		lblBienvenueChezPse.setBounds(139, 150, 314, 53);
		contentPane.add(lblBienvenueChezPse);
		
		// JLabel fond Acceuil
		JLabel lblfondAcceuil = new JLabel("New label");
		lblfondAcceuil.setIcon(new ImageIcon("C:\\Users\\yannzee\\Desktop\\Projet miage\\Gestion de comptes bancaires personnels\\src\\fondd.jpg"));
		lblfondAcceuil.setBounds(0, 0, 573, 369);
		contentPane.add(lblfondAcceuil);
	}

	
	
	JPanel getContentPanel() {
		return contentPane;
	}

	
	protected Container vue_Login(Acceuil f1) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	

