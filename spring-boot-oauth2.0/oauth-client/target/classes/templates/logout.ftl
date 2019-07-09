<#include "dependent/basic_dependent.ftl">
<@html title="" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <title>登出</title>
    </header>
    <body>
    <form action="/login/page" method="POST">
        <input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">登出</button>
    </form>
    </body>
</@html>