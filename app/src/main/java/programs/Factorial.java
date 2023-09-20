package programs;

import computer.*;
import instructions.*;
import instructions.binop.Add;
import instructions.binop.Mul;

// public class Factorial extends Program {

//     public Factorial  (String value, WordFactory wf) {
//         Address n = new Address(0),
//                 fac = new Address(1);
//         add(new Copy(wf.word(value), n));
//         add(new Copy(wf.word("1"), fac));
//         add(new JumpEq(6, n, wf.word("1")));
//         add(new Mul(fac, n, fac));
//         add(new Add(n, wf.word("-1"), n));
//         add(new Jump(2));
//         add(new Print(fac));
//         add(new Halt());
//     }
// }