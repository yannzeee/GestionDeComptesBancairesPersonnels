import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JTextField;


public class Modele {
	
	//Connexion
	private static Connection connexion;
	private static ResultSet rs;
	
	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//Chargement du driver
			connexion = DriverManager.getConnection("jdbc:mysql://mysql2.paris1.alwaysdata.com/testprojet2017_bank","135346_projet","azerty");//Connexion � la base de donn�es
		}
		catch (SQLException erreur) {
			System.out.println("La connexion � la base de donn�es � �chou� " + erreur);
		}
		catch (ClassNotFoundException erreur) {
			System.out.println("Le driver n'a pas �t� charg� " + erreur);
		}
	}
	
	//D�connexion
    public static void deconnexion(){
        try {
            connexion.close();
        } 
        catch (SQLException erreur) {
            System.out.println("Erreur lors de la d�connexion � la base de donn�es" + erreur);
        }
    }
    
    public static int SeConnecter(String mail, String mdp){
        
        int identifiant = 0;
         try {
                PreparedStatement statement= connexion.prepareStatement("Select id_utilisateur from Utilisateur WHERE mail = ? AND mdp = ?");
                statement.setString(1,mail);
                statement.setString(2,mdp);
            
                
                rs = statement.executeQuery(); 
                if (rs.next()){
                    identifiant = rs.getInt("id_utilisateur");
                }
                rs.close();
                
            } 
         
            catch (SQLException erreur) {
            System.out.println("La connexion � echou� " + erreur);
            }
         return identifiant;
    }
    
    public static void Inscription(String nom, String prenom, String date, String mail, String tel, String passwordfield){
        
            
            try { PreparedStatement statement = connexion.prepareStatement("INSERT INTO Utilisateur(nom, prenom, mail, telephone, mdp, date_naissance) values (?, ?, ?, ?, ?,?);");
            statement.setString(1,nom); 
            statement.setString(2,prenom); 
            statement.setString(6,date); 
            statement.setString(3,mail);
            statement.setString(4,tel);
            statement.setString(5,passwordfield);
            statement.executeUpdate();
            } catch (SQLException erreur) { 
                System.out.println("L'insertion de l'utilisateur dans la base de donn�es a �chou�e " + erreur); } 
            }
    




	public static String get_nom(int id) {
		String nom = "";
		try {
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Utilisateur WHERE id_utilisateur = ?");
			
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				nom = rs.getString("nom");
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La recuperation du nom du client a echoue " + erreur);
		}
		
		return nom;
	}
	
	public static String get_prenom(int id) {
		String prenom = "";
		try {
			PreparedStatement statement = connexion.prepareStatement("SELECT prenom FROM Utilisateur WHERE id_utilisateur = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				prenom = rs.getString("prenom");
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La r�cup�ration du prenom du client a �chou�e " + erreur);
		}
		
		return prenom;
	}

	public static String[] get_info_gestion_compte (int id) {
		String info[] = new String [7];
		int compt = 0;
		
		try {
			PreparedStatement statement = connexion.prepareStatement("SELECT mail, telephone,mdp, IBAN, numero_carte, code_bic, epargne FROM Utilisateur INNER JOIN Compte ON Utilisateur.id_compte = Compte.id_compte WHERE Utilisateur.id_utilisateur = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
	
			if(rs.next()) {
				
				info[0] = rs.getString("mail");
				info[1] = rs.getString("telephone");
				info[2] = rs.getString("mdp");
				info[3] = rs.getString("IBAN");
				info[4] = rs.getString("numero_carte");
				info[5] = rs.getString("code_bic");
				info[6] = rs.getString("epargne");		
			}
			
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La récupération des infos du client a échouée " + erreur);
		}	
		
		return info;
	}
	
	public static boolean mettre_a_jour_info (int id, String mail, String tel, String mdp) {
		boolean mis_a_jour = false;
		
		try {
			PreparedStatement statement = connexion.prepareStatement("UPDATE Utilisateur SET mail = ? , telephone = ?, mdp = ? WHERE id_utilisateur = ?");
			statement.setString(1, mail);
			statement.setString(2, tel);
			statement.setString(3, mdp);
			statement.setInt(4, id);
			statement.executeUpdate();
			
			if(rs.next()) {
				mis_a_jour = true;
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La mis à jour des infos du client a échouée " + erreur);
		}
		
		return mis_a_jour;
	}
	
	public static int getEpargne(int id){
		int i = 5;
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT epargne FROM Utilisateur INNER JOIN Compte ON Utilisateur.id_utilisateur = Compte.id_utilisateur WHERE Utilisateur.id_utilisateur = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				i = rs.getInt("epargne");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
	public static int getIdcompte(int ID){
		int i = -1;
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT id_compte from Compte WHERE Compte.id_utilisateur = ?");
			statement.setInt(1, ID);
			rs = statement.executeQuery();
			if(rs.next()) {
				i = rs.getInt("id_compte");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}

	public static String generate(int length)
	{
		    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
		    String pass = "";
		    for(int x=0;x<length;x++)
		    {
		       int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
		       pass += chars.charAt(i);
		    }
		    
		    return pass;
	}
	public static int generateint()
	{
		return (int) (0 + Math.random() * (999999999 - 0 + 1));
	}
	
	public static void InsertionCompteSimple(int iD) {
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("INSERT INTO Compte_simple (id_compte,id_compte_compte) values (?,?);");
			statement.setInt(1, iD);
			statement.setInt(2, iD);
			statement.executeUpdate();
			
			statement = connexion.prepareStatement("INSERT INTO Compte (IBAN, id_utilisateur,numero_carte, code_bic, epargne, id_compte_simple) values (?,?,?,?,?,?);");
			statement.setString(1, generate(10));
			statement.setInt(2, iD);
			statement.setString(3, generate(10));
			statement.setString(4, generate(10));
			statement.setInt(5, 0);
			statement.setInt(6, iD);
			//statement.setInt(6, generateint());
			statement.executeUpdate();

			

			//statement.setInt(6, generateint());			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("L'insertion a echoue " + e);		
			
		}
		
	}

	public static void InsertionCompteEpargneCourant(int iD) {
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("INSERT INTO Compte_Epargne (id_compte,id_compte_compte) values (?,?);");
			statement.setInt(1, iD);
			statement.setInt(2, iD);
			statement.executeUpdate();
			
			statement = connexion.prepareStatement("INSERT INTO Compte_courant (id_compte,id_compte_compte) values (?,?);");
			statement.setInt(1, iD);
			statement.setInt(2, iD);
			statement.executeUpdate();
			
			statement = connexion.prepareStatement("INSERT INTO Compte (IBAN, id_utilisateur,numero_carte, code_bic, epargne, id_compte_epargne, id_compte_courant) values (?,?,?,?,?,?,?);");
			statement.setString(1, generate(10));
			statement.setInt(2, iD);
			statement.setString(3, generate(10));
			statement.setString(4, generate(10));
			statement.setInt(5, 1);
			statement.setInt(6, iD);
			statement.setInt(7, iD);

			
			//statement.setInt(6, generateint());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("L'insertion a echoue " + e);		
			
		}
		
	}
	
	public static String getIban(int id){
		String i = "";
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT IBAN from Utilisateur WHERE Utilisateur.id_utilisateur = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				i = rs.getString("IBAN");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	public static void faireVirement(String iban, String libelle, String montant, int id) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement;
		
		try {
			statement = connexion.prepareStatement("INSERT INTO Operation (crediteur,debiteur,libelle,montant) values (?,?,?,?);");
			statement.setString(1, getIban(id));
			statement.setString(2, iban);
			statement.setString(3, libelle);
			statement.setString(4, montant);
			statement.executeUpdate();
			
			if(getEpargne(id)==0){
				statement = connexion.prepareStatement("UPDATE Compte_simple montant = ? ");
				statement.setString(1, montant);
			}else if(getEpargne(id)==1){
				statement = connexion.prepareStatement("UPDATE Compte_courant montant = ? ");
				statement.setString(1, montant);
			}
			
			
			
			statement = connexion.prepareStatement("INSERT INTO Operation (crediteur,debiteur,libelle,montant) values (?,?,?,?);");
			statement.setString(1, getIban(id));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static double get_solde_compte_courant(int id) {
		double solde = 0;
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT solde FROM Compte_courant WHERE id_compte_courant = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				solde = rs.getInt("solde");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return solde;
	}
	
	public static double get_solde_compte_simple(int id) {
		double solde = 0;
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT solde FROM Compte_simple WHERE id_compte_simple = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				solde = rs.getInt("solde");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return solde;
	}
	
	public static double get_solde_compte_epargne(int id) {
		double solde = 0;
		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("SELECT solde FROM Compte_Epargne WHERE id_compte_epargne = ?");
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				solde = rs.getInt("solde");
								
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return solde;
	}
	
}
