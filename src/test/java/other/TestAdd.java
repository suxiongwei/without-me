package other;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-13 9:45 上午
 */
public class TestAdd {
    public static void main(String[] args) {
        int j  = 0;
        int m = 0,n  = 0;
        int i = 10;
        // 把自增或者自减写成单独的一条语句，不管前置还是后置的都没有区别，除了for循环里，谁敢在其它一行代码里加自增或者自减，老子上去就是一飞脚
        for (int i1 = 0; i1 < i; i1++) {
            //
            j = j++;
            m++;
            ++n;
        }
        System.out.println(j);
        System.out.println(m);
        System.out.println(n);
    }
}
