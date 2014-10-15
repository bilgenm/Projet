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
public class ImmoMVC {
    public ImmoMVC(){
        ImmoVue v = new ImmoVue();
        ImmoModele m = new ImmoModele();
        ImmoControleur ctrl= new ImmoControleur(v,m);
        ctrl.menu();
        
    }
    public static void main(String[] args) {
        ImmoMVC imm = new ImmoMVC();
    }
    
}
