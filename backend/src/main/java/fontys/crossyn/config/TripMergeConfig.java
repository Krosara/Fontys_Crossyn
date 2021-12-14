package fontys.crossyn.config;

import java.util.HashMap;

public class TripMergeConfig {

    //POINTS

    public final int[] roadTypePoints = {
            -10,
            -3,
            -2,
            -2,
            2
    };  //last packet

    public final int ignitionFalsePoints = -2;  //last packet of trip1
    public final int ignitionTruePoints = -1;  //first packet of trip2

    public final int speedLimitLowPoints = 1; //last packet of trip1
    public final int speedLimitHighPoints = -1; //last packet of trip1

    public final int startingSpeedLowPoints = 1; //first packet of trip2
    public final int startingSpeedHighPoints = -2; //first packet of trip2

    public final int endingSpeedLowPoints = 2; //last packet of trip1
    public final int endingSpeedHighPoints = -1; //last packet of trip1


    //LIMITS

    public final int speedLimit = 50;
    public final int stoppingSpeed = 30;
    public final int startingSpeed = 10;
    public final int neededPoints = 0;

    public TripMergeConfig(){

    }

}
