/**
 * Created by rohan on 4/30/2017.
 */
public interface Helpers {

    public char Direction();
    public int generateIndex(int bar);
    public void move(Entity Grid[][],int size,int x, int j);
    public void MakeBoundariesValid(int size);
    public int getHPLimit();
    public boolean ShouldDie();
    public void IncreaseHP();
    public void reproduceIfPossible(Entity Grid[][],int i,int j);
    public void CheckifLifeIsOver(Entity Grid[][],int i, int j);
}
