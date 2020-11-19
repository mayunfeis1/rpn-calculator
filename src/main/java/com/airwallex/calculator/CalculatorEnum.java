package com.airwallex.calculator;

import com.airwallex.exception.NumTransException;
import com.airwallex.utils.CommonUtils;

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
 * 算子的计算类
 * ADD：+
 * SUB：-
 * MUL：*
 * DIV： /
 * SQRT：开方
 * CLEAR：情况
 * UNDO ：回退
 */
public enum CalculatorEnum {

    ADD{
        @Override
       public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // 按照从左向右计算，则先弹出栈顶的数据是：被除数。
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 + num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    SUB{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // 按照从左向右计算，则先弹出栈顶的数据是：被除数。
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 - num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    MUL{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // 按照从左向右计算，则先弹出栈顶的数据是：被除数。
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            numbers.push(num1 * num2);
            CommonUtils.addLogList(numbers, logList);
        }
    },
    DIV{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList) throws NumTransException {
            // 按照从左向右计算，则先弹出栈顶的数据是：被除数。
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
            // 将栈内数据清空
            numbers.clear();
            // 清理动作在日志栈里存入null，用于回退时区分
            List<Double> list = new ArrayList<>();
            list.add(null);
            logList.push(list);
        }
    },
    UNDO{
        @Override
        public void exec(Stack<Double> numbers,Stack<List<Double>> logList){
            // 将栈内数据清空
            numbers.clear();
            // 将上一步的操作数据存入操作数栈中
            if (!logList.isEmpty()) {
                logList.pop();// 弹出计算结果的日志
                List<Double> numbersLog = logList.peek();// 获取计算前的栈数据
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
