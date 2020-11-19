# PRN计算器实现

### 1.需求概述

```jade
•计算器等待用户输入，并期望接收包含空格分隔的数字和运算符。
•数字被压入堆栈，运算符对堆栈上的数字进行操作。
•可用运算符有+、-、*、/、sqrt、undo、clear。
•遇到运算符将参数从堆栈中弹出，并将结果推回到堆栈中。
•clear运算符从堆栈中移除所有。
•undo运算符撤消以前的操作。udo undo将撤消前两个操作。
•sqrt对堆栈顶部的项执行平方根运算。
•“+”、“-”、“*”、“/”运算符分别对堆栈数字进行操作。
•处理输入字符串后，计算器以空格分隔的列表形式显示堆栈的当前内容。
•数字应存储在堆栈上，精度至少为15位小数，但显示为10位小数（如果它不会导致精度损失）。
•所有数字应采用纯十进制字符串格式（即无工程格式）。
•如果运算符在堆栈上找不到足够数量的参数，则显示警告：运算符<运算符>（位置：<pos>）：参数不足
•显示警告后，字符串的所有进一步处理都将终止，并显示堆栈的当前状态
```

### 2.工程结构描述

```java
                
├── doc                         // 文档
  ├── Readme.md                   //工程说明文档
├── ServiceMain                 //主函数
├── utils                       //工具类所在包
  ├──CommonUtils                   //工程运行需要的工具类
├── service                     // 执行逻辑类所在包
  ├──CalculatorService             //主要执行任务流程类
  ├──OperatorCheck                 //校验信息类
  ├──OperatorSelector              //算子选择器类
├── excption                   //异常信息包
  ├──NumTransException             //运行过程中封装异常信息类
├── calculator                 //执行运算逻辑的包
  ├──CalculatorEnum               //执行具体计算的枚举类
  ├──OperatorContants             //定义可执行的运算法常量类

```

### 3.运行流程描述

```java
1.com.airwallex.ServiceMain：函数入口，接收用户输入的表达式，数字和运算法都以空格分割。
2.com.airwallex.service.CalculatorService：用户输入表达式，调用CalculatorService类的doCalculator方法：
  1).将输入的表达式空格分割，数据进入数字堆
  2).遇到运算符号 调用OperatorCheck类check方法,对数计算操作进行检查是否合法,不合法打印警告信息。
  3).如果合法调用 OperatorSelector类selector方法，根据运算法类型，调用不同逻辑运算。
3.com.airwallex.calculator.CalculatorEnum:定义不同运算法的执行逻辑：
  1).OperatorSelector类selector方法 ,判断运算符类型，选择不同运算逻辑，并记录操作日志信息。
```

### 4.测试用例

```java
温馨提示：如果连续测试多个测试案例，请每次运行完一个测试案例后执行一下clear，再执行下一个测试案例。

1)输入:5 2
  输出:stack:5 2
2)输入:2 sqrt
  输出:stack:1.4142135623 
  继续输入：clear 9 sqrt
  输出：stack： 3   
3）输入：5 2 -
   输出：stack： 3  
   继续输入：3 -
   输出 stack： 0 
   继续输入：clear
   输出：stack：
4).输入：5 4 3 2
   输出：stack： 5 4 3 2 
   继续输入：undo undo *
   输出：stack： 20
   继续输入：5 *
   输出：stack： 100 
   继续输入：undo 
   输出：stack： 20 5
5).输入：7 12 2 /
   输出：stack： 7 6
   继续输入： *
   输出：stack： 42 
   继续输入： 4 /
   输出：stack： 10.5 
6).输入：1 2 3 4 5 *
   输出：stack： 1 2 3 4 5
   继续输入： *
   输出：stack： 1 2 3 20 
   继续输入： clear 3 4 -
   输出：stack： -1
 7）输入：1 2 3 4 5
    输出：stack： 1 2 3 4 5
    继续输入：* * * *
    输出：stack： 120
8).输入：1 2 3 * 5 + * * 6 5
   输出：
    operator * (position: 15): insufficient parameters 
    stack： 11 
   (6 and 5  were not pushed on to the stack due to the previous error)
```



