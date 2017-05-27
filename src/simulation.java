
import java.util.Random;
import java.util.Scanner;

/**
 * Software Design Lab
 *
 * Created by rohan on 3/26/2017.
 */
public class simulation {
    public static void main(String[] args) {
        World Earth2 = new World(10);
        Display GUI = new Display();
        Connector Control = new Connector(Earth2,GUI);
        Control.updater(Earth2);
        GUI.setVisible(true);


        Scanner input = new Scanner(System.in);
        int size;
        int iteration;
        System.out.println("How what size simulation Do you want? ");
        size = input.nextInt();
        System.out.println("How many Cycles Do you want in your simulation? ");
        iteration = input.nextInt();
        World Earth = new World(size);
        System.out.println("...@&@&@&@&@&@& [Start Cycle] @&@&@&@&@&@@&....");
        System.out.println();
        Earth.display_Grid();
        for (int i = 0; i < iteration; i++) {
            System.out.println("Cycles: " + i);
            Earth.RunLifeCycle();

        }
    }



}
