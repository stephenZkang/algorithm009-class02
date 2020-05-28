package com.leetcode.qiaok.day11;

/**
 * 1021. 删除最外层的括号
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 *
 *
 * @since 2020-05-27
 * @author qiaok
 */
public class RemoveOuterParentheses {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        RemoveOuterParentheses test = new RemoveOuterParentheses();
        String s = "()()";
        long start = System.currentTimeMillis();
        String res = test.removeOuterParentheses1(s);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
        int i = 0;
        System.out.println(i++>0);
        System.out.println(i);
        int j = 0;
        System.out.println(++j>0);
        System.out.println(j);

    }

    /**
     *
     * @param s
     * @return
     */
    private String removeOuterParentheses(String s) {
        StringBuffer buffer = new StringBuffer();
        int length = s.length();
        int num = 0;int start = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == '('){
                num++;
            }
            if(s.charAt(i) == ')'){
                num--;
            }
            if(num==0&&i!=0){
                buffer.append(s.substring(start+1,i));
                start = i + 1;
            }

        }
        return buffer.toString();
    }

    /**
     *
     * @param s
     * @return
     */
    private String removeOuterParentheses1(String s) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        for (Character c: s.toCharArray()) {
            if(c == '(' && i++>0)buffer.append(c);
            if(c == ')' && i-->1)buffer.append(c);
        }
        return buffer.toString();
    }


}
