package QCM_Projet;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

public class Interface_QCM extends JFrame {
   QCM qcm=new QCM() ; 
   Question[] question_qcm=new Question[20];
   Timer t;
   String nom_etud;
   String nv_etud;
   String fil_etud;
   Timer application_commence ;
   int maxHeight=350 ; 
   int fontSize=30;
   long TempsPrec = System.currentTimeMillis();
   int k=50 ;
   double V= 0.6; 
   double v=V*100;
   boolean sizeP=false ;
   boolean vides =true ; 
   int y_tQST=70;
   int x_tQST=750 ;
   int x_tQSM=0 ; 
   int Note=0 ; 
   int largeur =1200;
   int longeur=800 ; 
   int temps_qcm=-1 ; 
   int temps_qst=21 ; 
   int TEMPS=10; 
   int NUM_QST=20;
   int vitesse=1000 ;
   int num_qst =0 ; 
   int H=50;
   int Notation=0 ; 
   String reponses[]=new String[NUM_QST] ;
   String PASSWORD= "ab1" ;
   JPanel esp_etud;
   JPanel esp_prof ;
   JPanel mainPanel; 
   JPanel infos ; 
   JPanel etudiant ; 
   JPanel prof ; 
   JPanel questions ; 
   JPanel options ; 
   JPanel bas ; 
   JPanel fin_QCM ; 
   JPanel commence ; 
   JScrollPane listeEtud ; 
   JLabel nom_ =new JLabel();
   JLabel Niveau =new JLabel();
   JLabel filiere=new JLabel();
   JLabel titre=new JLabel("OCA OCP Java SE 8 Programmer Practice Tests");
   JLabel t_qcm=new JLabel("Temps de QCM : 0s"); 
   JLabel t_qst=new JLabel("Temps de Question : 20s");
   JLabel N_qst=new JLabel("Question : 1");
   JTextArea qst = new JTextArea("QCM commence dans quelque secondes");
   JLabel n=new JLabel();
   JLabel decision=new JLabel("Decision : RATTRAPAGE ("+v+"%)");
	 JRadioButton opt[]=new JRadioButton[] {new JRadioButton("A"),new JRadioButton("B"),new JRadioButton("C"),new JRadioButton("D")	};
	 ImageIcon commenceIm=new ImageIcon("Images/pg1QCM.png");
	 
	 
	 ImageIcon smile = new ImageIcon("Images/not smiling score.png"); // chemin relatif ou absolu vers l'image
	 ImageIcon etudiantIcone=new ImageIcon("Images/etudiant icon.png");
	 ImageIcon profIcone=new ImageIcon("Images/prof icon.png");
	 JLabel etudiantLabel=new JLabel(etudiantIcone);
	 JLabel profLabel=new JLabel(profIcone);
	 JLabel profLabel2=new JLabel(profIcone);
	 JLabel smileLabel = new JLabel(smile);
	 JLabel commenceLabel ; 
	 JButton listEtud ; 
	 JButton skip=new JButton("Ignorer ▶");
	 JButton Accueil =new JButton("Revenir à l'Accueil");
	 JButton commencerTous=new JButton("Commencer") ; 
	 JButton QuitterTous=new JButton("Quitter") ; 
	 
