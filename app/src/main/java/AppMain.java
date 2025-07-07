import UI.Buttons;
import UI.Frame;

public class AppMain {
    public static void main(String args[]){

        Frame frame = new Frame("Calculator");
        new Buttons(frame.getFrame());
        frame.getFrame().setVisible(true);     
    }
}