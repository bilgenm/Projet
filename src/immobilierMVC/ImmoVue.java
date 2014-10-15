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
import java.util.Scanner;
public class ImmoVue {
    private Scanner sc = new Scanner(System.in);
    public ImmoVue() {
        
    }
    public void affMsg(String msg) {
        System.out.print(msg);
    }
    public String getMsg() {
        String msg = sc.nextLine();
        return msg;
    }
    
}
