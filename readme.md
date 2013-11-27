## Readme

The purpose of this project is to write a program to determine whether a string can be derived by a context-free grammar (CFG).

# Use

To compile:

    javac -d out -sourcepath src src/Main.java

To run the program:

    java -cp out Main

# Design

This implementation uses the [Earley Parser](http://en.wikipedia.org/wiki/Earley_parser) algorithm. The `ContextFreeGrammar` class hosts the production rules and the terminals/variables/start state. A chart holds information on the parse so far in terms of StateSets.