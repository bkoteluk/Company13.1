package pl.homework.lib;

public class Division {
    private String name;
    private int statCounter;

    public Division() {
    }

    public Division(String name, int statCounter) {
        this.name = name;
        this.statCounter = statCounter;
    }

    public int getStatCounter() {
        return statCounter;
    }

    public void setStatCounter(int statCounter) {
        this.statCounter = statCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + statCounter;
    }
}
