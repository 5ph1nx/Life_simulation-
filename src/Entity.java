

/**
 *
 *
 *
 * Created by rohan on 3/25/2017.
 */
public class Entity {

    protected int HP = 3;//Initial HP points
    protected int HPLimit = 6;//Animals will not eat if limit is reached
    protected  char type;
    protected int x;
    protected int y;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Entity() {
        this(0,0);
    }

    public char getType(){
        return type;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    /**public int[] Coord(){
        int[] coord = {x,y};
        return coord;
    }*/
    public void setHP(int Hp){
        this.HP = Hp;
    }
    public void  move(int st){
        //TODO move will calculate how much the object will step in the 2D Grid

    }




}
