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
public class ImmoControleur {
    private ImmoVue v = new ImmoVue();
    private ImmoModele m = new ImmoModele();
    
    public ImmoControleur(ImmoVue v, ImmoModele m){
        this.v = v;
        this.m = m;
    }
    public void menu() {
        
        String menu = "\n\t1.Ajouter des agences"
                        + "\n\t2.Ajouter des biens"
                        + "\n\t3.Modifier le prix de base d'un bien"
                        + "\n\t4.Afficher la liste des caractèristiques de tous les biens"
                        + "\n\t5.Transférer un bien vers une autre agence"
                        + "\n\t6.Quitter \n";
        int choix = 0;
         do{
             v.affMsg("\t=====MENU=====\n");
             v.affMsg(menu);
             choix = verifValeurEntier("Votre choix: ");
             switch(choix){
                 case 1: ajoutAgence();
                         break;
                 case 2: ajoutBien();
                         break;
                 case 3: modifPrix();
                         break;
                 case 4: afficheComplet();
                         break;  
                 case 5: transferBien();
                         break;
                 case 6: v.affMsg("Au revoir!");
                         break;
                default: v.affMsg("Choix erroné!");
             }
        }while(choix!=6);
    }
    /*Dans l'énoncé j'ai pas compris s'il faut ajouter 
    une agence ou plusieurs à la fois */
    public void ajoutAgence(){
        String nomA,adresse,telA,nomGerant;
        String choix ="";
        do{
            v.affMsg("Nom de l'agence: ");
            nomA=v.getMsg();
            v.affMsg("Adresse de l'agence: ");
            adresse=v.getMsg();
            v.affMsg("Téléphone de l'agence: ");
            telA=v.getMsg();
            v.affMsg("Nom de gérant: ");
            nomGerant=v.getMsg();
            Agence a = new Agence(nomA,adresse,telA,nomGerant);
            m.ajoutAgence(a);
            do{
                v.affMsg("Voulez-vous ajouter encore une agence (o/n)?  ");
                choix=v.getMsg();  
            }while(!choix.equalsIgnoreCase("o")&&!choix.equalsIgnoreCase("n"));
        }while(choix.equalsIgnoreCase("o"));
    }
    /*Dans l'énoncé j'ai pas compris si il faut ajouter 
    un bien ou plusieurs à la fois */
    public void ajoutBien(){
        String ref,adresse,ville,pays,theme;
        String choix = "";
        float prix;
        boolean ok = false;
        Agence a;
        Bien b = null;
        do{
            v.affMsg("Référence: ");
            ref = v.getMsg();
            v.affMsg("Adresse: ");
            adresse = v.getMsg();
            v.affMsg("Ville: ");
            ville = v.getMsg();
            v.affMsg("Pays: ");
            pays = v.getMsg();
            v.affMsg("Thème: ");
            theme = v.getMsg();
            prix = verifReel("Prix: ");
            int rep = 0;
            String affChoix = "\n\t1.Appartement\n\t2.Studio\n";
            v.affMsg(affChoix);
            ok = false;
            do{
                rep = verifValeurEntier("Votre choix: ");
            }while(rep!=1 && rep!=2);
            switch(rep){
                case 1: String type;
                        int etage,numero,nbreChambre;
                        float suppSaison;
                        v.affMsg("Type: ");
                        type=v.getMsg();
                        etage = verifValeurEntier("Etage: ");
                        numero = verifValeurEntier("Numéro: ");
                        nbreChambre = verifValeurEntier("Combien de Chambres? ");
                        suppSaison =  verifReel("Supplément haute saison: ");
                        b = new Appartement(ref,adresse,ville,pays,theme,prix,type,etage,numero,nbreChambre,suppSaison);
                        break;
                case 2: int dureeSemaine;
                        float superficie;
                        dureeSemaine = verifValeurEntier("Durée en semaine: ");
                        superficie = verifReel("Superficie: ");
                        b = new Studio(ref,adresse,ville,pays,theme,prix,dureeSemaine,superficie);  
                        break;
                
            }
            m.ajoutBien(b);
            v.affMsg("===== Ajoutez une agence =====\n");
            a = ajoutAB(m.getListeAgences());
            if(a==null){
                v.affMsg("Nom de l'agence: ");
                String nomA=v.getMsg();
                v.affMsg("Adresse de l'agence: ");
                String adresseA=v.getMsg();
                v.affMsg("Téléphone de l'agence: ");
                String telA=v.getMsg();
                v.affMsg("Nom de gérant: ");
                String nomGerant=v.getMsg();
                a = new Agence(nomA,adresseA,telA,nomGerant);
                m.ajoutAgence(a);
            }
            b.setAg(a);
            do{
                v.affMsg("Voulez-vous ajouter encore un bien (o/n)?  ");
                choix=v.getMsg();  
            }while(!choix.equalsIgnoreCase("o")&&!choix.equalsIgnoreCase("n"));  
        }while(choix.equalsIgnoreCase("o"));
        
    }
    public void modifPrix(){
        Bien b;
        v.affMsg("Entrez la référence du bien: ");
        String ref = v.getMsg();
        b = m.rechReference(ref);
        if(b!=null){
            float prixBase = verifReel("Encodez le nouveau prix du bien: ");
            b.setPrixBase(prixBase);
        }
        else{
            v.affMsg("Aucun bien trouvé!!!");
        }
    }
    /*Pour l'affichage je fais afficher pour chaque bien l'agence 
    aussi je sais pas si vous demandez comme ça */
    public void afficheComplet(){
        ArrayList<Bien> liste = new ArrayList();
        liste = m.getListeBiens();
        for(Bien b: liste){
            v.affMsg(b.afficheBien());
        }
    }
    public void transferBien(){
        Bien b;
        Agence ag;
        v.affMsg("Entrez la référence du bien: ");
        String ref = v.getMsg();
        b = m.rechReference(ref);
        if(b!=null){
            /*Ici j'ai pas compris de l'énoncé s'il faut transferer vers les 
            agences qui existent ou on peut encoder des nouveaux agences
            à cause de ça j'ai fait comme cela Madame. Je suis ouverte à 
            toutes remarques! Merci  */
            v.affMsg("Choisissez la nouvelle agence parmi les agences:\n");
            ag=ajoutAB(m.getListeAgences());
            if(ag==null){
                v.affMsg("Le transfert n'est pas effectué!!!");
            }
            else{
                 b.setAg(ag); 
            }
        }
        else{
            v.affMsg("Aucun bien trouvé!!!");
        }
    }
    public Agence ajoutAB(ArrayList<Agence> liste){
        Agence a = null;
        int i,choix =0;
        String rep;
        if(!liste.isEmpty()){
            for(i=0;i<liste.size();i++){
               v.affMsg((i+1)+". "+liste.get(i)+"\n");
            }
            do{
                v.affMsg("\nEst-ce que l'agence fait partie de la liste (oui/non)? ");
                rep=v.getMsg();
           }while(!rep.equalsIgnoreCase("oui")&&!rep.equalsIgnoreCase("non"));
           if(rep.equalsIgnoreCase("oui")) {
                do {
                    choix = verifValeurEntier("Choisissez le numéro de l'agence que vous voulez ajouter: ");  
                }while(choix<1 || choix>liste.size());
                a = liste.get(choix-1);
           }
        }
        return a;
    }
    
    public int verifValeurEntier(String txt){
        int rep = 0;
        boolean ok = false;
        do{
            try{
                v.affMsg(txt);
                rep = Integer.parseInt(v.getMsg());
                ok = true; 
            }
            catch(NumberFormatException e) {
                v.affMsg("Erreur de saisie!!!\n");
            }
      }while(!ok);
        return rep;
    }
    public float verifReel(String txt){
        float valeur = 0;
        boolean ok = false;
        do{
            try{
                v.affMsg(txt);
                valeur =Float.parseFloat(v.getMsg());
                ok = true; 
            }
            catch(NumberFormatException e){
                v.affMsg("Erreur de saisie!!!\n");
            }
        }while(!ok);
        return valeur;
    }
}
