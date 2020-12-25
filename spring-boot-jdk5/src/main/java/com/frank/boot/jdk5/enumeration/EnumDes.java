package com.frank.boot.jdk5.enumeration;

/**
 *
 * 1.不能含有public修饰的构造器，即构造器只能是private修饰，如果没有构造器编译器同样也会自动生成一个带private修饰无参默认构造器。；
 * 2.所有的枚举值默认都是public static final 修饰的；
 * 3.枚举值与值之间用逗号分割，最后一个用分号，如果枚举值后面没有任何东西该分号可以省略；
 * 4.每一个枚举值就是一个枚举类型的实例；
 * 5.枚举类型中可以定义带任意修饰符的非枚举值变量；
 * 6.枚举值必须位于枚举类型的第一位置，即非枚举值必须位于枚举值之后；
 * 7.枚举类型自带两个方法，values() 和 value(String name) 两个方法。
 *
 * @author cy
 * @version EnumGo.java, v 0.1 2020年12月25日 3:21 下午 cy Exp $
 *
 * 定义枚举类型 EnumDes
 */
public enum EnumDes {

    MAN,WOMAN

}
