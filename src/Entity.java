import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.Random;

/**
 *
 * Created by rohan on 3/25/2017.
 */
public abstract class Entity implements Helpers{

    protected int HP = 3;//Initial HP points
    protected int HPLimit = 5;//Animals will not eat if limit is reached
    protected  char type;
    protected  int age = 1;
    protected  int ageLimit = 8;
    private int X;
    private int Y;
    boolean attack;

    public Entity(int x, int y){
        this.X = x;
        this.X = y;
    }

    public Entity() {
        this(0,0);
    }

    public char getType(){
        return type;
    }

    @Override
    public void IncreaseHP(){
        //System.out.println("Increasing This: :");
        //System.out.println(this);
        if(this.getType() == '@' || this.getType() == '&')
            this.HP += 1;
    }
    public int getHP(){
        return HP;
    }
    @Override
    public int getHPLimit(){
        return HPLimit;
    }
    @Override
    public boolean ShouldDie(){
        if(this.getType() == '@' || this.getType() == '&'){
            if(this.age >= this.ageLimit) {
               // System.out.println("Entity Died");
                return true;
            }
        }

        return false;
    }
    public void GrowOlder(){
        age+=1;
    }

    public int getAge(){
        return age;
    }


    @Override
    public char Direction(){
        char [] possible_moves = {'u','d','r','l'};
        return possible_moves[generateIndex(4)];
    }
    @Override
    public int generateIndex(int bar){
        Random rando = new Random();
        return rando.nextInt(bar-1);
    }

    @Override
    public void move(Entity Grid[][],int size,int i, int j){

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
        MakeBoundariesValid(size);
        if(CheckIfPositionValid(Grid ,i,j)){
            //make the x and y coordinate valid if they are not
            //System.out.println("New output::");
            //System.out.printf("x: %d , y: %d%n", X,Y);
            Grid[X][Y] = Grid[i][j];
            Grid[Y][X].GrowOlder();
            //System.out.println();
            if(attack && Grid[X][Y].HP < 6) {
                //System.out.println("Increasing HP");
                Grid[X][Y].IncreaseHP();//will Increase Hp if it sees food
            }

//            System.out.print("new Entity: ");
//            System.out.println(Grid[X][Y]);
//            System.out.printf(" at(%d,%d)%n ",X ,Y );
//            System.out.print("Old Entity: ");
//            System.out.println(Grid[i][j]);
//            System.out.println("at ("+i+" , "+j+")");
            Grid[i][j] = new Nothing();

            //System.out.println("after Swap");
            //System.out.printf("Entity: %s at position:(%d,%d)%n",Grid[i][j],i,j);

        }


    } // end of move sequence

    @Override
    public void MakeBoundariesValid(int size){
        if(X < 0)
            X+=1;
        if(X > size-1)
            X-=1;
        if(Y < 0)
            Y += 1;
        if(Y > size-1)
            Y -=1;
    }

    private boolean CheckIfPositionValid(Entity Grid[][],int i,int j){
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

    @Override
    public void reproduceIfPossible(Entity Grid[][],int i,int j) {
        if (Grid[i][j].getType() == '@') {

            if (Grid[i][j].getAge() >= 8 && Grid[i][j].HP >= 6) {// reproduce after 8 life cycles
                int bornRigt = j + 1;
                int bornLeft = j - 1;

                if (isNothing(Grid, i, bornRigt))
                    Grid[i][bornRigt] = new Herbivore();
                else if (isNothing(Grid, i, bornLeft))
                    Grid[i][bornLeft] = new Herbivore();
            }

        }
        else if (Grid[i][j].getType() == '&'){

            if (Grid[i][j].getAge() >= 8) {// reproduce after 8 life cycles
                int bornRigt = j + 1;
                int bornLeft = j - 1;

                if (isNothing(Grid,i, bornRigt)) {//If reproduce to the Right if possible
                    Grid[i][bornRigt] = new Cornivore();
                    System.out.println("Carnivore made at"+i+","+bornRigt);
                }
                else if (isNothing(Grid, i, bornLeft)){// Reproduce to the Left is possible
                    Grid[i][bornLeft] = new Cornivore();
                    System.out.println("Carnivore made at"+i+","+bornLeft);
                }
            }

        }
    }
    @Override
    public void CheckifLifeIsOver(Entity Grid[][],int i, int j){
        if(Grid[i][j].ShouldDie()){
            Grid[i][j] = new Nothing();
        }
    }
    private boolean isNothing(Entity Grid[][], int i, int j){
        if(Grid[i][j].getType() == '.')
            return true;
        return false;
    }

    public int getX(){ return X;}
    public void setX(int X){ this.X = X;}

    public int getY(){ return this.Y;}
    public void setY(int Y) {this.Y = Y;}







}
