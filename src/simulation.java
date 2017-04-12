
import java.util.Random;

/**
 * Software Design Lab
 *
 * Created by rohan on 3/26/2017.
 */
public class simulation {
    public static void main(String[] args) {

        //try
        //  {

        World Earth = new World(30);
        System.out.println("...@&@&@&@&@&@& [Start Cycle] @&@&@&@&@&@@&....");
        Earth.display_Grid();
        for (int i = 0; i < 30; i++) {
            System.out.println("Cycles: " + i);
            Earth.RunLifeCycle();

            //  }
            //} catch (Exception as )

            // {
            //System.out.println(as);
            //}

            //end of main function

        }
    }


    public static  int generateIndex(){
      Random rando = new Random();
      return rando.nextInt(5);
  }


  public static void MakeGrid(char[][] G, int size, char Plant, char Nothing){

      for (int i = 0; i <5; i++) {
          for (int j = 0; j < 5 ; j++) {
              G[i][j] = Nothing;
          }
          G[generateIndex()][generateIndex()] = Plant;
      }
  }



}
