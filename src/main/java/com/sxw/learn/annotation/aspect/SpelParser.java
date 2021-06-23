package com.sxw.learn.annotation.aspect;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-08-23 2:15 下午
 */
public class SpelParser {
    private static ExpressionParser parser = new SpelExpressionParser();

    /**
     *
     * @param key el表达式字符串，占位符以#开头
     * @param parameterNames 形参名称，可以理解为占位符名称
     * @param args 参数值 可以理解为占位符真实的值
     * @return
     */
    public static String getKey(String key, String[] parameterNames, Object[] args) {
        // 第一步 将key字符串解析成el表达式
        Expression exp = parser.parseExpression(key);
        // 第二步 将形参和参数值以配对的方式赋值到上下文中
        EvaluationContext context = new StandardEvaluationContext();
        if(args.length <= 0){
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }
        // 第三步 根据赋值上下文计算运算el表达式
        return exp.getValue(context, String.class);
    }
}
