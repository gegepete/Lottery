import java.util.*;
public class Lottery {
    public final static int COMBINATII = 3; // numarul de combinatii
    public final static int ELEMENTE = 6; //numarul de elemente dintr-o combinatie
    public final static int MAX_N = 16; // val limita a elementelor
    private static Lottery singleton;
    
    private Map<Integer, List<Integer>> combinatii = new LinkedHashMap<>();
    private Random random = new Random();
    
    private Lottery(){
    }
    
    public static Lottery getInstance(){
        if (singleton == null) {
            singleton = new Lottery();
        }
        return singleton;
    }
    
    public void genereaza(){
        for (int i = 0; i < COMBINATII; ++i) {
            List<Integer> combinatie = new ArrayList<>();
            
            for (int j = 0; j < ELEMENTE; ++j) {
                combinatie.add(random.nextInt(MAX_N) + 1);
            }
            
            combinatii.put(i, combinatie);
        }
    }
    
    public int calculeaza(List<Integer> numerePariate){
        int punctaj = 0;
        
        genereaza();
        
        for (int i = 0; i < COMBINATII; ++i) {
            List<Integer> combinatie = combinatii.get(i);
            
            for (int j = 0; j < combinatie.size(); ++j) {
                int dif = Math.abs(numerePariate.get(j) - combinatie.get(j));
                
                switch (dif) {
                    case 0 :
                        punctaj += 100;
                        break;
                    case 1 :
                        punctaj += 50;
                        break;
                    case 2 :
                        punctaj += 25;
                        break;
                }
            }
        }
        
        // combinatii.clear();
        
        return punctaj;
    }
    
    public void afiseaza(){
        combinatii.forEach((k, v) -> {
            for (Integer x : v) {
                System.err.print(x + " ");
            }
            System.err.println();
        });
    }
    
}