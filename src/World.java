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
                if (Grid[i][j] == null)
                    Grid[i][j] = new Nothing();
            }
        }
    }

    //public Entity DisplayEntityAtLocation(int x,int y){}
    public void Simulate(){
        //TODO: This is where everthing will happen.
        int i;
        int j;
        for (i = 0; i < size ; i++) {
            for (j = 0; j < size ; j++) {
                //TODO: how will this work
                //TODO: WHENEVER I MOVE I NEED TO REPLACE THE SPACE WITH NOTHING
                if((Grid[i][j].getType() == '@') || (Grid[i][j].getType()== '&')){
                    move(i,j);
                }

            }
            System.out.println("outter thisplay");
            display_Grid();
            System.out.println("");
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
        return possible_moves[generateIndex(size-1)];
    }
    public void move(int i, int j){
        char D = Direction();
        //System.out.println(D);
        //System.out.printf("x: %d , y: %d%n", i,j);

        switch (D){
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
            Grid[i][j] = new Nothing();

            //TODO: Do something with the attack variable
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
                    break;
                case '.':
                    check =true;
                    break;
                case '@':
                    check =false;
                    break;
                case '&':
                    attack = true;
                    check = true;
                    break;
                default:
                    break;
            }//end of switch
        }//end of condition
        else if (Grid[i][j].getType() == '&') {

            switch (Grid[X][Y].getType()) {
                case '*':
                    attack = true;
                    check = true;
                    break;
                case '.':
                    check = true;
                    break;
                case '@':
                    check = false;
                    break;
                case '&':
                    check = false;
                    break;
                default:
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
        return rando.nextInt(bar);
    }

}
