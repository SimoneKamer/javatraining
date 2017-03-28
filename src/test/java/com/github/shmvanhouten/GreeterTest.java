package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreeterTest {

    public String text = "Appel";
    protected  String text2 = "Peer";
    String pakketje = "InhetPakket"; //package
    private String secret = "geheim";

    @Test
    public void itShouldGreetInEnglish() throws Exception {

        Greeter greeter = new EnglishGreeter();

        assertThat(
                greeter.greet("Marco"),
                is("Hello Marco"));

    }

    @Test
    public void itShouldGreetInDutch() throws Exception {

        Greeter greeter = new DutchGreeter();

        assertThat(
                greeter.greet("Marco"),
                is("Hallo Marco"));
    }
}
