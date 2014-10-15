/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package immobilierMVC;

import java.util.Objects;

/**
 *
 * @author Bilgen
 */
public abstract class Bien{
    protected String ref;
    protected String adresse;
    protected String ville;
    protected String pays;
    protected String theme;
    protected float prixBase;
    protected Agence ag;
    
    public Bien(){
        this.ref = "";
        this.adresse = "";
        this.ville = "";
        this.pays = "";
        this.theme = "";
        this.prixBase = 0;
        this.ag=null;
    }
    public Bien(String ref, String adresse, String ville, String pays, String theme, float prixBase){
        this.ref = ref;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.theme = theme;
        this.prixBase = prixBase;
        this.ag=new Agence();
    }
    public String getRef(){
        return this.ref;
    }
    public void setPrixBase(float prixBase){
        this.prixBase = prixBase;
    }
    public Agence getAg(){
        return this.ag;
    }
    public void setAg(Agence ag) {
        this.ag=ag;
    }
    public String afficheBien(){
        return "\n"+detail1()+"\nréférence: " + ref + "\nAdresse: " + adresse + ", ville: " + ville + ", pays: " + pays + "\nthème: " + theme + "\nprix de base: " + prixBase +" euros"+ detail2()+"\n\t===Info agence===: \n" + ag+"\n";
    }
    public abstract String detail1();
    public abstract String detail2();
   
    
}

