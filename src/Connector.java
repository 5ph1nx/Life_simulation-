import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${Rohan_Swaby} on 5/26/2017.
 */
//This class will be the bridge between the Display and the simulation
public class Connector {

    private World Sim;
    private Display GUI;
    private Check;

    public Connector (World Sim, Display GUI) {
        this.GUI = GUI;
        this.Sim = Sim;
        this.GUI.addNextButtonListener(event -> {
            GUI.refreshGui();
            int i = 1;
            while (i <= GUI.getCycle()) {
                Sim.RunLifeCycle();//make cylce simulate by 1
                System.out.println("Cycle#: ");
                Sim.display_Grid();
                //This is where we want ot update the simulation
                i++;
            }
            updater(Sim);
        });//event handler
    }


    public void updater(World Simulation) {


        for (int x=0; x<Simulation.getGrid().length; x++) {
            for (int y=0; y<Simulation.getGrid().length; y++) {
                if (Simulation.getGrid()[x][y] != null){
                    //void updateGUI(int row, int col, String name)
                    GUI.updateGUI(x, y, Simulation.getGrid()[y][y].toString());
                }
            }
        }
    }
//    class Listener implements ActionListener {
//        public void actionPerformed (ActionEvent e) {
//            GUI.refreshGui();
//            int i = 1;
//            while (i <= GUI.getCycle()) {
//
//                Sim.RunLifeCycle();//make cylce simulate by 1
//                i++;
//            }
//            updater(Sim);
//
//        }

    }

