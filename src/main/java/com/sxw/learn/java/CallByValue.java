package com.sxw.learn.java;

/**
 *
 * 测试JAVA中的按值传递
 */
public class CallByValue {
    private static User user = null;
    private static User stu = null;

    public static void swap(User x, User y){
        User tmp = x;
        x = y;
        y = tmp;

//        x.setAge(100);
    }

    public static void main(String[] args) {
        user = new User("user", 26);
        stu = new User("stu", 18);

        System.out.println("调用前user的值:" + user);
        System.out.println("调用前stu的值:" + stu);
        swap(user,stu);
        System.out.println("调用后user的值:" + user);
        System.out.println("调用后stu的值:" + stu);

        /**
         * 如果传递的参数是八大基本类型的话，是值传递。如果参数传递的是对象实例、数组或者是接口的话，还是按值传递的，千万不要被外表所迷惑
         * 也就是说，如果当你传递的是对象作为参数的话，首先参数会先进行拷贝一份引用执行原本的实例对象，
         * <span>但是一旦这个调用这个方法的结束之后，那么这个拷贝过来的实例对象的引用就会被销毁。</span>
         *
         * 结论：
         * 在传进来的参数是基本类型的时候，用的是值传递
         * 如果传进来的参数类型是对象或者是数组类型的时，还是值传递，只是传递的值是引用
         *
         * 自己的理解，栈中保存的是基本类型的值和引用对象的地址，所以在swap的栈中对引用的修改不会影响到main的栈
         * 而当你在swap的栈中对传递进来的引用做了修改，则会影响到main中引用对象的值，因为它们都指向了堆中的同一个对象。
         */
    }
}

class User{
    private String userName;
    private Integer age;

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
