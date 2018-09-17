package modul4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodsur
 */
public class liang7_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] talArray = {2,5,6,2,8,1,6};

        int count;

        for (int tilTilCheck = 1; tilTilCheck<10;tilTilCheck++) {
            count = 0;
            for (int i = 0; i<talArray.length;i++) {
                if (talArray[i] == tilTilCheck) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("talet " + i + " er tilstede " + count + " gange");
            }
        }
    }
    
}
