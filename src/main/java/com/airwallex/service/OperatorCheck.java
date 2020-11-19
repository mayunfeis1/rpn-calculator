package com.airwallex.service;

import com.airwallex.calculator.OperatorContants;

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
 * 操作符检查
 */
public class OperatorCheck {

    public static boolean check(String operator, int i, Stack<Double> numbers){

        if((operator.equals(OperatorContants.ADD) || operator.equals(OperatorContants.SUB) || operator.equals(OperatorContants.MUL) ||operator.equals(OperatorContants.DIV) )&& numbers.size() <= 1){

            // 判断如果操作数不足则退出循环
            System.out.println("operator " + operator + " (position: " + (i * 2 + 1) + "): insufficient parameters ");
          //  System.out.println(sb.toString());
            return false;

        }

        if(operator.equals(OperatorContants.SQRT) && numbers.size() <= 0)  {
            System.out.print("operator " + operator + " (position: " + (i * 2 + 1) + "): insufficient parameters ");
            return false;
        }
        return true;
    }
}
