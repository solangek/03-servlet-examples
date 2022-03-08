package demoservlets;

/**
 * a sample class to hold some data to be used by servlets
 */
public class Dummy {

    private int dummyInt;
    private String name;

    public Dummy(int i) {
        dummyInt = i;
        name = "Dummy number " + Integer.toString(i);
    }
    public int getDummyInt() {
        return dummyInt;
    }

    public void setDummyInt(int dummyInt) {
        this.dummyInt = dummyInt;
    }

    public String getName() {
        return name;
    }
}