# PRN Calculator Implementation

### 1.Requirements overview

```jade
• The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
• Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
• Available operators are +, -, *, /, sqrt, undo, clear.
• Operators pop their parameters off the stack, and push their results back onto the stack.
• The ‘clear’ operator removes all items from the stack.
• The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previo us two operations.
• sqrt performs a square root on the top item from the stack.
• The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from
the stack.
• After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
• Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if
it causes no loss of precision).
• All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
• If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:
operator <operator> (position: <pos>): insufficient parameters
• After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed
```

### 2.Project structure description

```java
├──main              
    ├── doc                         // document
      ├── Readme.md                   //project document
    ├── ServiceMain                 //main class
    ├── utils                       //util package
      ├──CommonUtils                   //Tools required for project
    ├── service                     // Execute the logic package
      ├──CalculatorService             //Main execution task process class
      ├──OperatorCheck                 //check infomation
      ├──OperatorSelector              //Operator selector class
    ├── excption                   //exception package
      ├──NumTransException             //exception information class during operation class
    ├── calculator                 //A package that performs operational logic
      ├──CalculatorEnum               //Enumeration classes that perform specific calculations
      ├──OperatorContants             //Defines an executable arithmetic constant class
├──test
    ├──CalculatorTest           //test class case   
```

### 3.Description of operation process

```java
1.com.airwallex.ServiceMain：Function entry, receive user input expression, number and algorithm are separated by space
2.com.airwallex.service.CalculatorService：User input expression，call CalculatorService.doCalculator function：
  1).The space of the input expression is divided, and the data is put into the number heap
  2).Operation symbol encountered call OperatorCheck.check function,check whether the logarithm calculation operation is legal, and print warning information if it is illegal。
  3).If it is called legally OperatorSelector.selector function，Different logic operations are called according to the operation type。
3.com.airwallex.calculator.CalculatorEnum:Define the execution logic of different algorithms：
  1).OperatorSelector.selector function ,Determine the operator type, select different operation logic, and record the operation log information。
```

### 4.Test case

```java

1)input:5 2
  output:stack:5 2
2)input:2 sqrt
  output:stack:1.4142135623 
  input again：clear 9 sqrt
  output：stack： 3   
3）input：5 2 -
   output：stack： 3  
   input again：3 -
   output stack： 0 
   input again：clear
   output：stack：
4).input：5 4 3 2
   output：stack： 5 4 3 2 
   input again：undo undo *
   output：stack： 20
   input again：5 *
   output：stack： 100 
   input again：undo 
   output：stack： 20 5
5).input：7 12 2 /
   output：stack： 7 6
   input again： *
   output：stack： 42 
   input again： 4 /
   output：stack： 10.5 
6).input：1 2 3 4 5 *
   output：stack： 1 2 3 4 5
   input again： *
   output：stack： 1 2 3 20 
   input again： clear 3 4 -
   output：stack： -1
 7）input：1 2 3 4 5
    output：stack： 1 2 3 4 5
    input again：* * * *
    output：stack： 120
8).input：1 2 3 * 5 + * * 6 5
   output：
    operator * (position: 15): insufficient parameters 
    stack： 11 
   (6 and 5  were not pushed on to the stack due to the previous error)
```



