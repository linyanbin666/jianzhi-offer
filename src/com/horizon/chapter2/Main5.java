package com.horizon.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  title : 替换空格
 *  url : https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main5 {

    // 从后往前替换
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        if (str.length() == 0)
            return "";
        int blankCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                blankCount++;
        }
        int newLen = str.length() + 2 * blankCount;
        int indexOfOriginal = str.length() - 1, indexOfNew = newLen - 1;
        str.setLength(newLen);
        while (indexOfOriginal >= 0) {
            if (str.charAt(indexOfOriginal) == ' ') {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            } else {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            indexOfOriginal--;
        }
        return str.toString();
    }

    /*// 借用辅助空间
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        if (str.length() == 0)
            return "";
        char[] chars = str.toString().toCharArray();
        int blankCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                blankCount++;
        }
        char[] newChars = new char[chars.length + 2 * blankCount];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChars[index++] = '%';
                newChars[index++] = '2';
                newChars[index++] = '0';
            } else {
                newChars[index++] = chars[i];
            }
        }
        return new String(newChars);
    }*/

    @Test
    public void test() {
        String[] inputs = {"We Are Happy", "", "  ", "WeAreHappy"};
        String[] outputs = {"We%20Are%20Happy", "", "%20%20", "WeAreHappy"};
        for (int i = 0; i < inputs.length; i++) {
            Assertions.assertEquals(outputs[i], replaceSpace(new StringBuffer(inputs[i])));
        }
    }
}
