package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bowling {
    private static final String STRIKE = "X";
    private static final String SPARE = "/";
    private static final String NOSCORE = "-";

    public int calculateScore(String scoreSheet) {
        Integer totalScore = 0;

        List<Integer> balls = new ArrayList<Integer>();
        // break scoresheet into frames
        String[] frames = scoreSheet.split(" ");

        // iterate over the frames
        for (String frame : frames) {
            // create new array of scores from score sheet
            if (frame.matches(STRIKE)) {
                balls.add(10);
                balls.add(0);
            } else if (frame.length() == 2 && frame.substring(1, 2).matches(SPARE)) {
                Integer ball1 = Integer.parseInt(frame.substring(0, 1));
                balls.add(ball1);
                balls.add(10 - ball1);
            }else{
                balls.add(Integer.parseInt(frame.substring(0,1)));
                if (frame.length() == 2){
                    balls.add(Integer.parseInt(frame.substring(1,2)));
                }
            }


        }

        // iterate over scores adding the scores up.
        for (Integer i = 0; i < 20; ) {
            totalScore += balls.get(i);
            if (balls.get(i) == 10) {
                totalScore += balls.get(i + 1) + balls.get(i + 2);
                i += 1;
            } else if ((i % 2 == 0) && (balls.get(i) + balls.get(i + 1)) == 10){
                totalScore += balls.get(i+2);
            }

            i++;
        }

        return totalScore;
    }
}
