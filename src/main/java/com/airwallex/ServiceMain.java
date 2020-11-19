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


    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        try {
            while (true) {
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
