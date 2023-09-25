package computer;

public class Computer {
    private Memory memory;
    private Program program;
    private InstructionCounter instructionCounter;

    public Computer(Memory memory) {
        this.memory = memory;
        this.instructionCounter = new InstructionCounter();
    }

    public void load(Program program) {
        this.program = program;
    }

    public void run() {
        this.instructionCounter.start();
        while (this.instructionCounter.isRunning()) {
            var instruction = this.program.getCurrentInstruction(this.instructionCounter);
            instruction.execute(this.memory, this.instructionCounter);
        }
    }
}