   //----------------------------------
   public Interface_QCM(){
   this.setTitle("ILYAS -QCM");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setSize(largeur, longeur);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	setBackground(Color.BLACK);
	//-----------------------------
	 for(int i=0;i<NUM_QST;i++) {
		   reponses[i]="";
	   }
	//-----------------------------
    mainPanel = new JPanel() {
    	 @Override
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);
    	        Graphics2D g2d = (Graphics2D) g;
    	        GradientPaint gradient = new GradientPaint(20, 0,new Color(20, 13, 17) , 0, getHeight(),new Color(62, 91, 102) );
    	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	        g2d.setPaint(gradient);
    	        g2d.fillRect(0, 0, getWidth(), getHeight());
    	    }
    };
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
    
    commence =new JPanel();
    commence.setLayout(null); 
    JLabel commenceL=new JLabel(commenceIm);
    commenceL.setBounds(0, 0, getWidth(), getHeight());
    //--
    commenceLabel = new JLabel("Bienvenue Chers Professeurs et Etudiants");
    commenceLabel.setFont(new Font("Arial", Font.ITALIC, 25));
    commenceLabel.setBounds(220, 200, 600, 30);
    //--
    commencerTous.setBackground( new Color(20, 13, 17));
    commencerTous.setForeground(Color.WHITE);
    commencerTous.setFont(new Font("Arial", Font.BOLD, 15));
    commencerTous.setBounds((getWidth() - 300) / 2, (getHeight() - 200) / 2, 300, 30);
   //--
    
    QuitterTous.setBackground(new Color(62, 91, 102) );
    QuitterTous.setForeground(Color.black);
    QuitterTous.setFont(new Font("Arial", Font.BOLD, 15));
    QuitterTous.setBounds((getWidth() - 300) / 2, (getHeight() ) / 2, 300, 30);
    QuitterTous.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//addMouseListener(new EcouteurClicSouris());
			EcouteurClicSouris ee= new EcouteurClicSouris();
			ee.jouerSon("Images/c.wav");
			dispose();
		}
	});
    //--
    commence.add(commenceLabel);
    commence.add(commencerTous);
    commence.add(QuitterTous);
    commence.add(commenceL);
    mainPanel.add(commence);
    //----------------------------
    esp_etud=new JPanel();
    TitledBorder etud_tit=BorderFactory.createTitledBorder("Espace Etudiant(e)");
    etud_tit.setTitleColor(Color.WHITE);
    esp_etud.setBorder(etud_tit);
    JLabel etud_titre=new JLabel("veuillez saisir vos informations ");
    etud_titre.setFont(new Font("Arial", Font.ITALIC, 30));
    etud_titre.setForeground(Color.white);
    etud_titre.setHorizontalAlignment(JTextField.CENTER);
    esp_etud.add(etudiantLabel);
    esp_etud.add(etud_titre);
    esp_etud.add(Box.createHorizontalStrut(600)); 
    //-----------
    JTextField nom=new JTextField(20);
    nom.setPreferredSize(new Dimension(200, 30));
	   nom.setFont(new Font("Arial", Font.ITALIC, 24));
	   nom.setForeground(Color.white);
	   nom.setBackground(Color.black);
	   nom.setHorizontalAlignment(JTextField.CENTER);
	   JLabel nom_titre= new JLabel("Nom complet ");
	   nom_titre.setFont(new Font("Arial", Font.BOLD, 30));
	    nom_titre.setForeground(Color.white);
	   esp_etud.add(nom_titre);
	   
    esp_etud.add(nom);
    esp_etud.add(Box.createHorizontalStrut(1300)); 
    //------------
    JTextField nv=new JTextField(20);
    nv.setPreferredSize(new Dimension(200, 30));
	   nv.setFont(new Font("Arial", Font.ITALIC, 24));
	   nv.setForeground(Color.white);
	   nv.setBackground(Color.black);
	  nv.setHorizontalAlignment(JTextField.CENTER);
	  JLabel nv_titre= new JLabel("Niveau ");
	   nv_titre.setFont(new Font("Arial", Font.BOLD, 30));
	    nv_titre.setForeground(Color.white);
	   esp_etud.add(nv_titre);
    esp_etud.add(nv);
    esp_etud.add(Box.createHorizontalStrut(1300)); 
    //-------------
    JRadioButton fil1=new JRadioButton("G-INFO");
    fil1.setOpaque(false);
    fil1.setForeground(Color.WHITE);
    JRadioButton fil2=new JRadioButton("GTR");
    fil2.setOpaque(false);
    fil2.setForeground(Color.WHITE);
    JRadioButton fil3=new JRadioButton("G-SEII");
    fil3.setOpaque(false);
    fil3.setForeground(Color.WHITE);
    //------
    ButtonGroup fils = new ButtonGroup();
    fils.add(fil1);
    fils.add(fil2);
    fils.add(fil3);
    /*JTextField fil=new JTextField(20);
    fil.setPreferredSize(new Dimension(200, 30));
	   fil.setFont(new Font("Arial", Font.ITALIC, 24));
	   fil.setForeground(Color.white);
	   fil.setBackground(Color.black);
	  fil.setHorizontalAlignment(JTextField.CENTER);*/
	 
	  JLabel fil_titre= new JLabel("Filiére ");
	   fil_titre.setFont(new Font("Arial", Font.BOLD, 30));
	    fil_titre.setForeground(Color.white);
	   esp_etud.add(fil_titre);
    esp_etud.add(fil1);
    esp_etud.add(fil2);
    esp_etud.add(fil3);
    esp_etud.add(Box.createHorizontalStrut(2600)); 
    //-------------
    JLabel remarque= new JLabel("L'examen apparaîtra immédiatement après la saisie des informations requises.");
	   remarque.setFont(new Font("Arial", Font.ROMAN_BASELINE, 30));
	    remarque.setForeground(Color.white);
	   esp_etud.add(remarque);
	   //----
	   JLabel remarque2= new JLabel("Soyez prêt !");
	   remarque2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 30));
	    remarque2.setForeground(Color.white);
	   esp_etud.add(remarque2);
    //------------
    esp_etud.setOpaque(false);
    esp_etud.setVisible(false);
   mainPanel.add(esp_etud);
    
    
    
    
    //------------------------------------------------
    esp_prof=new JPanel();
    
    TitledBorder prof_tit=BorderFactory.createTitledBorder("Espace Professeur(e)");
    prof_tit.setTitleColor(Color.WHITE);
    
    esp_prof.setBorder(prof_tit);
    esp_prof.add(profLabel);
    
    
  //----
	
    //----
    JLabel prf_titre=new JLabel("veuillez saisir les paramétres de QCM ");
    prf_titre.setFont(new Font("Arial", Font.ITALIC, 30));
    prf_titre.setForeground(Color.white);
    esp_prof.add(prf_titre);
    esp_prof.add(Box.createHorizontalStrut(600)); 
    
    JLabel mot_pass= new JLabel("Mot de passe ");
	   mot_pass.setFont(new Font("Arial", Font.BOLD, 30));
	   mot_pass.setForeground(Color.white);
	    esp_prof.add(mot_pass); 
	   //----
	    JPasswordField password = new JPasswordField(20);
	    password.setEchoChar('\u2022'); 
	    password.setPreferredSize(new Dimension(400, 30));
	    password.setFont(new Font("Arial", Font.ITALIC, 24));
	    password.setBackground(Color.black);
	    password.setForeground(Color.WHITE);
	    password.setHorizontalAlignment(JTextField.CENTER);
		   esp_prof.add(password);
		   esp_prof.add(Box.createHorizontalStrut(1300)); 
 //--- 
	//----
	   JLabel QCM_titre= new JLabel("Titre de QCM  ");
	   QCM_titre.setFont(new Font("Arial", Font.BOLD, 30));
	    QCM_titre.setForeground(Color.white);
	    esp_prof.add(QCM_titre); 
	   //----
	    JTextField titreQSM=new JTextField();
	    titreQSM.setEnabled(false);
	    titreQSM.setPreferredSize(new Dimension(400, 30));
		   titreQSM.setFont(new Font("Arial", Font.ITALIC, 24));
		   titreQSM.setBackground(Color.black);
		   titreQSM.setForeground(Color.WHITE);
		   titreQSM.setHorizontalAlignment(JTextField.CENTER);
		   esp_prof.add(titreQSM);
		   esp_prof.add(Box.createHorizontalStrut(1300)); 
       //---
		   JLabel nbr_qst= new JLabel("Nombre des Questions ");
		   nbr_qst.setFont(new Font("Arial", Font.BOLD, 30));
		    nbr_qst.setForeground(Color.white);
		    esp_prof.add(nbr_qst); 
    //---
		    JTextField nb_qsts=new JTextField();
		    nb_qsts.setEnabled(false);
		    nb_qsts.setPreferredSize(new Dimension(400, 30));
		    nb_qsts.setFont(new Font("Arial", Font.ITALIC, 24));
		    nb_qsts.setBackground(Color.black);
		    nb_qsts.setForeground(Color.WHITE);
		    nb_qsts.setHorizontalAlignment(JTextField.CENTER);
			   esp_prof.add(nb_qsts);
			   esp_prof.add(Box.createHorizontalStrut(1300));
   //---
			   JLabel tps_qst= new JLabel("Temps de Question ");
			   tps_qst.setFont(new Font("Arial", Font.BOLD, 30));
			   tps_qst.setForeground(Color.white);
			    esp_prof.add(tps_qst);
	//--	
			  /*  JTextField tps_qsts=new JTextField();
			    tps_qsts.setPreferredSize(new Dimension(400, 30));
			    tps_qsts.setFont(new Font("Arial", Font.ITALIC, 24));
			    tps_qsts.setBackground(Color.black);
			    tps_qsts.setForeground(Color.WHITE);
			    tps_qsts.setHorizontalAlignment(JTextField.CENTER);
				   esp_prof.add(tps_qsts);
				   esp_prof.add(Box.createHorizontalStrut(1300));*/
			    ButtonGroup tmps=new ButtonGroup();
			    JRadioButton temp5=new JRadioButton("5s");
			    temp5.setOpaque(false);
			    temp5.setEnabled(false);
			    tmps.add(temp5);
			    temp5.setForeground(Color.WHITE);
			    //--
			    JRadioButton temp10=new JRadioButton("10s");
			    temp10.setOpaque(false);
			    temp10.setEnabled(false);
			    tmps.add(temp10);
			    temp10.setForeground(Color.WHITE);
			    //--
			    JRadioButton temp20=new JRadioButton("20s");
			    temp20.setOpaque(false);
			    temp20.setEnabled(false);
			    tmps.add(temp20);
			    temp20.setForeground(Color.WHITE);
			    //--
			    JRadioButton temp30=new JRadioButton("30s");
			    temp30.setOpaque(false);
			    temp30.setEnabled(false);
			    tmps.add(temp30);
			    tmps.add(temp30);
			    temp30.setForeground(Color.WHITE);
			    //--
			    JRadioButton temp1min=new JRadioButton("1Min");
			    temp1min.setOpaque(false);
			    temp1min.setEnabled(false);
			    tmps.add(temp1min);
			    temp1min.setForeground(Color.WHITE);
			    
			    esp_prof.add(temp5);
			    esp_prof.add(temp10);
			    esp_prof.add(temp20);
			    esp_prof.add(temp30);
			    esp_prof.add(temp1min);
			    esp_prof.add(Box.createHorizontalStrut(1300));
			    //---
			    JLabel sys_note= new JLabel("Le système de notation  ");
			    sys_note.setFont(new Font("Arial", Font.BOLD, 30));
			    sys_note.setForeground(Color.white);
				    esp_prof.add(sys_note);
				    ButtonGroup notation =new ButtonGroup();
				    //---
				    JRadioButton canada=new JRadioButton("Canadien");
				    canada.setOpaque(false);
				    canada.setEnabled(false);
				    canada.setForeground(Color.WHITE);
				    esp_prof.add(canada);
				    notation.add(canada);
				    //---
				    JRadioButton usa=new JRadioButton("Américain");
				    usa.setOpaque(false);
				    usa.setEnabled(false);
				    usa.setForeground(Color.WHITE);
				    esp_prof.add(usa);
				    notation.add(usa);
				    //---
				    esp_prof.add(Box.createHorizontalStrut(1300));
				 //--
				   listEtud=new JButton("Liste des etudiants qu'ont passé l'examen");
				   listEtud.setForeground(Color.WHITE);
				   listEtud.setBackground(Color.BLACK);
				   listEtud.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						EcouteurClicSouris ee= new EcouteurClicSouris();
						ee.jouerSon("C:\\Users\\pc\\Downloads\\c.wav");
					}
				});
				    esp_prof.add(listEtud);
				    listEtud.setEnabled(false);
				  //-------
    esp_prof.setOpaque(false);
    esp_prof.setVisible(false);
    
    
    //-----------------------------------------------
    mainPanel.add(esp_prof);
    
    
    //__________________________________________
    //int nombre_etud=Etudiants.size();
   
  
 EtudiantPanel listEt=new EtudiantPanel(qcm.Etudiants,Accueil);
 //-----
 Accueil.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		EcouteurClicSouris ee= new EcouteurClicSouris();
		ee.jouerSon("C:\\Users\\pc\\Downloads\\c.wav");
		listEt.setVisible(false);
		esp_etud.setVisible(true);
		esp_prof.setVisible(true);
	}
});
 //-----
 listEt.setVisible(false);
 mainPanel.add(listEt);
    //----------------------------
    infos=new JPanel(new GridLayout(2,2));
    infos.setVisible(false);
    nom_.setForeground(Color.white);
    Niveau.setForeground(Color.white);
    filiere.setForeground(Color.white);
    //infos.setPreferredSize(new Dimension(infos.getWidth(),50));
    titre.setForeground(Color.white);
    infos.setBorder(BorderFactory.createTitledBorder(""));
    infos.setOpaque(false);
    infos.add(titre);
    //--------------------
    JPanel vide=new JPanel();
    vide.setOpaque(false);
    infos.add(vide);
    //----
    etudiant=new JPanel(new GridLayout(1,3));
    TitledBorder tit0=BorderFactory.createTitledBorder("Etudiant");
    tit0.setTitleColor(Color.WHITE);
    etudiant.setBorder(tit0);
    etudiant.setOpaque(false);
    
    infos.add(etudiant);
    //----
    prof=new JPanel(new GridLayout(1,2));
    TitledBorder tit01=BorderFactory.createTitledBorder("Professeur");
    tit01.setTitleColor(Color.WHITE);
    prof.setBorder(tit01);
    prof.add(profLabel2);
    JLabel nom_prof=new JLabel("Nom : XX");
    nom_prof.setForeground(Color.WHITE);
    JLabel spec_prof=new JLabel("Spécialité : Informaticien");
    spec_prof.setForeground(Color.WHITE);
    prof.add(nom_prof);
    prof.add(spec_prof);
    prof.setOpaque(false);
    infos.add(prof);
    //--------------------------
    mainPanel.add(infos);
    //----------------------------
    questions = new JPanel(new FlowLayout());
    questions.setVisible(false);
    questions.setPreferredSize(new Dimension(questions.getWidth(),100));
    TitledBorder tit1=BorderFactory.createTitledBorder("Question");
    tit1.setTitleColor(Color.WHITE);
    questions.setBorder(tit1);
    qst.setForeground(Color.WHITE);
    qst.setFont(new Font("Arial", Font.PLAIN,30));
    qst.setOpaque(false);
    questions.add(qst);
    skip.setForeground(Color.WHITE);
    skip.setBackground(Color.BLACK);
    skip.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			EcouteurClicSouris ee= new EcouteurClicSouris();
			ee.jouerSon("Images/c.wav");
			temps_qcm=TEMPS*num_qst-1 ;
			temps_qst=TEMPS ;
			
		}
	});
    questions.add(skip);
    questions.setOpaque(false);
    mainPanel.add(questions);
	//------------------------------
    JPanel options = new JPanel(new GridLayout(4,1));
    options.setVisible(false);
    options.setPreferredSize(new Dimension(options.getWidth(), opt[0].getHeight()+opt[1].getHeight()+opt[2].getHeight()+opt[3].getHeight()+150));
    TitledBorder tit2=BorderFactory.createTitledBorder("Les choix");
    tit2.setTitleColor(Color.WHITE);
   
    options.setBorder(tit2);
    //----
  
    for(int i=0;i<4;i++) {
    	opt[i]=new JRadioButton();
    	opt[i].setHorizontalAlignment(SwingConstants.CENTER);
    	opt[i].setForeground(Color.BLACK);
    	opt[i].setFont(new Font("Arial", Font.BOLD,25));
    	options.add(opt[i]);
    	opt[i].setOpaque(false);
    }
    //----
    options.setOpaque(false);
    mainPanel.add(options);
    //------------------------------
    JPanel bas = new JPanel(new GridLayout(1, 4)) {
    	@Override
    		public void paint(Graphics g) {
    			// TODO Auto-generated method stub
    			super.paint(g);
    			Graphics2D g2 = (Graphics2D) g;
    			g2.setColor(Color.black);
    			g2.setStroke(new BasicStroke(5)); // Définit l'épaisseur de trait à 5 pixels
    			//g2.drawLine(x1, y1, x2, y2); /
    			g2.drawLine(750, y_tQST, x_tQST, y_tQST);
    			g2.drawLine(0, y_tQST,x_tQSM, y_tQST);
    		}
    };
    bas.setVisible(false);
    bas.setBorder(BorderFactory.createTitledBorder(""));
    //----
    t_qcm.setForeground(Color.BLACK);
    t_qcm.setFont(new Font("Serif", Font.ITALIC,20));
    bas.add(t_qcm);
    //----
    N_qst.setForeground(Color.BLACK);
    N_qst.setFont(new Font("Serif", Font.ITALIC,20));
    bas.add(N_qst);
    //----
    t_qst.setForeground(Color.BLACK);
    t_qst.setFont(new Font("Serif", Font.ITALIC,20));
    bas.add(t_qst);
    //----
    //skip.setPreferredSize(new Dimension(100,50));
    
    bas.setOpaque(false);
    mainPanel.add(bas);
    //---------------------------------
    fin_QCM=new JPanel() ;
    n.setForeground(Color.white);
    n.setFont(new Font(Font.SERIF, Font.BOLD,40));
    decision.setForeground(Color.white);
    decision.setFont(new Font(Font.SERIF, Font.BOLD,40));
    fin_QCM.setLayout(null);
    n.setBounds(450,50,400,35);
    decision.setBounds(390, 100, 1000, 35);
    smileLabel.setBounds(350, 180, 500, 500);
    fin_QCM.add(n);
    fin_QCM.add(decision);
    fin_QCM.add(smileLabel);
    fin_QCM.setOpaque(false);
    fin_QCM.setVisible(false);
    //_____________________________________________________________________
   
    mainPanel.add(fin_QCM);
    
    
   
    //---------------------------------
    this.getContentPane().add(mainPanel);
    //---------------------------------
    t=new Timer(vitesse,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			application_commence.stop();
			temps_qcm++;
			temps_qst--;
			t_qcm.setText("Temps de QCM : "+temps_qcm+"s");
			t_qst.setText("Temps de Question : "+temps_qst+"s");
			
			if(temps_qcm%TEMPS==0 && num_qst<NUM_QST) {
				sizeP=false ;
				for(int i=0;i<4;i++) {
					opt[i].setSelected(false);
				}
				qst.setText(question_qcm[num_qst].question);
				
				opt[0].setText(question_qcm[num_qst].A);
				opt[1].setText(question_qcm[num_qst].B);
				opt[2].setText(question_qcm[num_qst].C);
				opt[3].setText(question_qcm[num_qst].D);
				temps_qst=TEMPS ; 
				//--------------------------------
				
				//--------------------------------
				num_qst++;
				N_qst.setText("Question : "+num_qst+"/"+NUM_QST);
				
			}
			//------------------------------
			
			
			//-----------------------------
			
			if(num_qst<=NUM_QST) {
				if (opt[0].isSelected() && !reponses[num_qst-1].contains(Character.toString('A'))) {
					EcouteurClicSouris ee= new EcouteurClicSouris();
					ee.jouerSon("Images/c2.wav");
					reponses[num_qst-1] = reponses[num_qst-1].replace("false", "");
					reponses[num_qst-1]=reponses[num_qst-1]+"A";

					}
				if(!opt[0].isSelected()) reponses[num_qst-1] = reponses[num_qst-1].replace("A", "");
				if(!opt[1].isSelected()) reponses[num_qst-1] = reponses[num_qst-1].replace("B", "");
				if(!opt[2].isSelected()) reponses[num_qst-1] = reponses[num_qst-1].replace("C", "");
				if(!opt[3].isSelected()) reponses[num_qst-1] = reponses[num_qst-1].replace("D", "");
				//----
				if (opt[1].isSelected() && !reponses[num_qst-1].contains(Character.toString('B'))) {
					EcouteurClicSouris ee= new EcouteurClicSouris();
					ee.jouerSon("Images/c2.wav");
					reponses[num_qst-1] = reponses[num_qst-1].replace("false", "");
					reponses[num_qst-1]=reponses[num_qst-1]+"B";
				}
				//---- 
				if (opt[2].isSelected() && !reponses[num_qst-1].contains(Character.toString('C'))) {
					EcouteurClicSouris ee= new EcouteurClicSouris();
					ee.jouerSon("Images/c2.wav");
					reponses[num_qst-1] = reponses[num_qst-1].replace("false", "");
					reponses[num_qst-1]=reponses[num_qst-1]+"C";
				}
				//----
				if (opt[3].isSelected() && !reponses[num_qst-1].contains(Character.toString('D'))) {
					EcouteurClicSouris ee= new EcouteurClicSouris();
					ee.jouerSon("Images/c2.wav");
					reponses[num_qst-1] = reponses[num_qst-1].replace("false", "");
					reponses[num_qst-1]=reponses[num_qst-1]+"D";
				}
			}
			
			if(temps_qcm==NUM_QST*TEMPS+1) {
				infos.setVisible(false);
				questions.setVisible(false);
				options.setVisible(false);
				bas.setVisible(false);
				fin_QCM.setVisible(true);
				/*for(int i =0;i<NUM_QST;i++) {
					System.out.println(i+" "+reponses[i]);
				}*/
				correction(Notation);
				 n.setText("Votre Note est : "+Note+"/"+NUM_QST);
				
				if(Note>=V*NUM_QST) {
			    	decision.setText("Decision : VALIDER"+"("+v+"%)");
			    	smileLabel.setIcon(new ImageIcon("Images/smile score.png"));
			    }
				 String ff =filiere.getText().replace("Filiere :", "");
				 String dd=decision.getText().replace("Decision : ", "");
				 qcm.insererEtudiant(nom.getText(), nv.getText(),ff,titre.getText(),Note,dd) ;
				//System.out.println(Note);
				// Etudiants.add(new Etudiant(nom.getText(), nv.getText(),ff,titre.getText(),Note,dd));
			}
			
		
			
		}
    	
		
		
		//---
		 
		//---
		
		
    });
    //t.start();
    
    Timer t2=new Timer(TEMPS*1000/400,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			x_tQST+=1;
			y_tQST=t_qst.getY()+2 ;
			//System.out.println(x_tQST);
			repaint();
			if(temps_qcm%TEMPS==0 ) x_tQST=750;
			
		}
    	
    });
   //t2.start();
   
   Timer t3=new Timer(TEMPS*1000*NUM_QST/250,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			x_tQSM+=1;
			//System.out.println(x_tQST);
			repaint();	
		}
   	
   });
  //t3.start();
  
  Timer t4=new Timer(1,new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  long TempsActuel = System.currentTimeMillis();
	        long DiffTemps = TempsActuel - TempsPrec;
	        TempsPrec = TempsActuel;
	        
	        int hauteurCible = qst.getHeight() + 10;
	        if (questions.getPreferredSize().height <  hauteurCible) {
	            k += DiffTemps  * 0.2; // adjust the speed here
	            k = Math.min(k,  hauteurCible);
	            questions.setPreferredSize(new Dimension(questions.getWidth(), k));
	            questions.revalidate();
	            questions.repaint();
	        }
	        //--------------------------------
	        if (questions.getPreferredSize().height >  hauteurCible) {
	            k -= DiffTemps  * 0.2; 
	            k = Math.max(k,  hauteurCible);
	            questions.setPreferredSize(new Dimension(questions.getWidth(), k));
	            questions.revalidate();
	            questions.repaint();
	        }
	        //---------------------------------
	        int hauteurActuel = qst.getPreferredSize().height;
	        if (hauteurActuel+10 > maxHeight ) {
	        	sizeP=true ; 
	            fontSize -= 1;
	            qst.setFont(new Font("Arial", Font.PLAIN, fontSize));
	            //qst.setPreferredSize(new Dimension(qst.getPreferredSize().width, currentHeight - 1));
	            qst.revalidate();
	            //qst.repaint();
	        } else if (hauteurActuel  < maxHeight &&sizeP==false) {
	            fontSize = 30;
	            qst.setFont(new Font("Arial", Font.PLAIN, fontSize));
	            //qst.setPreferredSize(new Dimension(qst.getPreferredSize().width, maxHeight));
	            qst.revalidate();
	            qst.repaint();
	        }
	    }
	    
} );
  //t4.start();
   application_commence=new Timer(100, new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(new String(password.getPassword()).equals(PASSWORD)) {
			titreQSM.setEnabled(true);
			nb_qsts.setEnabled(true);
			temp5.setEnabled(true);
			temp10.setEnabled(true);
			temp20.setEnabled(true);
			temp30.setEnabled(true);
			temp1min.setEnabled(true);
			canada.setEnabled(true);
			usa.setEnabled(true);
			listEtud.setEnabled(true);
		}
		//-------
		if(!nom.getText().equals("") && !nv.getText().equals("") && (fil1.isSelected() ||fil2.isSelected() || fil3.isSelected() )) {
		  	esp_etud.setVisible(false);
		  	esp_prof.setVisible(false);
		  	infos.setVisible(true);
		  	questions.setVisible(true);
		  	options.setVisible(true);
		  	bas.setVisible(true);
		    nom_.setText("Nom :"+nom.getText());
		    Niveau.setText("Niveau :"+nv.getText());
		    if (fil1.isSelected()) { filiere.setText("Filiere : G-INFO");
		    question_qcm = qcm.QCM_Java.toArray(new Question[qcm.QCM_Java.size()]);
		    }
		    if (fil2.isSelected()) {filiere.setText("Filiere : GTR");
		    question_qcm = qcm.QCM_Réseaux.toArray(new Question[qcm.QCM_Réseaux.size()]);
		    
		    }
		    if (fil3.isSelected()) {filiere.setText("Filiere : G-SEII");
		    question_qcm = qcm.QCM_GSEII.toArray(new Question[qcm.QCM_GSEII.size()]);
		    }
		    if(vides==true) {
		    	etudiant.add(etudiantLabel);
		    etudiant.add(nom_);
		    etudiant.add(Niveau);
		    etudiant.add(filiere);
		    
		    if(temp5.isSelected()) TEMPS=5 ; 
		    if(temp10.isSelected()) TEMPS=10 ; 
		    if(temp20.isSelected()) TEMPS=20 ; 
		    if(temp30.isSelected()) TEMPS=30 ; 
		    if(temp1min.isSelected()) TEMPS=60 ; 
		    
		    if(canada.isSelected()) Notation =-1 ; 
		    if(usa.isSelected()) Notation=0 ; 
		    titre.setText(titreQSM.getText());
		    if (nb_qsts.getText().matches("\\d+")) NUM_QST=Integer.parseInt( nb_qsts.getText());
		    }
		    vides=false ; 
		    
		  	t.start();
		  	t2.start();
		  	t3.start();
		  	t4.start();
		  }
	
	}
});
   commencerTous.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		commence.setVisible(false);
		esp_etud.setVisible(true);
		esp_prof.setVisible(true);
		application_commence.start();
		EcouteurClicSouris ee= new EcouteurClicSouris();
		ee.jouerSon("Images/c.wav");
	}
});
   
   

  
  listEtud.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		esp_etud.setVisible(false);
		esp_prof.setVisible(false);
		listEt.setVisible(true);
	}
});
  
   }
   
   public boolean ReponseCorrect(String s1, String s2) {
	    // Convertir les chaînes en tableaux de caractères
	    char[] rep = s1.toCharArray();
	    char[] correc = s2.toCharArray();
	    
	    // Trier les tableaux de caractères
	    Arrays.sort(rep);
	    Arrays.sort(correc);
	    
	    // Comparer les tableaux de caractères
	    return Arrays.equals(rep, correc);
	}
   public int correction(int Notation) {
		if(num_qst==NUM_QST) {
		    for(int i=0;i<NUM_QST;i++) {
		    	reponses[i]= Boolean.toString(ReponseCorrect(reponses[i], question_qcm[i].correction));
		    	if (reponses[i]=="true") Note++;
		    	else {Note=Note+Notation;}
		    }
		    System.out.println(Note);
		    }
		
	   return Note ; 
   }

  
  
}
