package computer;

public class InstructionCounter {
    public int currentInstruction = 0;
    public boolean running = false;

    public void increment() {
        currentInstruction++;
    }

    public void set(int destination) {
        currentInstruction = destination;
    }

    public void halt() {
        running = false;
    }

    public void start() {
        running = true;
    }
}
