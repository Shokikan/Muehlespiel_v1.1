import java.util.HashMap;

public class Spielfeld {
    public void feld() {
        int[] id = {0,3,6,8,10,12,16,17,18,23,25,30,31,32,36,38,40,42,45,48};
        int j = 0;
        int i = 0;
        int key = 0;
        HashMap<Integer, Integer> Feld = new HashMap<Integer, Integer>();

        for(int x=0; x<7; x++) {
            for(int y=0; y<7; y++) {
                if(i == id[j]) {
                    System.out.println(x + " " + y);
                    Feld.put(key, value)


                    j++;
                    i++;
                }else{
                    i++;
                }
            }
        }
    }  
}
