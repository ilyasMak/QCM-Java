package QCM_Projet;

import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;

public class EcouteurClicSouris  {
    private Clip clip;

   

    void jouerSon(String cheminFichier) {
        try {
            // Chargement du fichier audio à partir d'un File
            File fichierAudio = new File(cheminFichier);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fichierAudio);

            // Création d'un clip audio
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Lancement du son
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
