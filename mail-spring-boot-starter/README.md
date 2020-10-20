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

- 指定模块（上传私服）
```powershell
mvn -B -U clean deploy -pl model1,model2 -am -Dmaven.test.skip=true
mvn -B -U clean deploy -pl cloud-api -am -Dmaven.test.skip=true
# -B：该参数表示让Maven使用批处理模式构建项目，能够避免一些需要人工参与交互而造成的挂起状态。
# -U：该参数能强制让Maven检查所有SNAPSHOT依赖更新，确保集成基于最新的状态，如果没有该参数，Maven默认以天为单位检查更新，而持续集成的频率应该比这高很多。
# -pl：选项后可跟随{groupId}:{artifactId}或者所选模块的相对路径(多个模块以逗号分隔)
# -am：表示同时处理选定模块所依赖的模块
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
