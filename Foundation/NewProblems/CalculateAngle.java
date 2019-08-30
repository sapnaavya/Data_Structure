/**
 * This code calculates the angle between hour hand and minute hand
 *  Reference: https://www.geeksforgeeks.org/calculate-angle-hour-hand-minute-hand/
 */
public class CalculateAngle {

    //function to calculate angle between hour hand and minute hand
    public static int calculateAngle(double h, double m) {
        //validate the input
        if(h < 0 || m < 0 || h > 12 || m > 60) {
            System.out.println("wrong input");
        }
        if(h == 12) {
            h = 0;
        }
        if(m == 60) {
            m = 0;
        }

        //calculate angle moved by hour  hand and minute hand with reference to 12:00
        int hour_angle = (int)(0.5 * (h * 60 + m));
        int min_angle = (int)(6 * m);

        //find the difference between two angles
        int angle = Math.abs(hour_angle - min_angle);
        
        //find smaller angle of two possible angle
        angle = Math.min(360 - angle, angle);

        return angle;
    }
    //main method
    public static void main(String args[]) {
        int angle = calculateAngle(9, 60);
        System.out.println(angle);
    }
}