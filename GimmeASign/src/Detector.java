import com.leapmotion.leap.*;

public class Detector extends Listener {
	public void init(Controller controller) {
        System.out.println("Initialized");
    }
	
	public void connected(Controller controller) {
		System.out.println("Controller connected");
		//since the controller needs time to connect, 
		//prints out when it is connected
		/*controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_INVALID);*/
	}
	
	public void disconnected(Controller controller){
        System.out.println("Disconnected");
        //tells if the controller is disconnected
	}
	
	public void detect(Controller controller){
		//detects what is happening with your arm,
		//your hand, your wrist, position, direction, etc. 
		
		//evaluates each frame, and gets specific information
		Frame frame = controller.frame();
		//gets the most recent frame
		Frame previousFrame = controller.frame(1);
		//gets the previous frame
		
		//get hands
		for(Hand hand : frame.hands()) {
			Vector palmPosition = hand.palmPosition(); 
			
		System.out.println("The distance of your hand from the Leap Motion Controller is " 
        + palmPosition + "\n");
			//finds the distance of the palm from the leap motion controller
			
			float handRotation = hand.rotationAngle(previousFrame); 
			//finds the angle of rotation of the hand since its last orientation
			//since the previous frame
		System.out.println("The rotation of your hand is " + handRotation + "\n");
			Vector handDirection = hand.direction();
		System.out.println( "The direction of your hand is " + handDirection + "\n");
			//Vector normal = hand.palmNormal();
			//normal is a vector perpendicular to the palm of the hand
			//if your hand is flat and your palm is pointed downwards
			
			float handPitch = hand.direction().pitch(); 
			//pitch is rotation around the x axis
			float handYaw = hand.direction().yaw();
			//yaw is rotation around the y axis
			float handRoll = hand.direction().roll();
			//roll is rotation around the z axis
		System.out.println("Pitch is the rotation of your hand around the x-axis."
				+ "The pitch of your hand is " + handPitch);
		System.out.println("Yaw is the rotation of your hand around the y-axis."
				+ "The yaw of your hand is " + handYaw);
		System.out.println("Roll is the rotation of your hand around the z-axis."
				+ "The roll of your hand is " + handRoll);
			frame.hands().count(); //counts the number of hands in this frame
			
			String handType;
			if(hand.isLeft()){    //returns true if left hand
				handType = "left";
			}
			else if(hand.isRight()){ //returns true if right hand
				handType = "right";
			}
			
			//get arm
			Arm arm = hand.arm(); //gets the arm to which this hand is attached
			Vector armDirection = arm.direction();
			//finds the direction in which this arm is pointed
			Vector wristPosition = arm.wristPosition(); 
			//finds the coordinates of the wrist
			Vector elbowPosition = arm.elbowPosition();
			//finds the coordinates of the elbow
			System.out.println("The direction of your arm is " + armDirection
					+ ". The position of your wrist is " + wristPosition 
					+ ". The position of your elbow is " + elbowPosition);
			
			//get fingers
			for(Finger finger : hand.fingers()) {
				Vector fingerDirection = finger.direction();
				//finds the direction in which this finger is pointed
				System.out.println("Your finger is pointed in this direction " + fingerDirection);
				
				if (finger.isExtended()){
					//determines if this finger is extended
					System.out.println("Your fingers are extended.");
				}
				else{
					//if the fingers aren't extended
					System.out.println("Your fingers are not extended.");
				}
			}
		}
	}

		
	/*	GestureList gestures = frame.gestures();
        for (int i = 0; i < gestures.count(); i++) {
            Gesture gesture = gestures.get(i);

            switch (gesture.type()) {
            case TYPE_CIRCLE:
                CircleGesture circle = new CircleGesture(gesture);
                //creates a circle type
                break;
            case TYPE_SWIPE:
            	//creates swipe type
                SwipeGesture swipe = new SwipeGesture(gesture);
                Vector swipePosition = swipe.position();
                Vector swipeDireciton = swipe.direction();
                float swipeSpeed = swipe.speed();
                break;
            case TYPE_SCREEN_TAP:
                ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                Vector screenTapPosition = screenTap.position();
                Vector screenTapDirection = screenTap.direction();
                //creates screen tap type
            	break;
            case TYPE_KEY_TAP:
                KeyTapGesture keyTap = new KeyTapGesture(gesture);
                //creates key tap type
                Vector keyTapPosition = keyTap.position();
                Vector keyTapDirection = keyTap.direction();
            	break;
            }
        } */
				
	}
	


/* class LeapMotionSign {	
	public static void main(String[] args) {
		//create new controller and sinesign
		Detector listener = new Detector();
		Controller controller = new Controller();
		
		//allows the listener to receive events from the controller
		//by adding the listener
		controller.addListener(listener);
				
	}
}
*/

