package com.airwallex.service;

import com.airwallex.exception.NumTransException;

import java.util.ArrayList;
import java.util.Arrays;
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
 * RPN Calculator class
 *1. Judge the number, stack and record the log
 *2. Check the correctness of input
 *3. Execute the calculation logic
 *4. Print log
 */
public class CalculatorService {



    // 记录当前可以操作的数的栈
    private Stack<Double> numbers = new Stack<>();
    // 记录栈数据的操作日志
    private Stack<List<Double>> logList = new Stack<>();

    public void doCalculator(String expression) throws NumTransException {
        // 通过空格分隔切分输入的表达式
        String[] paramArr = expression.split(" ");
        int paramArrLength = paramArr.length;
        List<String> paramList= Arrays.asList(paramArr);
        List<String> subList=new ArrayList<>();
        for (int i = 0; i < paramArrLength; i++) {
            String operator = paramArr[i];
            // 判断是数字则入栈，记录栈日志
            if (CommonUtils.isNumber(operator)) {
                numbers.push(Double.valueOf(operator));
                CommonUtils.addLogList(numbers, logList);
                continue;
            }
            //正确检查
            boolean ck = OperatorCheck.check(operator,i,numbers);
            if(!ck){
                subList = paramList.subList(i,paramList.size());
                break;
            }
            //枚举选择
            OperatorSelector.selector(numbers,logList,operator);
        }
        //打印日志
        CommonUtils.printStack(numbers, subList);
    }





}
