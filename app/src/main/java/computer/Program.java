package computer;

import instructions.Instruction;
import java.util.ArrayList;
import java.util.List;

public abstract class Program {
    private List<Instruction> instructions;

    public Program() {
        this.instructions = new ArrayList<>();
    }

    public void add(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public Instruction getCurrentInstruction(InstructionCounter instructionCounter) {
        return this.instructions.get(instructionCounter.getCurrentInstruction());
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = 0; i < instructions.size(); i++) {
            var instruction = instructions.get(i);
            builder.append(i + ": " + instruction.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
