# 发送邮件功能
## 使用方式
- maven配置
```powershell
vim ~/.bash_profile
````
- - -
```text
export MAVEN_HOME=/Users/cy/util/apache-maven-3.6.3
export PATH=$PATH:$MAVEN_HOME/bin
```

- - -
```powershell
source ~/.bash_profile
```

- mvn打包
```powershell
 mvn clean install -Dmaven.test.skip=true
```
- 指定模块
```powershell
mvn clean install -pl model1,model2 -am -Dmaven.test.skip=true
```

- 需要的项目中引入
```xml
<dependency>
    <groupId>spring-boot-test</groupId>
    <artifactId>mail-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

- 需要的项目中编写测试类
```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImportApplication.class, ImportMailServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置启动类
public class MailServiceImplTest {

    @Autowired
    private ImportMailService importMailService;

    @Test
    public void testSendSimpleMail() {
        importMailService.sendMail("接受人邮箱@163.com", "主题：测试邮件发送", "测试邮件发送是否可用");
    }

}
```
