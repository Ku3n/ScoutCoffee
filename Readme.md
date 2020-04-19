# 侦察咖啡

侦察咖啡共有三个组成部分，分别是：子域名扫描、端口扫描、目录扫描，扫描方式为访问爆破，均为多线程操作。内置从github收集的字典，方便大家扫描。

字典位于各对应文件夹中。
![](http://m.qpic.cn/psc?/V128qQJn2nGVoZ/ubiEST8aMMlZjEEUGVmWIq5g1OK1xbOp.v4F50xAiuZfBBhjy*1V3V1*cY1erP2Rc6ot3Y6RFGteyLYoo.E0zV4kE1vX1QR83leZ52u86qc!/b&bo=iAIpAQAAAAADF5A!&rf=viewer_4&t=5)


## 子域名扫描
![](http://m.qpic.cn/psc?/V128qQJn2nGVoZ/6Q9GUvwNirBpvfZFfWE*4OSPTNOCGJsolOO9ffh.VkFx30X8*YvX1flIj5x0.MUG0zP1aUEDr68qnfAfDR4WUg!!/b&bo=8AEOAgAAAAADB98!&rf=viewer_4)

#### 线程与延时
默认为10，延时默认为0，修改后点击设置确定更改，建议使用200线程，速度较快。此线程为每一个域名的线程，也就是说当线程设置为200，域名数量为2时，真实线程数为200 * 2 ，以实现更快的速度。

#### 输入或导入域名
域名可直接书写，一个域名占据一行，导入的txt文件，格式也是如此。域名格式要求为host，也就是`baidu.com`，`taobao.com`。

#### 选择字典
在subdomain的文件夹下提供了多个子域名字典，在点击开始爆破前，**一定要先指定字典**

#### 导出子域名
点击导出子域名，可以将子域名框中所有子域名导出。

## 目录扫描
![](http://m.qpic.cn/psc?/V128qQJn2nGVoZ/6Q9GUvwNirBpvfZFfWE*4Ksa5EvModehbUK8u312PgX3.zgIeRG2tNVBfhPdcqJAGNchy3Ng7z65h7haLB0OYg!!/b&bo=8AEMAgAAAAADB90!&rf=viewer_4)

#### 输入URL
URL只能输入一条，格式为`www.baidu.com`，必须加上www。

#### 导入字典
在开始前必须导入字典，提供的字典在`src\directory`目录下

#### 线程与延时
默认线程为10，延时为0，更改后点击设置按钮进行确定

#### 200
勾选200选项，仅返回状态为200的目录。

## 端口扫描
![](http://m.qpic.cn/psc?/V128qQJn2nGVoZ/6Q9GUvwNirBpvfZFfWE*4HEHtrBLa7hQPD0NXRW3DN2qWOfbymx*RW.nbxXL9Ex4BiZ7mqF3v1qZZHy1d.PdGQ!!/b&bo=8QEMAgAAAAADB9w!&rf=viewer_4)

#### 导入host或IP
必须通过导入才能添加，文件格式为txt，一行一个host（如baidu.com）或IP（192.168.0.1）

#### 线程与延时与端口最大值
线程默认为10，延时为0，扫描的端口最大值默认为100，端口最大值直接修改即可，线程与延时需通过设置进行确定。