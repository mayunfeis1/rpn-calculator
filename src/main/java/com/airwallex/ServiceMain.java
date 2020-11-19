package com.airwallex;

import com.airwallex.exception.NumTransException;
import com.airwallex.service.CalculatorService;

import java.util.Scanner;

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
 *  RPN Calculator entry function
 */
public class ServiceMain {

    static String[] testExpression = new String[] { "5 2", "2 sqrt", "clear 9 sqrt", "5 2 -", "-", "clear", "5 4 3 2",
            "undo undo *", "5 *", "undo", "7 12 2 /", "*", "4 /", "1 2 3 4 5 *", "clear 3 4 -", "1 2 3 4 5", "* * * *",
            "1 2 3 * 5 + * * 6 5" };


    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        try {
            while (true) {
                // 手动输入表达式测试
                System.out.println("Please enter an expression：");
                Scanner scanner = new Scanner(System.in);
                String rpn = scanner.nextLine();
                System.out.println("Input expression： " + rpn);
                calculatorService.doCalculator(rpn);
            }

        } catch (NumTransException e) {
            System.out.println(e.getMessage());
        }
    }
}
