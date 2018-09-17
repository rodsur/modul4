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

        for (int i = 1; i<10;i++) {
            count = 0;
            for (int i2 = 0; i2<talArray.length;i2++) {
                if (talArray[i2] == i) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("talet " + i + " er tilstede " + count + " gange");
            }
        }
    }
    
}
