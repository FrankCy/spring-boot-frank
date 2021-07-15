# Spring Boot ClickHouse
- - -
## 安装ClickHouse（Docker）
```
1、前提
安装 homebrew

2、安装docker
brew install --cask --appdir=/Applications docker
安装完成后在application找到docker图标 启动

3、安装ClickHouse
客户端：docker pull yandex/clickhouse-client
服务端：docker pull yandex/clickhouse-server

4、启动镜像
docker run -d --name ch-server --ulimit nofile=262144:262144 -p 8123:8123 -p 9000:9000 -p 9009:9009 yandex/clickhouse-server

5、连接ClickHouse镜像
我们使用 Datagraid idea内嵌版本
clickhouse默认用户名是defult 没有密码
```





