package instructions;

import computer.InstructionCounter;
import computer.Memory;

public interface Instruction {
    public void execute(Memory memory, InstructionCounter instructionCounter);
}
