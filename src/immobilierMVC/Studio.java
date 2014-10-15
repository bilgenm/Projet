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
public class Studio extends Bien{
    private int dureeSemaine;
    private float superficie;
    
    public Studio(){
        this.dureeSemaine = 0;
        this.superficie = 0;
    }
    public Studio(String ref, String adresse, String ville, String pays, String theme, float prixBase, int dureeSemaine, float superficie){
        super(ref,adresse,ville,pays,theme,prixBase);
        this.dureeSemaine = dureeSemaine;
        this.superficie = superficie;
    }   

    @Override
    public String detail1() {
        return "Studio: ";
    }

    @Override
    public String detail2() {
        return ", Durée en semaine: "+dureeSemaine+", superficie: "+superficie+" m²";
    }

    
    
}
