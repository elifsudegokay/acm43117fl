/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package and_hmw;

import java.util.Random;

/**
 *
 * @author inspark
 */
public class And_Hmw {

    /**
     * @param args the command line arguments
     */
    public static boolean oynaniyor = true;
    public static String oynayan = "beyaz";
    public static String siradaki = "siyah";
    public static String[][] tahta = new String[8][8];
    public static void main(String[] args) {
        // TODO code application logic here
        
        // tahtadaki taşları yerleştir.
        
        tahta[0][0] = "beyaz - kale";
        tahta[0][1] = "beyaz - at";
        tahta[0][2] = "beyaz - fil";
        tahta[0][3] = "beyaz - vezir";
        tahta[0][4] = "beyaz - sah";
        tahta[0][5] = "beyaz - fil";
        tahta[0][6] = "beyaz - at";
        tahta[0][7] = "beyaz - kale";
        for (int i = 0; i < 8; i++) {
            tahta[1][i] = "beyaz - piyon" + i;
        }
        tahta[7][0] = "siyah - kale";
        tahta[7][1] = "siyah - at";
        tahta[7][2] = "siyah - fil";
        tahta[7][3] = "siyah - vezir";
        tahta[7][4] = "siyah - sah";
        tahta[7][5] = "siyah - fil";
        tahta[7][6] = "siyah - at";
        tahta[7][7] = "siyah - kale";
        for (int i = 0; i < 8; i++) {
            tahta[6][i] = "siyah - piyon" + i;
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tahta[i][j] = "Bos";
            }
        }
        print(tahta);
        
        // Sah yakalanana kadar oynayan true olmalıdır.
        
        while (oynaniyor) {
            oyna();
        }
    }

    public static void oyna() {
        // Hamle yapılana kadar hamle yapacak true olmalıdır.
        
        boolean hamleYapacak = true;
        while (hamleYapacak) {
            // tahta üstüne random konum alınmalıdır.
            
            int x = new Random().nextInt(7);
            int y = new Random().nextInt(7);
            System.out.println(x);
            System.out.println(y);
            
            // Eğer random değer oynayan kişinin taşı ise hamle kontrol edilmelidir.
            
            if (tahta[x][y].contains(oynayan)) {
                
                //random değer piyon ise ileri hareket kontrol edilmelidir
                
                
                if(tahta[x][y].contains("piyon")){
                    for(int i=y;i<8;i++){
                        if(i+1 != 7){
                            if(tahta[x][y+1].contains("Bos")){
                                tahta[x][y+1] = tahta [i][y];
                                tahta[x][y]= "Bos";
                                 hamleYapacak=false;
                                 String gecici = oynayan;
                                 oynayan = siradaki;
                                 siradaki = gecici;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void print(String[][] oyunTahtasi) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + oyunTahtasi[i][j] + "");
            }
            System.out.println("");
        }
    }
}
