package instructions;

import computer.Address;
import computer.InstructionCounter;
import computer.Memory;

public class Jump implements Instruction {
    private Address address;

    public Jump(Address address) {
        this.address = address;
    }

    public void execute(Memory memory, InstructionCounter instructionCounter) {
        instructionCounter.set(address);
    }
}
