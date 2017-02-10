#RecyclerView的简单使用

***

##功能及页面介绍

* **实现的功能：**CircleImageView的应用，RecyclerView的简单列表页、下拉刷新功能(上拉加载还未全部完成，实现后更新)以及点击Intent页面跳转
* **APP页面：**<br>

**（1）** 刷新界面<br>
![](/First_Term/wanjian/Work2_RecyclerView//pictures/picture1.png)<br>


**（2）** 点击item跳转后的界面<br>

![](/First_Term/wanjian/Work2_RecyclerView/pictures/picture2.png)<br>


##内容介绍

* **布局文件（三个）：**main_activity布局文件使用SwipeRefreshLayout（刷新作用）内嵌套一个RecyclerView（此处注意SwipeRefreshLayout和RecyclerView都应把包名路径写全）；fruititemactivity布局文件为一个CircleImageView（使图像变成圆形）加上一个TextView即可；secondactivity很简单，只有一个Button控件。<br>
  >**注意需要在gradle（app）的dependencies中导入compile 'com.android.support:recyclerview-v7:25.1.0'和compile 'de.hdodenhof:circleimageview:2.1.0'两个包**<br>


* **Activity文件：**Fruit类声明了一个Fruit类，SecondActivity内有一个Button，实现intent到MainActivity。FruitAdapter内自定义了一个适配器，将数据传出；MainActivity中使用swipeRefresh实现刷新功能。（详情见代码）<br>

##遇到的一些坑···
* 开始布局时CircleImageView和TextView没有在preview上显现，以为布局有问题就去改···听学长解释原来是没传入数据才是这样···
* RecyclerView实现Intent跳转，Intent即使监听好了也老是报错，后来去[stackoverflow](http://stackoverflow.com/)上查才知道RecyclerView不能使用intent直接跳转，改了下代码才解决了。
* 写的时候老是报错，，，好多时间都花在改bug上面。反思了一下，一是因为自己是对RecyclerView等不够了解，写起来就经常出错；二是因为自己对方法一些了解不够，也有代码写的少的原因，有时候能够明白运行机制但是不能够敲出代码实现。。。

##收获

* 首先是学了RecyclerView了解增加了不少，也了解了CircleImageView以及下拉刷新和上拉加载功能的实现；不过对RecyclerView adapter中的Viewholder了解还不够，需加强；
* **其次是发现自己对方法实现这方面很薄弱，基础太弱，需要加强。**
