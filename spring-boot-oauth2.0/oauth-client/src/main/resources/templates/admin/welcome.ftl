<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<#include "../dependent/basic_dependent.ftl">
<@html title="" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <title>欢迎</title>
    </header>
    <body>
    <@security.authorize access='hasAnyAuthority("ADMIN")'>
        一些div或按钮AADDDMMIINN等其他元素
    </@security.authorize>
    <@security.authorize access='hasAnyAuthority("OTHER")'>
        一些div或按AAABBBCCC钮等其他元素
    </@security.authorize>
    <p>欢迎页面！！！！！！！！！</p>
    <input type="button" onclick="forwardIndex()"/>
    </body>
    <script type="text/javascript">
        function forwardIndex() {
            window.location.href = "/user/index";
        }
    </script>
</@html>