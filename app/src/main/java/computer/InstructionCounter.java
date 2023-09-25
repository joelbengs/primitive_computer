package computer;

public class InstructionCounter {
    private int currentInstruction = 0;
    private boolean running = false;

    public int getCurrentInstruction() {
        return currentInstruction;
    }

    public boolean isRunning() {
        return running;
    }

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
