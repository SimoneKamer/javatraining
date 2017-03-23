package com.github.shmvanhouten;

public abstract class AbstractGreeter implements Greeter {

    public final String greet(String name) {
        return getLocalizedGreetWord()+ " " + name;
    }

    protected abstract String getLocalizedGreetWord();


}
