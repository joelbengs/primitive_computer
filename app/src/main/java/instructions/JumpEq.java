package instructions;

import computer.InstructionCounter;
import computer.Memory;
import computer.Operand;

public class JumpEq implements Instruction {
    private Operand left, right;
    private int destination;

    public JumpEq(int destination, Operand left, Operand right) {
        this.destination = destination;
        this.left = left;
        this.right = right;
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
