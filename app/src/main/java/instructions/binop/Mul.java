package instructions.binop;

import computer.Address;
import computer.Operand;
import computer.Word;

public class Mul extends BinOp {

    public Mul(Operand left, Operand right, Address result) {
        super(left, right, result);
    }

    public void evaluate(Word left, Word right, Word result) {
        left.mul(right, result);
    }

    @Override
    public String toString() {
        return "Multiply " + this.left.toString() + " and " + this.right + " into " + this.result;
    }
}
