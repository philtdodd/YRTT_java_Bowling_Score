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

        // remove spaces and NOSCORE's for 0
        // break scoresheet into frames
        String frames = scoreSheet.replace(" ", "").replace("-", "0");

        // iterate over the frames
        for (Integer i = 0; i < frames.length(); i++) {
            // create new array of scores from score sheet
            if (frames.substring(i, i + 1).matches(STRIKE)) {
                balls.add(10);
                balls.add(0);
            } else if (frames.length() >= i + 2 &&
                    frames.substring(i + 1, i + 2).matches(SPARE)) {
                Integer ball1 = Integer.parseInt(frames.substring(i, i + 1).substring(0, 1));
                balls.add(ball1);
                balls.add(10 - ball1);
                i++;
            } else {
                balls.add(Integer.parseInt(frames.substring(i, i + 1)));
            }
        }

        // iterate over scores adding the scores up.
        Integer max = 20;
        if (balls.size() < 20)
            max = balls.size();

        for (Integer i = 0; (i < max); ) {
            totalScore += balls.get(i);
            if (balls.get(i) == 10) {
                if (balls.get(i + 2) == 10)
                    totalScore += balls.get(i + 2) + balls.get(i + 4);
                else
                    totalScore += balls.get(i + 2) + balls.get(i + 3);
                i += 1;
            } else if ((i % 2 == 0) && (i + 2 <= balls.size()) &&
                    (balls.get(i) + balls.get(i + 1)) == 10) {
                totalScore += balls.get(i + 2);
            }

            i++;
        }

        return totalScore;
    }
}
