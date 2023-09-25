package instructions;

import computer.Address;
import computer.InstructionCounter;
import computer.Memory;
import computer.Operand;

public class JumpEq implements Instruction {
    private Operand left, right;
    private Address destination;

    public JumpEq(Operand left, Operand right, Address destination) {
        this.left = left;
        this.right = right;
        this.destination = destination;
    }

    @Override
    public void execute(Memory memory, InstructionCounter instructionCounter) {
        var leftWord = left.getWord(memory);
        var rightWord = right.getWord(memory);
        if (leftWord.equals(rightWord)) {
            instructionCounter.set(destination);
        } else {
            instructionCounter.increment();
        }
    }
}
