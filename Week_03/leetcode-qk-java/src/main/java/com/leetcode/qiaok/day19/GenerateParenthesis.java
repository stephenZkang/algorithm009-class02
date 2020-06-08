package com.leetcode.qiaok.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @since 2020-06-08
 * @author qiaok
 */
public class GenerateParenthesis {

    private ArrayList<String> result;

    /**
     * @param args
     */
    public static  void main(String[] args){
        GenerateParenthesis test = new GenerateParenthesis();
        int n = 2;
        List<String> res = test.generateParenthesis(n);
        System.out.println("res="+res);
    }

    /**
     * 时间复杂度:
     * 空间复杂度
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generateParenthesis(0,0,n,"");
        return result;
    }

    private void _generateParenthesis(int left, int right, int max, String s) {
        if(left == max && right == max){
            result.add(s);
        }

        if(left < max){
            _generateParenthesis(left + 1,right,max, s +"(");
        }
        if(left > right){
            _generateParenthesis(left,right+1,max,s+"{");
            result.add(")");
        }
    }
}
