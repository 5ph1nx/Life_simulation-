/**
 * Created by rohan on 3/25/2017.
 */
public class Animal {

    protected int age;
    protected int HP;
    protected int steps;
    protected final int ageLimit;
    protected final char type;
    protected boolean status;
    protected int averageEnergy = 3;
    protected int ReproductionBar = 6;
    public Animal(int ageLimit, char t){
        this.ageLimit = ageLimit;
        this.type = t;
    }
    public  void setAge(int age){
        this.age = age;
    }
    public void setHP(int Hp){
        this.HP = Hp;
    }
    public int getAge(){
        return age;
    }
    public int getHP(){
        return age;
    }
    public void  move(int st){
        //TODO move will calculate how much the object will step in the 2D Grid

    }
    public boolean getStatus(){
        return status;
    }



}
