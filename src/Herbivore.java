import java.util.ConcurrentModificationException;
import java.util.Random;

/**
 * Created by Rohan Swaby on 3/25/2017.
 */
public class Herbivore extends Animal {
   private final int maxGrowth = 8;
    private int grow = 0;
    private final char type1 = '@';


    public Herbivore(int ageLimit, char t) {
        super(ageLimit, t);
    }
    public Herbivore reproduce(){
        //Reproduce if right age limit and Energy level is above average
        // TODO: implement the condition for the energy level
        return new Herbivore(maxGrowth,type1);
    }

    public Cornivore attact(Cornivore prey){
         return new Cornivore(30,'d');
    }
    public char getType1(){
        return type1;

    }


    public int  move (){
        //TODO IMPLEMENT
        Random rand = new Random();
        return rand.nextInt(6);
    }

    public void Feed(char plant){
        //TODO: herbivores eat plants to survive
    }








}
