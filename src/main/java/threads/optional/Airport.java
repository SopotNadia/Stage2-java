package threads.optional;

import java.util.Stack;

public class Airport {
    private String airportName;
    private Stack<Integer> listLines = new Stack();

    public Airport(String airportName) {
        this.airportName = airportName;
    }

    public void addIntoStack(Integer value) {
        listLines.push(value);
    }

    public Stack<Integer> getListLines() {
        return listLines;
    }

}
