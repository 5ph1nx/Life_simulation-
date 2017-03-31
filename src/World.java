import java.util.Arrays;
import java.util.Random;

/**
 *
 * Created by Rohan Swaby on 3/29/17.
 */
public class World {
    private int DefaultCAPACITY = 5;
    private Entity[][] Grid;
    private int X = 0;
    private int Y = 0;
    private boolean attack;
    private int size;

    public World(int square_size){
        size = square_size;
       Grid = new Entity[square_size][square_size];
       //TODO: Initialize each entity--[Done]
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
                if (Grid[i][j] == null) {
                    Grid[i][j] = new Nothing();
                }
            }
        }
    }

    //public Entity DisplayEntityAtLocation(int x,int y){}
    public void Simulate(){
        //TODO: This is where everthing will happen.
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                //TODO: FIX THIS ISSUE NOW OR LATER Grid[i][j].move();
            }

        }
    }

    public void display_Grid(){
        //display_Grid();

        for (int i = 0; i < 5 ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 5; j++) {

                System.out.print(Grid[i][j].getType());
                System.out.print(" ");

            }
            System.out.print(" ]");
            System.out.println();

        }


    }//Display a snapshot of the Grid
    private char Direction(){
        char [] possible_moves = {'u','d','r','l'};
        return possible_moves[generateIndex(4)];
    }
    public void move(int i, int j){

        switch (Direction()){
            case 'u':
                this.Y = j+1;

                break;
            case 'd':
                this.Y = j - 1;
                if (this.Y < 0) this.Y=+1;
                break;
            case  'r':
                this.X = i + 1;
                break;
            case 'l':
                this.X = i - 1;
                if (this.X < 0) this.X=+1;
                break;
            default:
                this.X = i;
                this.Y = j;
                break;
        }


        ;
        if(CheckIfPositionValid(i,j)){
            Grid[X][Y] = Grid[i][j];

            //TODO: Do something with the attack variable
        }
        //TODO: if (attack)
           // Grid[X][Y].setHP(1);

    }
    private boolean CheckIfPositionValid(int i,int j){
        if(Grid[i][j].getType() == '@'){
            switch (Grid[X][Y].getType()){
                case '*': return true;
                case '.': return true;
                case '@': return false;
                case '&':
                    attack = true;
                    return true;
                default: break;
            }
        }
        else if (Grid[i][j].getType() == '&'){
            switch (Grid[X][Y].getType()){
                case '*':
                    attack = true;
                    return true;
                case '.': return true;
                case '@': return false;
                case '&': return false;
                default:
                    break;
            }
        }
        return false;



    }

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
