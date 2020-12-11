package com.frank.sb.common.pojo;

/**
 *
 *
 * @author cy
 * @version EnumTest.java, v 0.1 2020年12月11日 12:08 下午 cy Exp $
 */
public enum KeyValEnumTest {

    /**
     * sonarqube
     */
    SONARQUBE("sonarqube","Mvn Sonar"),

    /**
     * ut
     */
    UT("ut","Unit Testing"),

    /**
     * mavenBuild
     */
    MAVENBUILD("mavenBuild","Mvn Package"),

    /**
     * deploy
     */
    DEPLOY("deploy","BuildImage&Deploy"),

    /**
     * at
     */
    AT("at","at");

    private  String key;
    private  String val;


    KeyValEnumTest(String key, String val){
        this.key=key;
        this.val=val;
    }

    public String getKey() {
        return key;
    }

    public String getVal() {
        return this.val;
    }

    /**
     * 根据指定的编码获取对应的流程的类型的枚举对象，未找到则返回null
     *
     * @param code 指定的编码
     * @return 未找到则返回null
     */
    public static KeyValEnumTest getEnumByCode(String code) {
        for (KeyValEnumTest KeyValEnumTest : KeyValEnumTest.values()) {
            if (KeyValEnumTest.getKey().equals(code)) {
                return KeyValEnumTest;
            }
        }
        return null;
    }

    public static String getValueByCode(String code) {
        for (KeyValEnumTest KeyValEnumTest : KeyValEnumTest.values()) {
            if (KeyValEnumTest.getKey().equals(code)) {
                return KeyValEnumTest.getVal();
            }
        }
        return null;
    }
}

