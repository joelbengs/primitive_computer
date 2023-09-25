package instructions;

import computer.InstructionCounter;
import computer.Memory;

public class Halt implements Instruction {

    @Override
    public void execute(Memory memory, InstructionCounter instructionCounter) {
        instructionCounter.halt();
    }
}
