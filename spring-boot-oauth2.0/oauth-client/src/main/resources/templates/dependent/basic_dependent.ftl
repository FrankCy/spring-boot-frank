<#macro html title charset="utf-8" lang="zh-CN">
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html lang="en" dir="ltr" xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Meta, title, CSS, favicons, etc. -->
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <meta name="description" content="">
            <meta name="keywords" content="" />

            <!-- Bootstrap -->
            <link href="../../css/bootstrap.css" rel="stylesheet">
            <link href="../../css/bootstrap-theme.css" rel="stylesheet">
            <script src="../../js/jquery.min.js" type="text/javascript"></script>
            <script src="../../js/bootstrap.js" type="text/javascript"></script>
        </head>
        <body>
            <#nested>
        </body>
    </html>
</#macro>