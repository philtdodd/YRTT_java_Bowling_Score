package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

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
    void BowlingScoreMixed() {
        Bowling bowling = new Bowling();

        assertEquals(142, bowling.calculateScore("5/ X -7 5/ 53 5/ 5/ 5/ 5/ 5/ 5"));
    }

    @Test
    void BowlingScorePartialGame1() {
        Bowling bowling = new Bowling();

        assertEquals(67, bowling.calculateScore("5/ X -7 5/ 53"));
    }

    @Test
    void BowlingScorePartialGame2() {
        Bowling bowling = new Bowling();

        assertEquals(64, bowling.calculateScore("5/ X -7 5/ 5"));
    }

    @Test
    void BowlingScorePartialGameEndInSpare() {
        Bowling bowling = new Bowling();

        assertEquals(69, bowling.calculateScore("5/ X -7 5/ 5/"));
    }

    @Test
    void BowlingScorePartialGameEndInStrike() {
        Bowling bowling = new Bowling();

        assertEquals(74, bowling.calculateScore("5/ X -7 5/ X"));
    }

    @Test
    void BowlingScoreMixedInvalid() {
        Bowling bowling = new Bowling();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bowling.calculateScore("5/ X -7 5/ 56 5/ 5/ 5/ 5/ 5/ 5");
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("Invalid Score Sheet"));
    }

    @Test
    void BowlingScoreMixedPartialStrikePlusOneBall() {
        Bowling bowling = new Bowling();

        assertEquals(84, bowling.calculateScore("5/ X -7 5/ X 5"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/tenpin-tests.csv", numLinesToSkip = 0)
    void BowlingScoreCSV(
            int expected, String input) {
        Bowling bowling = new Bowling();

        int actualValue = bowling.calculateScore(input);
        assertEquals(expected, actualValue);
    }

}
