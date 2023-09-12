# EDAF60 2023 Computer Group 46

Hey Group 46!

Here are some useful resources on design patterns. To start with, Fireship's videos are _always_ [fire](https://www.youtube.com/watch?v=tv-_1er1mWI). [Refactoring](https://refactoring.guru/design-patterns) is another hidden gem worth checking out. /Joel

## Design questions

### O1

When defining the factorial program, the computer's memory is not yet instantiated. The computer's memory only turns up when the computer itself is instantiated.

The word `n` and `fac` should be kept in the computer's memory. The `Address` objects are simply there to facilitate referencing the not-yet instantiated computer memory. When the program is loaded into the computer, these addresses are translated to actual memory addresses.

### O2

The only information required to fetch the word at a given address is where in memory it is located, which is given to the `Address` constructor.

### O3

Two addresses (or just as well values) referencing the operands, and one address for where to store the result.

The types that can be passed into the `Add` constructor are either addresses, given by `Address` objects, or values, given as `String`s passed into the `WordFactory` to create `Word`s.

### O4

Class diagram for `Add`:
![Class diagram for `Add`](assets/o4.png "Class diagram for `Add`")

### O5

Updated class diagram for `Add`:
![Updated class diagram for `Add`](assets/o5.png "Updated class diagram for `Add`")

An `Add` object is constructed by passing into it two `Operand` objects (either an `Address` or `Word`), which will constitute the left and right operands  of the instruction ('arguments'), and one `Address`, which will store the result.

When an `Add` object is executed, it accesses its operands (`left` and `right`) using the `word(Memory)` method defined in the `Operand` interface. For regular words, the expected implementation is that it will just return itself, but on `Address` objects it looks up the `Word` stored in that memory address. The reason this method needs to take a `Memory` object as an argument is because a memory lookup is needed in the general case (when trying to convert an `Address` into a `Word`). The `word` implementation on `Address` looks up which word is stored at that address by passing itself into the `wordAt(Address) : Word` method of the `Memory` class.

At this point we have two `Word` objects that need to be added together. Since we have many different possible implementations of `Word`, and because the implementation is opaque, the `Add` class can't possibly know how to add any two words together. This is instead delegated to a method in `Word`, which means that it is the responsibility of each implementing class to know how to add two words together. The result of this operation is a `Word` which `Add` can then store in the `result` field.
