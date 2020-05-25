学习笔记

1. Hash

   Hash函数，传入值，返回一个整型数，传入不同的值，返回的int值相同就叫Hash碰撞，解决方法就是多一个维度，在对应key的值上放一个双向链表，这就叫做拉丝碰撞解决法

2. Java中HashSet

   HashSet底层是以HashMap实现的，将key放值，有去重的作用，value放一个固定值

   ![image-20200525233135032](E:\work_idea\study\algorithm009-class02\img\image-20200525233135032.png)

3. Java中HashMap的实现