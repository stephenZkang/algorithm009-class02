package com.leetcode.qiaok.day49;

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
 * @since 2020-07-05
 * @author qiaok
 */
public class GenerateParenthesis {

    public static void main(String[] args){
        GenerateParenthesis test = new GenerateParenthesis();
        int n = 0;
        long start = System.nanoTime();
        List<String> res = test.generateParenthesis(n);
        System.out.println("耗时"+(System.nanoTime() - start)+"毫秒");
        System.out.println("res="+res);

    }

    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }


    private void backtrack(List<String> ans, StringBuilder cur,
                           int open, int close, int max) {
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }

        if(open < max){
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(close < open){
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }

    }
}
