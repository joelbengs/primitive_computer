package instructions.binop;

import computer.Address;
import computer.InstructionCounter;
import computer.Memory;
import computer.Operand;
import computer.Word;
import instructions.Instruction;

public abstract class BinOp implements Instruction {

    private Operand left, right;
    private Address result;

    public BinOp(Operand left, Operand right, Address result) {
        this.left = left;
        this.right = right;
        this.result = result;
    }

    public abstract void evaluate(Word left, Word right, Word result);

    public void execute(Memory memory, InstructionCounter instructionCounter) {
        var wordLeft = left.getWord(memory);
        var wordRight = right.getWord(memory);
        var wordResult = result.getWord(memory);
        evaluate(wordLeft, wordRight, wordResult);
    }
}
