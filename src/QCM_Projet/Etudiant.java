package QCM_Projet;

public class Etudiant {
   String nom_complet ; 
   String Niveau ; 
   String Filiere ; 
   String qcm_p ;
   int Note ;
   String decision ;
public Etudiant(String nom_complet, String niveau, String filiere, String qcm_p, int note, String decision) {
	super();
	this.nom_complet = nom_complet;
	Niveau = niveau;
	Filiere = filiere;
	this.qcm_p = qcm_p;
	Note = note;
	this.decision = decision;
}
 
   
}
