
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
        setGrid(new Entity[square_size][square_size]);

       //TODO: Initialize each entity--[Done]
        MakeGridWithAnimals(square_size);
        FillGridWithPlants(square_size);
        }

    public World(){
        setGrid(new Entity[DefaultCAPACITY][DefaultCAPACITY]);
        //Initialize each entity
        MakeGridWithAnimals(DefaultCAPACITY);
        FillGridWithPlants(DefaultCAPACITY);
    }
    private void MakeGridWithAnimals(int square_size2) {
        int i;
        for (i = 0; i < square_size2; i++) {
            getGrid()[generateIndex(square_size2)][generateIndex(square_size2)] = new Herbivore();//just test
            getGrid()[generateIndex(square_size2)][generateIndex(square_size2)] = new Cornivore();
            getGrid()[generateIndex(square_size2)][generateIndex(square_size2)] = new plant();
        }
    }
    private void FillGridWithPlants(int square_size2) {
        int i;
        for (i = 0; i < square_size2; i++) {
            for (int j = 0; j < square_size2; j++) {
                if (getGrid()[i][j] == null)
                    getGrid()[i][j] = new Nothing();
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
                if((getGrid()[i][j].getType() == '&' || getGrid()[i][j].getType() == '@') && (X!=i && Y !=j))
                {
                    updateEntity(i,j);
                    getGrid()[i][j].move(getGrid(),size,i,j);//check speed and call the move function more than once
                    //need to add an attribute called speed.
                }

            }
            growRandomPlant+=1;
            MakeRandomPlantsAppear(growRandomPlant);// random plan will only appear every 4 clocks
            //growRandomPlant = 0;
        }
    }


    public void Simulate2(){
        //One Cycle = 5 iterations
        int i;
        int j;
        int growRandomPlant = 0;
        for (i = 0; i < size-1; i++) {
            for (j = 0; j < size-1; j++) {
                if((getGrid()[i][j].getType() == '&' || getGrid()[i][j].getType() == '@') && (X!=i && Y !=j))
                {
                    updateEntity(i,j);
                    getGrid()[i][j].move(getGrid(),size,i,j);//check speed and call the move function more than once
                    //need to add an attribute called speed.
                }

            }
            growRandomPlant+=1;
            MakeRandomPlantsAppear(growRandomPlant);// random plan will only appear every 4 clocks
            //growRandomPlant = 0;
        }
    }



    public void RunLifeCycle(){
        Simulate();
        //display_Grid();
    }

    private void MakeRandomPlantsAppear(int growRandomPlant) {

        if(growRandomPlant % 8 == 0) {
            int bound = size-1;
            int i = generateIndex(bound);
            int j = generateIndex(bound);
            if(getGrid()[i][j].getType() == '.' )
                getGrid()[i][j] = new plant();

        }
    }

    private void updateEntity(int i, int j) {
        getGrid()[i][j].CheckifLifeIsOver(getGrid(),i,j);
        getGrid()[i][j].reproduceIfPossible(getGrid(),i,j);
    }
//    private void CheckifLifeIsOver(int i, int j){
//        if(Grid[i][j].ShouldDie()){
//            Grid[i][j] = new Nothing();
//        }
//    }


    private int generateIndex(int bar){
        Random rando = new Random();
        return rando.nextInt(bar-1);
    }

    public void display_Grid() {
        //display_Grid();

        for (int i = 0; i < size - 1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < size - 1; j++) {

                System.out.print(getGrid()[i][j].getType());
                System.out.print(" ");

            }
            System.out.print(" ]");
            System.out.println();

        }
    }


    public Entity[][] getGrid() {
        return Grid;
    }

    public void setGrid(Entity[][] grid) {
        Grid = grid;
    }
}
