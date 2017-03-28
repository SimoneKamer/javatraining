package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisTest {


    @Test
    public void itShouldSayZeroFifteen() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(0, 1),
                is("zero - fifteen"));

    }

    @Test
    public void itShouldSayZeroThirty() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(0, 2),
                is("zero - thirty"));

    }

    @Test
    public void itShouldSayZeroAll() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(0, 0),
                is("zero - all"));

    }

    @Test
    public void itShouldSayDeuce() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(3, 3),
                is("deuce"));

    }

    @Test
    public void itShouldSayAdvantagePlayer1() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(4, 3),
                is("Advantage Player 1"));

    }

    @Test
    public void itShouldSayAdvantagePlayer2() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(4, 5),
                is("Advantage Player 2"));

    }

    @Test
    public void itShouldSayWinForPlayer1() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(4, 0),
                is("Win For Player 1"));

    }
    @Test
    public void itShouldSayZeroForty() throws Exception {

        TennisGame game = new TennisGame();

        assertThat(
                game.score(0, 3),
                is("zero - forty"));

    }

}
