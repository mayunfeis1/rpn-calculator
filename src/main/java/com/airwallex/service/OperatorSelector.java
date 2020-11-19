package com.airwallex.service;

import com.airwallex.calculator.CalculatorEnum;
import com.airwallex.calculator.OperatorContants;
import com.airwallex.exception.NumTransException;

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
 * Operation selector class
 */
public class OperatorSelector {

    public static void selector(Stack<Double> numbers, Stack<List<Double>> logList, String operator) throws NumTransException {
        switch (operator){
            case OperatorContants.ADD: CalculatorEnum.ADD.exec(numbers,logList);break;
            case OperatorContants.SUB: CalculatorEnum.SUB.exec(numbers,logList);break;
            case OperatorContants.MUL: CalculatorEnum.MUL.exec(numbers,logList);break;
            case OperatorContants.DIV: CalculatorEnum.DIV.exec(numbers,logList);break;
            case OperatorContants.SQRT: CalculatorEnum.SQRT.exec(numbers,logList);break;
            case OperatorContants.CLEAR: CalculatorEnum.CLEAR.exec(numbers,logList);break;
            case OperatorContants.UNDO: CalculatorEnum.UNDO.exec(numbers,logList);break;
            default:throw new NumTransException("error Input expression of PRN !");
        }
    }
}
