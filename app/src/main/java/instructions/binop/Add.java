package instructions.binop;

import computer.Address;
import computer.Operand;
import computer.Word;

public class Add extends BinOp {

    public Add(Operand left, Operand right, Address result) {
        super(left, right, result);
    }

    @Override
    public void evaluate(Word left, Word right, Word result) {
        left.add(right, result);
    }

    @Override
    public String toString() {
        return "Add " + this.left.toString() + " and " + this.right + " into " + this.result;
    }
}
