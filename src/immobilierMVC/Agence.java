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
public class Agence {
    private String nomAgence;
    private String adresseAg;
    private String tel;
    private String nomGerant;
    
    public Agence() {
        this.nomAgence = "";
        this.adresseAg = "";
        this.tel = "";
        this.tel = "";
    }
    public Agence(String nomAgence, String adresseAg, String tel, String nomGerant) {
        this.nomAgence = nomAgence;
        this.adresseAg = adresseAg;
        this.tel = tel;
        this.nomGerant = nomGerant;
    }

    @Override
    public String toString() {
        return "Nom d'agence: "+nomAgence+", adresse de l'agence: "+adresseAg+", téléphone: "+tel+", nom de gérant: "+nomGerant;
    }
    
    
}
