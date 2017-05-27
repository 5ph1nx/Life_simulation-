
import java.util.Random;

/**
 *
 *
 * Created by Rohan Swaby on 3/25/2017.
 */
public class Herbivore extends Entity {
    private int X;
    private int Y;
    public Herbivore() {
        super();
        this.type = '@';
    }

    @Override
    public String toString(){
        return "@";
    }


}
