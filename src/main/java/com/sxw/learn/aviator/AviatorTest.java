package com.sxw.learn.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;

/**
 * AviatorScript脚本的运行核心是两步：编译、执行
 */
public class AviatorTest {
    @SneakyThrows
    public void testHello() {
        //获取路径
        ClassPathResource resource = new ClassPathResource("script/hello.av");
        String scriptPath = resource.getPath();
        //编译脚本文件
        Expression exp = AviatorEvaluator.getInstance().compileScript(scriptPath);
        //执行
        exp.execute();
    }

    @SneakyThrows
    public void testHelloStr() {
        //定义脚本
        String script = "println(\"Hello, AviatorScript!\");";
        //编译脚本文本
        Expression exp = AviatorEvaluator.getInstance().compile(script);
        //执行
        exp.execute();
    }

    @SneakyThrows
    public void testContext() {
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        //上下文
        double a = 100.3, b = 45, c = -199.100;
        Map<String, Object> context = new HashMap<>();
        context.put("a", a);
        context.put("b", b);
        context.put("c", c);
        //通过注入的上下文执行
        Boolean result = (Boolean) compiledExp.execute(context);
        System.out.println(result);
    }

    @SneakyThrows
    public void testUserDefineFunction() {
        //通通创建一个AviatorEvaluator的实例
        AviatorEvaluatorInstance instance = AviatorEvaluator.getInstance();
        //注册函数
        instance.addFunction(new AddFunction());
        //执行ab脚本,脚本里调用自定义函数
        Double result= (Double) instance.execute("add(1, 2)");
        //输出结果
        System.out.println(result);
    }


    /**
     * 实现AbstractFunction接口，就可以自定义函数
     */
    class AddFunction extends AbstractFunction {

        /**
         * 函数调用
         *
         * @param env  当前执行的上下文
         * @param arg1 第一个参数
         * @param arg2 第二个参数
         * @return 函数返回值
         */
        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            //将两个参数进行相加
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }

        /**
         * 函数的名称
         *
         * @return 函数名
         */
        public String getName() {
            return "add";
        }
    }

    public static void main(String[] args) {
        AviatorTest aviatorTest = new AviatorTest();
//        aviatorTest.testHello();
//        aviatorTest.testHelloStr();
//        aviatorTest.testContext();
        aviatorTest.testUserDefineFunction();
    }
}
