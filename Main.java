import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String line;
        String[] input;
        
        while (true) {
            line = scanner.nextLine();
            input = line.split("\\s+");
            
            switch (input[0].toUpperCase()) {
                case "BET" :
                    List<Integer> numerePariate = new ArrayList<>();
                    for (int i = 0; i <= Lottery.ELEMENTE; i++) {
                        int x = Integer.parseInt(input[i]);
                        numerePariate.add(x);
                    }
                    int castig = Lottery.getInstance().calculeaza(numerePariate);
                    
                    System.out.println("Ai castigat " + castig);
                    
                    Lottery.getInstance().afiseaza();
                    
                    break;
                case "EXIT" :
                    System.exit(0);
                    break;
                default :
                    System.err.println("Comanda invalida");
            }
        }
            
    }
}