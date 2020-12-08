<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>NETTY SOCKET.IO DEMO</title>
    <base>
    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/socket.io/2.2.0/socket.io.js"></script>
    <style>
        body {
            padding: 20px;
        }
        #console {
            height: 450px;
            overflow: auto;
        }
        .username-msg {
            color: orange;
        }
        .connect-msg {
            color: green;
        }
        .disconnect-msg {
            color: red;
        }
    </style>
</head>

<body>
<div id="console" class="well"></div>
<button id="btnSend" onclick="send()">发送数据</button>
</body>
<script type="text/javascript">
    var socket;
    connect();

    function connect() {
        var loginUserNum = '79';
        var opts = {
            query: 'loginUserNum=' + loginUserNum
        };
        socket = io.connect('http://localhost:9099', opts);
        socket.on('connect', function () {
            console.log("连接成功");
            serverOutput('<span class="connect-msg">连接成功</span>');
        });
        socket.on('push_event', function (data) {
            output('<span class="username-msg">' + data + ' </span>');
            console.log(data);

        });

        socket.on('disconnect', function () {
            serverOutput('<span class="disconnect-msg">' + '已下线! </span>');
        });
    }

    function output(message) {
        var element = $("<div>" + " " + message + "</div>");
        $('#console').prepend(element);
    }

    function serverOutput(message) {
        var element = $("<div>" + message + "</div>");
        $('#console').prepend(element);
    }

    function send() {
        console.log('发送数据');
        socket.emit('text','你好');
    }


</script>
</html>