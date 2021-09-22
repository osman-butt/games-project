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

        System.out.println("Hvilke ting vil du helst have med på en øde ø?");
        for (int i = 0; i<options.length; i++){
            System.out.println(i+1+" "+options[i]);
        }

        int choice = 99;
        while(choice!=0){
            System.out.println("Indtast valg (vælg 0 for at afslutte): ");

            choice = scannerInt.nextInt();
            int indexChoice = choice - 1;
            if(choice<0 | choice>options.length){
                System.out.println("Ugyldigt valg prøv igen!");
            }else if (choice==0) {
                System.out.println("-----");
            } else{
                System.out.println(options[indexChoice]);
                choices[indexChoice]++;
            }
        }
        printPopularChoices(choices,options);
    }

    public static void printPopularChoices(int[] choicesArray, String[] optionsArray){
        // First we get the count of the most popular choice
        int maxCount = choicesArray[0]; // setting initial value
        for (int i = 1; i < choicesArray.length; i++){
            if(choicesArray[i]>maxCount){
                maxCount = choicesArray[i];
            }
        }

        System.out.println(Arrays.toString(choicesArray));
        System.out.print("Mest populære valg er ");
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
