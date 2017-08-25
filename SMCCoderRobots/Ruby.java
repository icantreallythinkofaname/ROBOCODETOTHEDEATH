package SMCCoderRobots;
import robocode.*;
//import Math.;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Ruby - a robot by (your name here)
 */
public class Ruby extends Robot
{
	/**
	 * run: Ruby's default behavior
	 */
	
	//Good at dodging and wasting enemy's bullets, disabling them, but
	//needs to shoot better
	double direction = 1;
	boolean radarturning = true;
	boolean randomturning = true;
	
	int radarangle = 360;
	public void run() {
	
		
		int margin = 200;
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.red,Color.black, Color.white, Color.red); // body,gun,radar
		
		// setAdjustGunForRobotTurn
		//setAdjustRadarForGunTurn
		
		setAdjustRadarForRobotTurn(true);

		// Robot main loop
		//turnRadarRight(360);
		
		while(true) {
			turnRadarRight(radarangle);
			// Replace the next 4 lines with any behavior you would like
			//ahead(100);
			//if(radarturning) {
				
			//}
			//back(100);
			//turnGunRight(Math.random()*360);
			
			// make it move oppisite to opponents gun
			
			//System.out.println(getBearing());
			
			if(randomturning) {
				//turnRight(Math.random()*180*direction);
			}
			// use distance from wall as range to prevent ruby from hitting wall
			// first, i need location of ruby, then dimesions of border
			//getX()
			//getY()
			//getSentryBorderSize()  = 100
			ahead(Math.random()*175);//(getBattleFieldHeight()) );
			
			if((getX() > getBattleFieldWidth() - margin) || (getX() < margin) || (getY() > getBattleFieldHeight() - margin) || (getY() < margin) ) {
				//turnRight(e.getBearing());
				//direction = -1;
				//System.out.println("too close!");
			} 
			/*else {
				direction = direction*direction;
			}*/
			//System.out.println(Math.random()*(getBattleFieldHeight()-getY()) );
			//System.out.println(getX());
			//System.out.println(Math.random()*360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
		radarangle = 280;
		
		//radarturning = false;
		setAdjustRadarForRobotTurn(true);
		
		setAdjustGunForRobotTurn(true);
		//setAdjustGunForRadarTurn(true);
		//
		turnRight(e.getBearing() + 90);
		//direction = .5;
		
		ahead(200);
		back(200);

		
//
		turnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
		turnGunRight(getHeading() - getRadarHeading() + e.getBearing());
		
		//turnGunRight(e.getBearing());
		//System.out.println(Math.random());
		//turnRight(
		/*for(int i = 0; i < 360; i=i+30) {
			turnRight(i);
			back(i);
		}*/
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		//fireBullet(2);
		/*for(int i = 0; i < 360; i=i+30) {
			turnLeft(i);
			back(i);
		}*/
		
		direction = -1;
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		//back(20);
		//radarturning = false;
		turnRight(e.getBearing());
		//randomturning = false;
		//direction = 0;
		//back(Math.random()*(getBattleFieldWidth()+150));
	}	
}
