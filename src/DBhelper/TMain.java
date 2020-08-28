package DBhelper;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import DBhelper.Frame.MainFrame;


public class TMain {
    public static void main(String[] args) {
        Model model = new Model();
        Cantrol control = new Cantrol(model);
        MainFrame view = new MainFrame(model, control);
        
        


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //GraphicsDevice gd = ge.getDefaultScreenDevice();
        //view.setUndecorated(true);
        //gd.setFullScreenWindow(view);

        view.setSize(1500,750);
        view.setVisible(true);
    }
}