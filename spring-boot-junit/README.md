# Spring Boot —— Junit单元测试（MockMvc） #
## 简介 ##

### 版本介绍 ###
- Spring Boot 2.1.7
- junit 4.12

## 实战 ##
### 目标 ###
- 通过MockMvc实现Controller的Junit单元测试

### 关键源码 ###
#### pom.xml ####
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>spring-boot-junit</groupId>
    <artifactId>spring-boot-junit</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.7.RELEASE</version>
        <relativePath/>
    </parent>

    <dependencies>
        <!-- junit begin -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- junit end -->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        
    </dependencies>

</project>
```

#### Controller ####
```java
@Controller
@RequestMapping(value = "/junit")
public class JunitTestController {

    @Autowired
    private JunitService junitService;

    @RequestMapping(value = "/helloJunit")
    public ModelAndView helloJunit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", junitService.junitTestServiceString("Frank"));
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
```

#### 编写测试用例 ####
  + 测试用例地址：
```java
import com.frank.sb.junit.JunitApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JunitApplication.class)
@WebAppConfiguration
public class JunitTestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Before
    public void setUp()throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void helloJunit() throws Exception{

        /**
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
         */

        MvcResult mvcResult= mvc.perform(MockMvcRequestBuilders.get("/junit/helloJunit")
// 参数传递
//                .param("name","lvgang")
                .accept(MediaType.TEXT_HTML_VALUE))
                // .andExpect(MockMvcResultMatchers.status().isOk())             //等同于Assert.assertEquals(200,status);
                // .andExpect(MockMvcResultMatchers.content().string("hello lvgang"))    //等同于 Assert.assertEquals("hello lvgang",content);
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status=mvcResult.getResponse().getStatus();                 //得到返回代码
        String content=mvcResult.getResponse().getContentAsString();    //得到返回结果

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
        Assert.assertEquals("你好：Frank",content);            //断言，判断返回的值是否正确
    }
}
```

#### 执行测试用例结果 ####
```jshelllanguage
...
...
...

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.7.RELEASE)

2019-09-15 19:36:40.602  INFO 4068 --- [           main] c.f.s.j.c.JunitTestControllerTest        : Starting JunitTestControllerTest on DESKTOP-4E4GNBT with PID 4068 (started by cy880 in E:\Project\Java\spring-boot-frank\spring-boot-junit)
2019-09-15 19:36:40.603  INFO 4068 --- [           main] c.f.s.j.c.JunitTestControllerTest        : No active profile set, falling back to default profiles: default
2019-09-15 19:36:41.758  INFO 4068 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-09-15 19:36:41.831  INFO 4068 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2019-09-15 19:36:42.062  INFO 4068 --- [           main] c.f.s.j.c.JunitTestControllerTest        : Started JunitTestControllerTest in 1.817 seconds (JVM running for 2.516)
2019-09-15 19:36:42.222  INFO 4068 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2019-09-15 19:36:42.223  INFO 4068 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2019-09-15 19:36:42.232  INFO 4068 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 9 ms
sign in service impl ------

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /junit/helloJunit
       Parameters = {}
          Headers = [Accept:"text/html"]
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = com.frank.sb.junit.controller.JunitTestController
           Method = public org.springframework.web.servlet.ModelAndView com.frank.sb.junit.controller.JunitTestController.helloJunit()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = index
             View = null
        Attribute = msg
            value = 你好：Frank

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Language:"en", Content-Type:"text/html;charset=UTF-8"]
     Content type = text/html;charset=UTF-8
             Body = 你好：Frank
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
2019-09-15 19:36:42.324  INFO 4068 --- [       Thread-2] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
Disconnected from the target VM, address: '127.0.0.1:64469', transport: 'socket'

