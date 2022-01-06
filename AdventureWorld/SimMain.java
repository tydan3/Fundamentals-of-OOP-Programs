// this is the class that runs the simulation

public class SimMain {
    public static void main(String[] args) {
        SimFrame frame = new SimFrame();

        frame.add(50, Item.class);
        frame.add(5, Spider.class);
        frame.add(5, Adventurer.class);
        frame.add(10, Key.class);

        frame.start();
    }
}