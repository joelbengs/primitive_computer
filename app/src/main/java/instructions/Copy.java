package instructions;

import computer.Address;
import computer.InstructionCounter;
import computer.Memory;
import computer.Operand;

public class Copy {
    private Operand operand;
    private Address adress;

    public Copy(Operand operand, Address adress) {
        this.operand = operand;
        this.adress = adress;
    }

    public void execute(Memory memory, InstructionCounter counter) {
        this.adress.getWord(memory).copy(this.operand.getWord(memory));
        counter.increment();
    }
}
