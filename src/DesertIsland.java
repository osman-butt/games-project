import java.util.Arrays;
import java.util.Scanner;

public class DesertIsland {
    public static void main(String[] args) {
        // options array -  List all possible options to bring
        String[] options = {"kæreste","kaffemaskine","Netflix","sofa",
                "løbesko","guitar","slik", "hund", "bog", "øl"};
        // choices array - stores all choices made by the user
        int[] choices = new int[options.length];
        // Initialize scanner object
        Scanner scannerInt = new Scanner(System.in);

        // Print question
        System.out.println("Hvilke ting vil du helst have med på en øde ø?");
        for (int i = 0; i<options.length; i++){
            System.out.println(i+1+" "+options[i]);
        }

        int choice = 99; // Initialize choice

        // Whilie loop runs as long as the user doesn't cancel
        while(choice!=0){
            System.out.println("Indtast valg (vælg 0 for at afslutte): ");

            choice = scannerInt.nextInt(); // Read choice
            int indexChoice = choice - 1; // Get choice 0-based index

            if(choice<0 | choice>options.length){ // We can only choose between options list
                System.out.println("Ugyldigt valg prøv igen!");
            }else if (choice==0) {
                System.out.println("-----");
            } else{ // Prints choice and adds 1 to choices array
                System.out.println(options[indexChoice]);
                choices[indexChoice]++;
            }
        }
        // Prints the most popular choices
        printPopularChoices(choices,options);
    }

    public static void printPopularChoices(int[] choicesArray, String[] optionsArray){
        // Get max value of choicesArray
        int maxCount = choicesArray[0]; // setting initial value
        for (int i = 1; i < choicesArray.length; i++){
            if(choicesArray[i]>maxCount){
                maxCount = choicesArray[i];
            }
        }

        System.out.println(Arrays.toString(choicesArray)); // Print choices array
        System.out.print("Mest populære valg er ");

        // Loop through entire choices list to print all popular choices
        int numberOfPopularChoices = 0;
        for (int i=0; i<choicesArray.length; i++){
            if (choicesArray[i]==maxCount){
                if(numberOfPopularChoices>0){
                    System.out.print(", ");
                }
                System.out.print(optionsArray[i]);
                numberOfPopularChoices++;
            }
        }

    }
}
