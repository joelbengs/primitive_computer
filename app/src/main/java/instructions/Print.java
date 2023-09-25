package instructions;

import computer.InstructionCounter;
import computer.Memory;
import computer.Operand;

public class Print implements Instruction {

    private Operand op;

    public Print(Operand op) {
        this.op = op;
    }

    public void execute(Memory memory, InstructionCounter instructionCounter) {
        var word = op.getWord(memory);
        System.out.println(word);
        instructionCounter.increment();
    }
}
