package instructions;

import computer.InstructionCounter;
import computer.Memory;

public class Jump implements Instruction {
    private int destination;

    public Jump(int destination) {
        this.destination = destination;
    }

    public void execute(Memory memory, InstructionCounter instructionCounter) {
        instructionCounter.set(destination);
    }
}
