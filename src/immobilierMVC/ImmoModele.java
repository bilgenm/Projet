/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package immobilierMVC;

/**
 *
 * @author Bilgen
 */
import java.util.ArrayList;
public class ImmoModele {
    private ArrayList<Agence> listeAgences = new ArrayList<Agence>();
    private ArrayList<Bien> listeBiens = new ArrayList<Bien>();
    public void ajoutAgence(Agence a){
        listeAgences.add(a);
    }
    public void ajoutBien(Bien b){
        listeBiens.add(b);
    }
    public Bien rechReference(String ref){
        Bien b1 = null;
        for(Bien b : listeBiens){
            if(b.getRef().equalsIgnoreCase(ref)){
                b1=b;
                break;
            }    
        }
        return b1;
    }
    public ArrayList getListeAgences(){
        return listeAgences;
    }
    public ArrayList getListeBiens(){
        return listeBiens;
    }
}
