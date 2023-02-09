package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {
    @Test
    void BowlingScoreMax() {
        Bowling bowling = new Bowling();

        assertEquals(300, bowling.calculateScore("X X X X X X X X X X X X"));
    }

    @Test
    void BowlingScoreAllSpares() {
        Bowling bowling = new Bowling();

        assertEquals(150, bowling.calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5"));
    }

    @Test
    void BowlingScoremixed() {
        Bowling bowling = new Bowling();

        assertEquals(142, bowling.calculateScore("5/ X -7 5/ 53 5/ 5/ 5/ 5/ 5/ 5"));
    }

    @Test
    void BowlingScorePartialGame() {
        Bowling bowling = new Bowling();

        assertEquals(142, bowling.calculateScore("5/ X -7 5/ 53"));
    }
}
