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
public class Appartement extends Bien {
    private String type;
    private int etage;
    private int numero;
    private int nbreChambre;
    private float supp;
    
    public Appartement(){
        super();
        this.type = "";
        this.etage = 0;
        this.numero = 0;
        this.nbreChambre = 0;
        this.supp = 0;
    }
    public Appartement(String ref, String adresse, String ville, String pays, String theme, float prixBase, String type, int etage, int numero,int nbreChambre, float supp){
        super(ref,adresse,ville,pays,theme,prixBase);
        this.type = type;
        this.etage = etage;
        this.numero = numero;
        this.nbreChambre = nbreChambre;
        this.supp = supp;
    }
    @Override
    public String detail1() {
        return "Appartement: ";
    }

    @Override
    public String detail2() {
        return ", type: "+type+", étage: "+etage+", numéro: "+numero+", nombre de chambre(s): "+nbreChambre+"supplément haute saison: "+supp+" euros";
    }
    

}
