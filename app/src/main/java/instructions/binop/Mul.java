package instructions.binop;

import computer.Address;
import computer.Operand;
import computer.Word;

public class Mul extends BinOp {

    public Mul(Operand left, Operand right, Address result) {
        super(left, right, result);
    }

    public void evaluate(Word left, Word right, Word result) {
        result.mul(left, right);
    }
}
