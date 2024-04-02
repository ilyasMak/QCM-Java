package QCM_Projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QCM {
	ArrayList<Question> QCM_Java = new ArrayList<>();
	ArrayList<Question> QCM_Réseaux = new ArrayList<>();
	ArrayList<Question> QCM_GSEII = new ArrayList<>();
	ArrayList<Etudiant>Etudiants =new ArrayList<>();
	Connection con = null;
	
	Statement st = null;
	Statement st2 = null;
	ResultSet rs = null;

	ResultSet rs2 = null;

	//---------------------------------------------
	public QCM() {
	    String url = "jdbc:mysql://localhost:3306/qcm";
	    String user = "root";
	    String password = "";

	    try {
	        // Chargement du pilote JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Établissement de la connexion
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();

	        // exécution d'une requête SQL
	        rs = st.executeQuery("SELECT * FROM qcm_java");
	        // traitement des résultats
	        while (rs.next()) {
	            String question = rs.getString("Question");
	            String A = rs.getString("A");
	            String B = rs.getString("B");
	            String C = rs.getString("C");
	            String D = rs.getString("D");
	            String correction = rs.getString("correction");
	            QCM_Java.add(new Question(question, A, B, C, D, correction));
	        }
	        //----
	       
	        //----
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // fermeture des objets de connexion
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    //________________________________________________________________
	    try {
	        // Chargement du pilote JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Établissement de la connexion
	        con = DriverManager.getConnection(url, user, password);
	        st2 = con.createStatement();

	        // exécution d'une requête SQL
	        rs2 = st2.executeQuery("SELECT * FROM etudiants");
	        // traitement des résultats
	        while (rs2.next()) {
	            String NomC = rs2.getString("Nom_Complet");
	            String Niveau = rs2.getString("Niveau");
	            String Filiere = rs2.getString("Filiere");
	            String QCM_p = rs2.getString("QCM_passer");
	            int Note = rs2.getInt("Note");
	            String Décision = rs2.getString("Décision");
	            Etudiants.add(new Etudiant(NomC, Niveau, Filiere, QCM_p, Note, Décision));
	        }
	        //----+
	       
	        //----
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // fermeture des objets de connexion
	        try {
	            if (rs2 != null) {
	                rs2.close();
	            }
	            
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    //_________________________________________________________

	    try {
	        // Chargement du pilote JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Établissement de la connexion
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();

	        // exécution d'une requête SQL
	        rs = st.executeQuery("SELECT * FROM qcm_Réseaux");
	        // traitement des résultats
	        while (rs.next()) {
	            String question = rs.getString("Question");
	            String A = rs.getString("A");
	            String B = rs.getString("B");
	            String C = rs.getString("C");
	            String D = rs.getString("D");
	            String correction = rs.getString("correction");
	            QCM_Réseaux.add(new Question(question, A, B, C, D, correction));
	        }
	        //----
	       
	        //----
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // fermeture des objets de connexion
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    //_________________________________________________

	    try {
	        // Chargement du pilote JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Établissement de la connexion
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();

	        // exécution d'une requête SQL
	        rs = st.executeQuery("SELECT * FROM qcm_gseii");
	        // traitement des résultats
	        while (rs.next()) {
	            String question = rs.getString("Question");
	            String A = rs.getString("A");
	            String B = rs.getString("B");
	            String C = rs.getString("C");
	            String D = rs.getString("D");
	            String correction = rs.getString("correction");
	            QCM_GSEII.add(new Question(question, A, B, C, D, correction));
	        }
	        //----
	       
	        //----
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // fermeture des objets de connexion
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
	
	//___________________________________________________________
	
	
	//----------

	public void insererEtudiant(String nom, String niveau, String filiere, String qcmp, int note, String decision) {
	    try {
	        // Requête SQL d'insertion
	        String sql = "INSERT INTO etudiants (Nom_Complet, Niveau, Filiere, QCM_passer, Note, Décision) VALUES (?, ?, ?, ?, ?, ?)";

	        // Créer une instruction préparée pour la requête
	        PreparedStatement statement = con.prepareStatement(sql);

	        // Définir les valeurs des paramètres
	        statement.setString(1, nom);
	        statement.setString(2, niveau);
	        statement.setString(3, filiere);
	        statement.setString(4, qcmp);
	        statement.setInt(5, note);
	        statement.setString(6, decision);

	        // Exécuter la requête
	        int lignesModifiees = statement.executeUpdate();

	        if (lignesModifiees > 0) {
	            System.out.println("L'étudiant a été inséré avec succès !");
	        }

	        // Fermer la ressource
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	//--------------------------
}
