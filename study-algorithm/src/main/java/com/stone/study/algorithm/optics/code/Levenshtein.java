package com.stone.study.algorithm.optics.code;

import java.util.Arrays;

/**
 * 编辑距离算法:指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。<br/>
 * 用途：模糊查询<br/>
 * 参考：https://blog.csdn.net/basycia/article/details/51884350
 */
public class Levenshtein {

    public static void levenshtein(String str1, String str2) {
        //计算两个字符串的长度
        int len1 = str1.length();
        int len2 = str2.length();


        //创建二维数组，长度字符串长度+1
        int[][] dif = new int[len1 + 1][len2 + 1];

        //赋初始值
        for (int i = 0; i <= len1; i++) {
            dif[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dif[0][i] = i;
        }

//        for (int i = 0; i < dif.length; i++) {
//            int[] temp = dif[i];
//            for (int j = 0; j < temp.length; j++) {
//                System.out.print(dif[i][j]);
//            }
//            System.out.println("\t");
//        }


        //计算两个字符串是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //取三个值中最小的
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
            }

            System.out.println("字符串\"" + str1 + "\"与\"" + str2 + "\"的比较");
            //取数组右下角的值，同样不同位置代表不同字符串的比较
            System.out.println("差异步骤：" + dif[len1][len2]);
            //计算相似度
            float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
            System.out.println("相似度：" + similarity);
        }
    }

    /**
     * 获得最小值
     *
     * @param is
     * @return
     */
    private static int min(int... is) {
        int min = Integer.MIN_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        levenshtein("1234123412341", "你好");
    }
}
