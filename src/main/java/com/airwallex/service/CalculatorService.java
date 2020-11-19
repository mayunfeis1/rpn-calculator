package com.airwallex.service;

import com.airwallex.exception.NumTransException;
import com.airwallex.utils.CommonUtils;

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



    // A stack that records the number currently available for operation
    private Stack<Double> numbers = new Stack<>();
    // Operation log recording stack data
    private Stack<List<Double>> logList = new Stack<>();

    public void doCalculator(String expression) throws NumTransException {
        // Split the input expression by a space
        String[] paramArr = expression.split(" ");
        int paramArrLength = paramArr.length;
        List<String> paramList= Arrays.asList(paramArr);
        List<String> subList=new ArrayList<>();
        for (int i = 0; i < paramArrLength; i++) {
            String operator = paramArr[i];
            // If it is a number, it will be put on the stack and the stack log will be recorded
            if (CommonUtils.isNumber(operator)) {
                numbers.push(Double.valueOf(operator));
                CommonUtils.addLogList(numbers, logList);
                continue;
            }
            //Correct check
            boolean ck = OperatorCheck.check(operator,i,numbers);
            if(!ck){
                subList = paramList.subList(i,paramList.size());
                break;
            }
            //Enumeration selection
            OperatorSelector.selector(numbers,logList,operator);
        }
        //print logs
        CommonUtils.printStack(numbers, subList);
    }





}
