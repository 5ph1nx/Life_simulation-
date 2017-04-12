

/**
 *
 * Created by rohan on 3/25/2017.
 */
public abstract class Entity {

    protected int HP = 3;//Initial HP points
    protected int HPLimit = 5;//Animals will not eat if limit is reached
    protected  char type;
    protected  int age = 1;
    protected  int ageLimit = 8;
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


    public void IncreaseHP(){
        //System.out.println("Increasing This: :");
        //System.out.println(this);
        if(this.getType() == '@' || this.getType() == '&')
            this.HP += 1;
    }
    public int getHP(){
        return HP;
    }
    public int getHPLimit(){
        return HPLimit;
    }

    public boolean ShouldDie(){
        //System.out.print("This: ");
        //System.out.println(this);
        if(this.getType() == '@' || this.getType() == '&'){
            if(this.age >= this.ageLimit) {
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







}
