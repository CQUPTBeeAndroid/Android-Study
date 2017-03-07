#仿微信界面（Fragment+ViewPager+RecyclerView）

****

##功能及页面展示
* 实现的功能：该demo主要是仿微信界面，四个Fragment的跳转、ViewPager的滑动以及RecyclerView内容<br>
* APP界面展示:<br>

![](http://ww4.sinaimg.cn/large/005HNx1Sjw1fclmaue7fmg307m0e0q82.gif)<br>



##内容介绍

* 布局文件：首先是主布局文件，主布局文件包含上方的ViewPager以及下方的四个标题，也即是四个Fragment。注意ViewPager要写全称，下方用的是一个LinearLayout包含四个RelativeLayout，每个RelativeLayout中又包含一个ImageView和一个TextView。其次四个布局为四个Fragment的布局，除了message_Layout包含RecyclerView外，其他三个都很简单只有一个TextView。最后一个布局是message.xml，相当于RecyclerView中的fruit.item.
* Activity文件：首先是主活动MainActivity，其中包含初始化布局元素，标题栏点击事件的响应以及ViewPager的实现。（具体见代码）。其次是四个Fragment，除了MessageFragment包含RecyclerView的实现外其他都只有把布局和Fragment联系在一起的功能。然后是两个Adapter，一个是ViewPager需要的MyFragmentAdapter,一个是RecyclerView需要的MessageAdapter。最后是一个Message类。<br>

>备注：有关RecyclerView相关的知识点可以去前面一个作业查看、记得导入相应的包。还有就是这个demo的一些图片和名称用的是仿QQ的，所以有些命名不太规范，请谅解。

##遇到的一些坑···
* 这次的坑比较多···首先是Fragment和ViewPager结合后，标题栏不随着ViewPager滑动而改变，后来通过检查和查看代码发现是没有监听ViewPager的滑动事件···
* 然后是点击标题栏时，下面的标题栏改变但是上面的布局没有随之改变。
* 还有就是RecyclerView加载出来的item，一个就占了整个页面，，后来发现是message.xml的layout_height=写成了match_parent···就把整个页面覆盖了。
* 还有在Fragment中写RecyclerView，LinearLayoutManager中要传入getActivity，否则传入的是空值，，，这次还碰到了很多的bug···改的好心塞。

##收获

* 首先是对碎片知识的理解和实践，通过和ViewPager的结合使用，以及写的过程中遇到的各种问题查资料，对这两个的使用有了一定的了解。对RecyclerView的运用，重温了其知识点；
* 其次是通过途中不断的写和改错，对一些语法知识点了解的更多了，但是还需要加强。
* 不足之处是写的时候还有一些地方没有理解，是跟着敲出来的，这方面的理解需要加强。还有就是RecyclerView的刷新和加载功能由于时间和理解不够就没有加上去，等回头看的时候补上来。