Process finished with exit code 0
```

## 关键点 ##
### MockMvcRequestBuilders ###
**```通过观察单元测试类，用到了一个关键类（MockMvcRequestBuilders）用来构建请求，下面简单下它的关键API：```**
- MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables)
根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get(/user/{id}, 1L)；
- MockHttpServletRequestBuilder post(String urlTemplate, Object... urlVariables)
同get类似，但是是POST方法
- MockHttpServletRequestBuilder put(String urlTemplate, Object... urlVariables)
同get类似，但是是PUT方法
- MockHttpServletRequestBuilder delete(String urlTemplate, Object... urlVariables)
同get类似，但是是DELETE方法
- MockHttpServletRequestBuilder options(String urlTemplate, Object... urlVariables)
同get类似，但是是OPTIONS方法
- MockMultipartHttpServletRequestBuilder  request(HttpMethod httpMethod, String urlTemplate, Object... urlVariables)
提供自己的Http请求方法及uri模板和uri变量，如上API都是委托给这个API
- MockMultipartHttpServletRequestBuilder fileUpload(String urlTemplate, Object... urlVariables)
提供文件上传方式的请求，得到MockMultipartHttpServletRequestBuilder
- RequestBuilder asyncDispatch(final MvcResult mvcResult)
创建一个从启动异步处理的请求的MvcResult进行异步分派的RequestBuilder


**MockHttpServletRequestBuilder可通过方法获取两类Builder （MockHttpServletRequestBuilder、MockMultipartHttpServletRequestBuilder ），下面分别介绍两类的主要API：**
#### MockHttpServletRequestBuilder ####
- MockHttpServletRequestBuilder header(String name, Object... values)/MockHttpServletRequestBuilder headers(HttpHeaders httpHeaders)
添加头信息；
- MockHttpServletRequestBuilder contentType(MediaType mediaType)
指定请求的contentType头信息；
- MockHttpServletRequestBuilder accept(MediaType... mediaTypes)/MockHttpServletRequestBuilder accept(String... mediaTypes)
指定请求的Accept头信息；
- MockHttpServletRequestBuilder content(byte[] content)/MockHttpServletRequestBuilder content(String content)
指定请求Body体内容；
- MockHttpServletRequestBuilder param(String name,String... values)
请求传入参数
- MockHttpServletRequestBuilder cookie(Cookie... cookies)
指定请求的Cookie；
- MockHttpServletRequestBuilder locale(Locale locale)
指定请求的Locale；
- MockHttpServletRequestBuilder characterEncoding(String encoding)
指定请求字符编码；
- MockHttpServletRequestBuilder requestAttr(String name, Object value)
设置请求属性数据；
- MockHttpServletRequestBuilder sessionAttr(String name, Object value)/MockHttpServletRequestBuilder sessionAttrs(Map<string, object=""> sessionAttributes)
设置请求session属性数据；
- MockHttpServletRequestBuilder flashAttr(String name, Object value)/MockHttpServletRequestBuilder flashAttrs(Map<string, object=""> flashAttributes)
指定请求的flash信息，比如重定向后的属性信息；
- MockHttpServletRequestBuilder session(MockHttpSession session) 
指定请求的Session；
- MockHttpServletRequestBuilder principal(Principal principal)
指定请求的Principal；
- MockHttpServletRequestBuilder contextPath(String contextPath)
指定请求的上下文路径，必须以“/”开头，且不能以“/”结尾；
- MockHttpServletRequestBuilder pathInfo(String pathInfo)
请求的路径信息，必须以“/”开头；
- MockHttpServletRequestBuilder secure(boolean secure)
请求是否使用安全通道；
- MockHttpServletRequestBuilder with(RequestPostProcessor postProcessor)
请求的后处理器，用于自定义一些请求处理的扩展点；

#### MockMultipartHttpServletRequestBuilder ####
**MockMultipartHttpServletRequestBuilder继承自MockHttpServletRequestBuilder**
- MockMultipartHttpServletRequestBuilder file(String name, byte[] content)/MockMultipartHttpServletRequestBuilder file(MockMultipartFile file)
指定要上传的文件；

### ResultActions ###
**```MockMvc.perform(RequestBuilder requestBuilder)后将得到ResultActions，通过ResultActions完成如下三件事```**
- ResultActions andExpect(ResultMatcher matcher) 
添加验证断言来判断执行请求后的结果是否是预期的；
- ResultActions andDo(ResultHandler handler) 
添加结果处理器，用于对验证成功后执行的动作，如输出下请求/结果信息用于调试；
- MvcResult andReturn() 
返回验证成功后的MvcResult；用于自定义验证/下一步的异步处理；

### ResultMatcher / MockMvcResultMatchers ###
**```ResultMatcher用来匹配执行完请求后的结果验证，其就一个match(MvcResult result)断言方法，如果匹配失败将抛出相应的异常；此类例子中并没有使用，具体提供以下API：```**
- HandlerResultMatchers handler()
请求的Handler验证器，比如验证处理器类型/方法名；此处的Handler其实就是处理请求的控制器；
- RequestResultMatchers request()
得到RequestResultMatchers验证器；
- ModelResultMatchers model()
得到模型验证器；
- ViewResultMatchers view()
得到视图验证器；
- FlashAttributeResultMatchers flash()
得到Flash属性验证；
- StatusResultMatchers status()
得到响应状态验证器；
- HeaderResultMatchers header()
得到响应Header验证器；
- CookieResultMatchers cookie()
得到响应Cookie验证器；
- ContentResultMatchers content()
得到响应内容验证器；
- JsonPathResultMatchers jsonPath(String expression, Object ... args)/ResultMatcher jsonPath(String expression, Matcher matcher)
得到Json表达式验证器；
- XpathResultMatchers xpath(String expression, Object... args)/XpathResultMatchers xpath(String expression, Map<string, string=""> namespaces, Object... args)
得到Xpath表达式验证器；
- ResultMatcher forwardedUrl(final String expectedUrl)
验证处理完请求后转发的url（绝对匹配）；
- ResultMatcher forwardedUrlPattern(final String urlPattern)
验证处理完请求后转发的url（Ant风格模式匹配，@since spring4）；
- ResultMatcher redirectedUrl(final String expectedUrl)
验证处理完请求后重定向的url（绝对匹配）；
- ResultMatcher redirectedUrlPattern(final String expectedUrl)
验证处理完请求后重定向的url（Ant风格模式匹配，@since spring4）；

- - -
[博客API内容转自：https://my.oschina.net/sdlvzg/blog/1594821](https://my.oschina.net/sdlvzg/blog/1594821)
- - -
[GitHub 项目地址](https://github.com/FrankCy/spring-boot-frank/tree/master/spring-boot-junit)