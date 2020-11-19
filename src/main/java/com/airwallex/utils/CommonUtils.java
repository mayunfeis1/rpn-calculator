package com.airwallex.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

public class CommonUtils {


    /**
     * judge whether it is a number
     *
     * @param number
     * @return
     */
    public static boolean isNumber(String number) {
        try {
            Double.valueOf(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    /**
     *
     *  record the data in the stack of operands into the log stack
     * @param numbers
     * @param logList
     */
    public static void addLogList(Stack<Double> numbers, Stack<List<Double>> logList) {
        List<Double> numbersList = new ArrayList<>();
        for (Double d : numbers) {
            numbersList.add(d);
        }
        logList.push(numbersList);
    }

    /**
     * print stack data
     * @param numbers
     */
    public static void printStack(Stack<Double> numbers, List<String> subList) {
        System.out.print("stack： ");
        if(!numbers.isEmpty()) {
            for(double d : numbers) {
                System.out.print(numberFormat(d) + " ");
            }
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        subList.stream().filter(f->{
            return CommonUtils.isNumber(f);
        }).forEach(f->{
            sb.append(f).append(" and ");
        });
        if(sb.length()>1){
            sb.delete(sb.lastIndexOf("and"),sb.length()-1).append("were not pushed on to the stack due to the previous error)");
            System.out.println(sb.toString());
        }
    }

    /**
     * the precision is at least 15 decimal places, but 10 decimal places are displayed
     * @param number
     * @return
     */
    public static String numberFormat(double number) {
        DecimalFormat numFormat = new DecimalFormat("##########.##########");
        numFormat.setRoundingMode(RoundingMode.DOWN);// 舍去末尾
        String output = numFormat.format(number);
        return output;
    }
}
