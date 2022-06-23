package com.sxw.learn.design.decorator;
/**
 *  <span>学习装饰器模式</span>
 *  装饰器模式优点
 * ①、装饰模式可以动态地扩展一个实现类的功能。
 * ②、装饰类和被装饰类可以独立发展， 而不会相互耦合。换句话说， Component类无须知道Decorator类， Decorator类是从外部来扩展Component类的功能， 而Decorator也不用知道具体的构件。
 * ③、装饰模式是继承关系的一个替代方案。我们看装饰类Decorator， 不管装饰多少层， 返回的对象还是Component， 实现的还是is-a的关系
 * 5、装饰器模式应用场景
 * ①、需要扩展一个类的功能， 或给一个类增加附加功能。
 * ②、需要动态地给一个对象增加功能， 这些功能可以再动态地撤销。
 */