package QCM_Projet;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EtudiantPanel extends JPanel {
    private JTable table;
    private JScrollPane scrollPane; 
    public EtudiantPanel(ArrayList<Etudiant> etudiants,JButton Accueil  ) {
        setLayout(new BorderLayout());

        // Créer le modèle de tableau pour les étudiants
        Object[][] data = new Object[etudiants.size()][6];
        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant etudiant = etudiants.get(i);
            data[i][0] = etudiant.nom_complet;
            data[i][1] = etudiant.Niveau;
            data[i][2] = etudiant.Filiere;
            data[i][3] = etudiant.qcm_p;
            data[i][4] = etudiant.Note;
            data[i][5] = etudiant.decision;
        }
        String[] columnNames = {"Nom", "Niveau", "Filiére","Examen","Note","Décision"};

        // Créer le modèle de tableau par défaut avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Créer la table avec le modèle de tableau par défaut
        table = new JTable(model);
        table.setBackground(new Color(0, 13, 44));
        table.setForeground(Color.WHITE);
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.BOLD, 15));
        // Créer le rendu personnalisé pour mettre en gras le texte
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(renderer.getFont().deriveFont(Font.BOLD)); // Mettre en gras le texte
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Appliquer le rendu personnalisé à toutes les colonnes
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
            //table.getColumnModel().getColumn(i).set
        }
        
        //_________________________________________
      
        //_________________________________________
        
        TableColumn colonneNote = table.getColumnModel().getColumn(4);
        colonneNote.setPreferredWidth(15);

        TableColumn colonneNv = table.getColumnModel().getColumn(1);
        colonneNv.setPreferredWidth(150);
        // Créer la barre de défilement verticale avec la table
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Ajouter la barre de défilement au panneau
        
        Accueil.setPreferredSize(new Dimension(120, 30));
        Accueil.setBackground(Color.BLACK);
        Accueil.setForeground(Color.white);
        Accueil.setFont(new Font("Arial", Font.BOLD, 15));
        add(Accueil,BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
      
    }
}