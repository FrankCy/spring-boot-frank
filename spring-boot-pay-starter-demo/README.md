# Spring Boot Pay Starter Demo
- - -
## 简介
自定义Pay Starter的使用用例程序
- 路径
/src/test/com/frank/boot/pay/starter/service/impl/PayServiceImplTest

## 如何使用
修改application.yml，需要哪个支付，修改mode就可以，就会执行对应支付系统
```yaml
pay:
  config:
    # 银联支付
    mode: BANK
    # 微信支付
#    mode: WECHAT
    # 支付宝支付
#    mode: ZHIFUBAO
```