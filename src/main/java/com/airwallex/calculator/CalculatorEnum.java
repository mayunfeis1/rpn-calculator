package com.airwallex.calculator;

import com.airwallex.exception.NumTransException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *                    .::::.
 *                  .::::::::.
 *                 :::::::::::  
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 */

/**
 * Computational classes of operators
 * ADD：+
 * SUB：-
 * MUL：*
 * DIV： /
 * SQRT：sqrt
 * CLEAR：clear
 * UNDO ：undo
 */
public enum CalculatorEnum {

    ADD{
        @Override
       public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // from left to right
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 + num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    SUB{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            //  from left to right
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 - num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    MUL{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            //  from left to right
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 * num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    DIV{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList) throws NumTransException {
            //  from left to right
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            if (num2 == 0) {
                throw new NumTransException("The dividend cannot be 0!");
            }
            numbers.push(num1 / num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    SQRT{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList) throws NumTransException {
            double num = numbers.pop();
            if (num < 0) {
                throw new NumTransException("Negative Numbers can't be squared!");
            }
            double sqrtNum = (double) Math.sqrt(num);
            numbers.push(sqrtNum);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    CLEAR{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            numbers.clear();
            // Clear the data in the stack null
            List<Double> list = new ArrayList<>();
            list.add(null);
            logList.push(list);
        }
    },
    UNDO{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // clear the data in the stack
            numbers.clear();
            // Store the operation data of the previous step into the operation data stack
            if (!logList.isEmpty()) {
                logList.pop();// Store the operation data of the previous step into the operands stack and pop up the log of calculation results
                List<Double> numbersLog = logList.peek();
                for (Double d : numbersLog) {
                    if (d != null) {
                        numbers.push(d);
                    }
                }
            }
        }
    };

    public abstract void exec(Stack<Double> numbers,Stack<List<Double>> logList) throws NumTransException;
}
