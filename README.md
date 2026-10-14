# Java Basics

A collection of small console programs in Java, from basic syntax to
simple games and OOP. Each package is a separate program with its own `Main`.

## Contents

| Package | What it does |
|---------|--------------|
| `basics` | Primitive types, arithmetic, conditionals: range check of a sum, sign of a number, greeting, leap year |
| `arrays` | Working with arrays: 0/1 inversion, filling, matrix diagonal, min/max, finding the balance point, cyclic shift by *n* without an auxiliary array |
| `games` | "Guess the number" (3 attempts) and "Guess the word" with a hint showing matching letters |
| `tictactoe` | 3×3 console Tic-Tac-Toe against a computer that tries to win or block the player's move |
| `employees` | An employee class with age validation, selecting employees older than 40 |
| `animals` | Inheritance: cats and dogs run and swim within limits, counting created instances |
| `feeding` | Cats eat from a plate: the plate never goes negative, a cat has a satiety level, food can be added |

## Build and run

Requires JDK 11+.

```bash
javac -encoding UTF-8 -d out $(find src -name '*.java')
java -cp out tictactoe.Main
```
