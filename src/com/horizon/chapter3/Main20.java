package com.horizon.chapter3;

/**
 *  title : 表示数值的字符串
 *  url : https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main20 {

    private int index = 0;
    public boolean isNumeric(char[] str) {
        /*
            观察抽取出表示数值的字符串模式为A[.[B]][e|EC]，其中A为数值的整数部分，B紧跟着小数点为数值的
            小数部分，C紧跟着e/E为数值的指数部分，在小数里可能没有整数部分，例如.123等于0.123,小数点后面也
            可以没有数字，例如123.等于123.0。在模式中的A、C都可以带'+'或'-'。
        */
        if (str == null) {
            return false;
        }
        // 判断有符号整数
        boolean numeric = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数可以没有整数部分或小数点后面可以没有数字
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // e/E前面和后面都必须有数字
            numeric = scanInteger(str) && numeric;
        }
        return numeric && index == str.length;
    }

    public boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    public boolean scanUnsignedInteger(char[] str) {
        int temp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > temp;
    }

}
