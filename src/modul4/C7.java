/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul4;

/**
 *
 * @author rodsur
 */
public class C7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Opgave C.7:
        Skriv et program, der implementerer Game of Life
        (bemærk at dette ikke er meget mere end en 2D verden med 4 regler).
        Dette er en lidt større opgave. 
        */
        int[][] screen1 = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0},
            {0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        
        int[][] screen2;
        screen2 = new int[16][33];
        
        int turn;
        int liveCells;
        
        System.out.println("brættet er " + screen1.length + " høj og "
                + screen1[0].length + " bred");
        
        for (turn=0; turn<100; turn++) {
            //Vælg hvilket array der er skal vises og hvilket der er buffer
            int[][] currentScreen = (turn%2==0 ? screen1 : screen2);
            int[][] currentBuffer = (turn%2==1 ? screen1 : screen2);
            
            //fyld buffer med 0er
            for (int y = 0; y<currentBuffer.length; y++){
                for (int x = 0; x<currentBuffer[y].length; x++){
                    currentBuffer[y][x] = 0;
                }
            }
            
            //print det nuværende array
            System.out.println("generation " + turn + "---------------------");
            for (int y = 0; y<currentScreen.length; y++){
                for (int x = 0; x<currentScreen[y].length; x++){
                    System.out.print(currentScreen[y][x]);
                }
                System.out.println("");
            }
            
            //Arbejd med det nuværende stadie og gem ændringer i bufferen
            for (int y = 0; y<currentScreen.length; y++){
                //System.out.println(currentScreen[y].length);
                for (int x = 0; x<currentScreen[y].length; x++){
                    liveCells = 0;
                    //System.out.printf("x: %d y: %d\n",x,y);
                    //System.out.println("Denne celle er: " + currentScreen[y][x]);
                    //Check de omkring liggende celler
                    if (y != 0) {
                        if (currentScreen[y-1][x] == 1) {
                            liveCells++;
                        }
                        if (x != 0) {
                            if (currentScreen[y-1][x-1] == 1) {
                                liveCells++;
                            }
                        }
                        if (x != currentScreen[y].length - 1) {
                            if (currentScreen[y-1][x+1] == 1) {
                                liveCells++;
                            }
                        }
                    }
                    
                    if (y != currentScreen.length - 1) {
                        if (currentScreen[y+1][x] == 1) {
                            liveCells++;    
                        }
                        if (x != 0) {
                            if (currentScreen[y+1][x-1] == 1) {
                                liveCells++;
                            }
                        }
                        if (x != currentScreen[y].length - 1) {
                            if (currentScreen[y+1][x+1] == 1) {
                                liveCells++;
                            }
                        }
                    }
                    
                    if (x != 0) {
                        if (currentScreen[y][x-1] == 1) {
                            liveCells++;
                        }
                    }
                    
                    if (x != currentScreen[y].length - 1) {
                        if (currentScreen[y][x+1] == 1) {
                        liveCells++;
                        }
                    }
                    
                    //Regler
                    if (currentScreen[y][x] == 1) {
                        if (liveCells < 2 || liveCells > 3) {
                            currentBuffer[y][x] = 0;
                        } else {
                            currentBuffer[y][x] = 1;
                        }
                    } else if (currentScreen[y][x] == 0 && liveCells == 3){
                        currentBuffer[y][x] = 1;
                    }

                }
            }
        //pause loop
        for (long i=0 ; i<1000000000 ; i++) {}
        }
        System.out.println("Done");
    }
    
}
