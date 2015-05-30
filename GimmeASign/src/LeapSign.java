import java.io.IOException;

import com.leapmotion.leap.Controller;

public class LeapSign {	
	public static void main(String[] args) {
		//create new controller and detector
		Detector listener = new Detector();
		Controller controller = new Controller();
		
		listener.init(controller);
		listener.connected(controller);
		listener.detect(controller);
		
		//allows the listener to receive events from the controller
		//by adding the listener
		controller.addListener(listener);
		 // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);
	}
}

