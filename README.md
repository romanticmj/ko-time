# koTime

#### 介绍
koTime是一个springboot项目性能分析工具，通过追踪方法调用链路以及对应的运行时长快速定位性能瓶颈：

#### 预览

http://huoyo.gitee.io/ko-time/example

## 文档

http://huoyo.gitee.io/ko-time


优点：
> * 实时监听方法，统计运行时长
> * web展示方法调用链路，瓶颈可视化追踪



缺点：
> * 由于对项目中每个方法进行监控，在性能层面会有一点影响，建议在开发阶段使用



#### 可视化展示

1.接口调用统计

根据颜色判断需要优化的接口数，红色为待优化，绿色为正常

![输入图片说明](https://images.gitee.com/uploads/images/2020/1210/192544_932c9e75_1625471.png "屏幕截图.png")

2.接口列表总览

在列表中会显示该接口的运行耗时，如果为绿色则无需优化，如果为红色，需要详细查看问题所在

![输入图片说明](https://images.gitee.com/uploads/images/2020/1210/192615_192e1123_1625471.png "屏幕截图.png")

3.调用详情

点开接口时，会显示该接口的调用链路以及运行时长

![输入图片说明](https://images.gitee.com/uploads/images/2020/1211/191651_15b5424b_1625471.png "屏幕截图.png")

#### 版本说明

> V1.0：基本功能

> V1.1：接口统计

> V1.2：不可用，错误版本

> V1.3：添加日志、时间阈值可配置

> V1.4：添加koTime.pointcut配置

> V1.5：剔除lombok

> V1.6：兼容thymeleaf

> V1.7：修复未调用接口时No value present异常

> V1.8：支持Mybatis的Mapper监测、新增最大/最小运行时间、修复小数位数过长页面边界溢出的bug

#### 特别说明

1.本项目使用java8开发，其他版本未曾试验，如有什么bug还请告知！



