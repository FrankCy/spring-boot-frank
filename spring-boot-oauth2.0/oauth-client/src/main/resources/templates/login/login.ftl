<#include "../dependent/basic_dependent.ftl">
<@html title="" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <title>请登录 </title>
    </header>
    <body>
        <form action="/login/page" method="POST">
            <div class="form-group">
                <label for="exampleInputEmail1">用户名</label>
                <input id="username" name="username" type="username" class="form-control" placeholder="用户名">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input id="password" name="password" type="password" class="form-control" placeholder="密码">
            </div>
            <div class="checkbox">
                <label>
                    <input id="remember_me" name="remember_me" type="checkbox"> 记住我
                </label>
            </div>
            <input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </body>
</@html>