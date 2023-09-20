abstract class BinOp implements Instruction {
    private Operand left, right;
    private Address result;

    public BinOp(Operand left, Operand right, Address result) {
        this.left = left;
        this.right = right;
        this.result = result;
    }

    void execute(Memory mem, InstructionCounter ic) {
        Word leftWord = this.left.getWord(mem);
        Word rightWord = this.right.getWord(mem);
        Word result = mem.getWord(this.result);
        evaluate(leftWord, rightWord, result);
    }

    protected abstract void evaluate(Word leftWord, Word rightWord, Word result);
}

class Add extends BinOp {
    public Add(Operand left, Operand right, Address result) {
        super(left, right, result);
    }

    protected void evaluate(Word leftWord, Word rightWord, Word result) {
        leftWord.add(rightWord, result);
    }
}

class Mul extends BinOp {
    public Add(Operand left, Operand right, Address result) {
        super(left, right, result);
    }

    protected void evaluate(Word leftWord, Word rightWord, Word resul) {
        leftWord.mul(rightWord, result);
    }
}
