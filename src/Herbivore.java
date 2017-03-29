
import java.util.Random;

/**
 *
 *
 * Created by Rohan Swaby on 3/25/2017.
 */
public class Herbivore extends Entity {
   private final int maxGrowth = 8;


    public Herbivore() {
        super();
        type = '@';
    }
    public Herbivore reproduce(){
        // TODO: implement the condition for the energy level
        return new Herbivore();
    }
    public Cornivore attact(Cornivore prey){
         return new Cornivore();
    }
    public int  move (){
        //TODO IMPLEMENT
        Random rand = new Random();
        return rand.nextInt(6);
    }
    public void Feed(char plant){
        //TODO: herbivores eat plants to survive
        switch (plant){
            case '*':
                HP += 1;
                break;
            case '.':
                break;
        }
    }

}
