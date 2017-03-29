import javafx.scene.control.RadioMenuItem;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by rohan on 3/26/2017.
 */
public class simulation {
    public static void main(String[] args) {
        /**
        ///TODO: Create an array of objects instead of characters.
        char [][] Grid = new char[5][5];
        char plants = '*';
        char empty = '.';
        Herbivore Rohan = new Herbivore(8,'@');
        int move = Rohan.move();
        MakeGrid(Grid,5,plants,empty);
        Display_Grid(Grid);
         */


       /**
        * int[] H = new int[2];
        * Entity[][] Grid = new Entity[8][9];
        Grid[0][0] = new plant();
        Grid[0][1] = new Herbivore();
        System.out.println(Grid[0][0].getType());
        System.out.println(Grid[0][1].getType());
        H = Grid[0][1].Coord();
        System.out.println(H[0]);
        System.out.println(H[0]);
        */


        }







  public static  int generateIndex(){
      Random rando = new Random();
      return rando.nextInt(5);
  }


  public static void MakeGrid(char[][] G, int size,
                              char Plant, char Nothing){

      for (int i = 0; i <5; i++) {
          for (int j = 0; j < 5 ; j++) {
              G[i][j] = Nothing;
          }
          G[generateIndex()][generateIndex()] = Plant;
      }
  }




    public static void printRow(char[] row) {
        for (char i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void Display_Grid(char [][] Grid){
        for(char [] row : Grid) printRow(row);
    }



}
