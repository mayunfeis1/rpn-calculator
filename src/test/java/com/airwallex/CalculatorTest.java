package com.airwallex;

import com.airwallex.Interface.KeyBoard;
import com.airwallex.Interface.impl.KeyBoardImpl;
import com.airwallex.exception.NumTransException;
import com.airwallex.service.CalculatorService;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
 *Test class
 */
public class CalculatorTest {

    KeyBoard keyBoard = new KeyBoardImpl();
    CalculatorService calculatorService = new CalculatorService();



    @Test
    public void Test1() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("5 2");
        process(list);
    }

    @Test
    public void Test2() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("2 sqrt");
        list.add("clear 9 sqrt");
        process(list);
    }

    @Test
    public void Test3() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("5 2 -");
        list.add("3 -");
        list.add("clear");
        process(list);
    }

    @Test
    public void Test4() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("5 4 3 2");
        list.add("undo undo *");
        list.add("5 *");
        list.add("undo");
        process(list);
    }

    @Test
    public void Test5() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("7 12 2 /");
        list.add("*");
        list.add("4 /");
        process(list);
    }

    @Test
    public void Test6() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("1 2 3 4 5");
        list.add("*");
        list.add("clear 3 4 -");
        process(list);
    }

    @Test
    public void Test7() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("1 2 3 4 5");
        list.add("* * * *");
        process(list);
    }

    @Test
    public void Test8() throws NumTransException {
        List<String> list = new ArrayList<>();
        list.add("1 2 3 * 5 + * * 6 5");
        process(list);
    }

    private void process(List<String> list) throws NumTransException {
        String input;
        InputStream stdin = System.in;
        try{
            for(int i=0;i<list.size();i++){
                System.setIn(new ByteArrayInputStream(list.get(i).getBytes()));
                input = keyBoard.input();
                System.out.println("Input expression： " + input);
                calculatorService.doCalculator(input);
            }
        }finally {
            System.setIn(stdin);
        }
    }
}
