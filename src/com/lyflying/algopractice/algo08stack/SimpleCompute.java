package com.lyflying.algopractice.algo08stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 解决只有小括号的四则运算
 */
public class SimpleCompute {

    static Map<String, Integer> holder = new HashMap();
    static {
        holder.put("+",0);
        holder.put("-",0);
        holder.put("*",1);
        holder.put("/",1);
    }

    /**
     * 后缀匹配
     * @param str
     * @return
     */
    public static String changeStr(String str){
        String[] array = str.split("");
        BaseStack stack = new ArrayStack(array.length);
        StringBuffer sb = new StringBuffer();
        for(String a : array){
            if("(".equals(a)){
                stack.push(a);
                continue;
            }
            if(")".equals(a)){
                while (!stack.peek().equals("(")){
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }

            if(holder.get(a) == null){
                sb.append(a);
                continue;
            }

            if(holder.get(a) <= 1){
                if(stack.peek() == null || holder.get(stack.peek()) == null || holder.get(a) > holder.get(stack.peek()) ){
                    stack.push(a);
                    continue;
                }
                while (holder.get(stack.peek()) != null && holder.get(a) <= holder.get(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(a);
            }
        }
        while (stack.peek() != null ){
            sb.append(stack.pop());
        }
        String result = sb.toString();
        return result;
    }

    public static int compute(String Str){
        String[] array = Str.split("");
        BaseStack stack = new ArrayStack(array.length);
        int result = 0;
        for(String a : array){
            if(holder.get(a) == null){
                stack.push(a);
                continue;
            }
            int a1 = Integer.parseInt(stack.pop());
            int a2 = Integer.parseInt(stack.pop());
            switch (a){
                case "+":
                    result =  a1 + a2;
                    stack.push(result+"");
                    break;
                case "-":
                    result = a2 - a1;
                    stack.push(result+"");
                    break;
                case "*":
                    result =  a1 * a2;
                    stack.push(result+"");
                    break;
                case "/":
                    result =  a2 / a1;
                    stack.push(result+"");
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // todo：两位数的计算无法识别； 同时带有中括号和大括号的无法识别
        String str = "9+(3-1)*3+8/2";
        String houzhuiStr = changeStr(str);
        System.out.println(houzhuiStr);
        System.out.println(compute(houzhuiStr));
    }

}
