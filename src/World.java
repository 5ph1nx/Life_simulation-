import java.util.Arrays;
import java.util.Random;

/**
 *
 * Created by rue on 3/29/17.
 */
public class World {
    private int DefaultCAPACITY = 5;
    private Entity[][] Grid;

    public World(int square_size){
       Grid = new Entity[square_size][square_size];
       //TODO: Initialize each entity
        MakeGridWithAnimals(square_size);
        FillGridWithPlants(square_size);
        }

    public World(){
        Grid = new Entity[DefaultCAPACITY][DefaultCAPACITY];
        //Initialize each entity
        MakeGridWithAnimals(DefaultCAPACITY);
        FillGridWithPlants(DefaultCAPACITY);
    }
    private void MakeGridWithAnimals(int square_size2) {
        int i;
        for (i = 0; i < square_size2; i++) {
            Grid[generateIndex(square_size2)][generateIndex(square_size2)] = new Herbivore();//just test
            Grid[generateIndex(square_size2)][generateIndex(square_size2)] = new Cornivore();
            Grid[generateIndex(square_size2)][generateIndex(square_size2)] = new plant();

        }
    }
    private void FillGridWithPlants(int square_size2) {

        int i;
        for (i = 0; i < square_size2; i++) {
            for (int j = 0; j < square_size2; j++) {
                //if ((Grid[i][j].getType() != '@') || (Grid[i][j].getType() != '&') || (Grid[i][j].getType() != '*'))
                if (Grid[i][j] == null)
                {
                    Grid[i][j] = new Nothing();
                }
            }
        }
    }

    //public Entity DisplayEntityAtLocation(int x,int y){}
    public void move(){}//will move Elements on the Grid
    public void display_Grid(){
        //display_Grid();
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Grid[i][j].getType());

            }
            System.out.println();

        }

    }//Display a snapshot of the Grid

    private int generateIndex(int bar){
        Random rando = new Random();
        return rando.nextInt(bar);
    }
    private void printRow(Entity[] row) {
        for (Entity[] i : Grid) {
            System.out.print(Arrays.toString(i));
            System.out.print("\t");
        }
        System.out.println();
    }

    private void Display_Grid(){
        for(Entity [] row : Grid) printRow(row);
    }

}
