import javax.swing.*;
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
    private int OnelifeCycle = 10;

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
                if (Grid[i][j] == null)
                    Grid[i][j] = new Nothing();
            }
        }
    }

    //public Entity DisplayEntityAtLocation(int x,int y){}
    public void Simulate(){
        int i;
        int j;
        int growRandomPlant = 0;
        for (i = 0; i < size-1 ; i++) {
            for (j = 0; j < size-1; j++) {
                if((Grid[i][j].getType() == '&' || Grid[i][j].getType() == '@') && (X!=i && Y !=j))
                {
                    updateEntity(i,j);
                    move(i,j);
                }

            }
            growRandomPlant+=1;
            MakeRandomPlantsAppear(growRandomPlant);// random plan will only appear every 4 clocks
            //growRandomPlant = 0;
        }
    }

    public void RunLifeCycle(){
        Simulate();
        display_Grid();
    }

    private void MakeRandomPlantsAppear(int growRandomPlant) {

        if(growRandomPlant % 8 == 0) {
            int bound = size-1;
            int i = generateIndex(bound);
            int j = generateIndex(bound);
            if(Grid[i][j].getType() == '.' )
                Grid[i][j] = new plant();

        }
    }

    private void updateEntity(int i, int j) {
        CheckifLifeIsOver(i,j);
        reproduceIfPossible(i,j);
    }
    private void CheckifLifeIsOver(int i, int j){
        if(Grid[i][j].ShouldDie()){
            Grid[i][j] = new Nothing();
        }
    }
    private void reproduceIfPossible(int i,int j) {
        if (Grid[i][j].getType() == '@') {

            if (Grid[i][j].getAge() >= 8 && Grid[i][j].HP >= 6) {// reproduce after 8 life cycles
                int bornRigt = j + 1;
                int bornLeft = j - 1;

                if (isNothing(i, bornRigt))
                    Grid[i][bornRigt] = new Herbivore();
                else if (isNothing(i, bornLeft))
                    Grid[i][bornLeft] = new Herbivore();
            }

        }
        else if (Grid[i][j].getType() == '&'){

            if (Grid[i][j].getAge() >= 8) {// reproduce after 8 life cycles
                int bornRigt = j + 1;
                int bornLeft = j - 1;

                if (isNothing(i, bornRigt))//If reproduce to the Right if possible
                    Grid[i][bornRigt] = new Cornivore();
                else if (isNothing(i, bornLeft))// Reproduce to the Left is possible
                    Grid[i][bornLeft] = new Cornivore();
            }

        }
    }
    private boolean isNothing(int i, int j){
        if(Grid[i][j].getType() == '.')
            return true;
        return false;
    }



    public void display_Grid(){
        //display_Grid();

        for (int i = 0; i < size-1 ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < size-1; j++) {

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
                Y = j;
                X = i-1;
                break;
            case 'd':
                Y = j;
                X = i+1;
                break;
            case  'r':
                X = i;
                Y = j+1;
                break;
            case 'l':
                X = i;
                Y = j-1;
                break;
            default:
                break;
        }
        MakeBoundariesValid();
        if(CheckIfPositionValid(i,j)){
            //make the x and y coordinate valid if they are not
            //System.out.println("New output::");
            //System.out.printf("x: %d , y: %d%n", X,Y);
            Grid[X][Y] = Grid[i][j];
            Grid[X][Y].GrowOlder();
            //System.out.println();
            if(attack && Grid[X][Y].HP < 6) {
                //System.out.println("Increasing HP");
                Grid[X][Y].IncreaseHP();//will Increase Hp if it sees food
            }

           //System.out.print("new Entity: ");
           //System.out.println(Grid[X][Y]);
           //System.out.printf(" at(%d,%d)%n ",X ,Y );
           //System.out.print("Old Entity: ");
           //System.out.println(Grid[i][j]);
           Grid[i][j] = new Nothing();

            //System.out.println("after Swap");
            //System.out.printf("Entity: %s at position:(%d,%d)%n",Grid[i][j],i,j);



        }
        //TODO: if (attack)

    }
    private boolean CheckIfPositionValid(int i,int j){
        //TODO: Check coordinates and please make it work
        boolean check = false;
        if(Grid[i][j].getType() == '@'){
            switch (Grid[X][Y].getType()){
                case '*':
                    check =true;
                    attack = true;
                    break;
                case '.':
                    check =true;
                    attack = false;
                    break;
                case '@':
                    check =false;
                    attack = false;
                    break;
                case '&':
                    attack = false;
                    check = false;
                    break;
            }//end of switch
        }//end of condition
        else if (Grid[i][j].getType() == '&') {

            switch (Grid[X][Y].getType()) {
                case '*':
                    attack = false;
                    check = true;
                    break;
                case '.':
                    check = true;
                    attack = false;
                    break;
                case '@':
                    check = true;
                    attack = true;
                    break;
                case '&':
                    check = false;
                    attack = false;
                    break;
            }//end of switch
        }//end of condition

        return check;
        }// end of method

    private void MakeBoundariesValid(){
        if(X < 0)
            X+=1;
        if(X > size-1)
            X-=1;
        if(Y < 0)
            Y += 1;
        if(Y > size-1)
            Y -=1;
    }

    private int generateIndex(int bar){
        Random rando = new Random();
        return rando.nextInt(bar-1);
    }

}
