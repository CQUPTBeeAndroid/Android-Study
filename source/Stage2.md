# Level 2 小试牛刀
以下部分正式进入 Android 学习阶段，还无 Java 基础的同学先把 Java 基础补起来。主要参考书籍为 `第一行代码`，也可以选择视频学习（`慕课网、极客学院`）。


## 任务1 android gradle 的基本使用
- Gradle 是android studio引入的构建工具，我们使用它能方便的进行开发
- 参考资料
	- [Android Gradle 基础](http://stormzhang.com/devtools/2014/12/18/android-studio-tutorial4/)
	- [给初学者的Gradle知识](http://stormzhang.com/android/2016/07/02/gradle-for-android-beginners/)

## 任务2 android开发命名规范
- 有一个好的命名规范是一个优秀的开发习惯，这样也能让其他人更好读懂你的代码
	- [命名规范](http://blog.csdn.net/vipzjyno1/article/details/23542617)


## 任务2 学习Activity以及基本控件的使用
- Activity的生命周期是每个开发者必须知道的
- 控件作为UI最基础的东西，是入门必学的，相信掌握了它你们已经能开发出有界面的android App了
- 参考资料
	- [Activity 的生命周期](http://blog.csdn.net/android_tutor/article/details/5772285)
	- [基本控件的使用] (http://blog.csdn.net/j903829182/article/details/40660275)
	- [四种基本布局的使用] (http://blog.csdn.net/j903829182/article/details/40663303)

#### 作业： 编写一个计算器
- 基本要求
	- UI 的整洁以及学习的基本控件使用
	- 计算器的基本逻辑
- 提升部分（学有余力）
	- 完善计算器逻辑，`科学计算器`的完善（如括号、开方）
	- 完善用户体验，使用基本的动画
	- 横屏切换计算器，实现普通计算器与科学计算器的转换
	- 自行补充...


## 任务3 ListView的使用
- ListView顾名思义就是列表View，学习它的Viewholder缓存原理有助于大家了解更多的知识
- Intent用于一个组件中启动App中的另一个组件或者是启动另一个App的组件,掌握了它以后我们的app就可以展示多个页面了
- 参考资料
	- [ListView基本使用] (http://www.jianshu.com/p/0c4d6cdc4e10)
	- [Intent 使用](http://blog.csdn.net/iispring/article/details/48417779)

#### 作业：校园说App 的分享家列表页（数据自行模拟）
- 基本要求
	- 完成基本的 ListView 列表页
	- 圆形图像的运用（CircleImageView）
	- 跳转界面，自行设计（如分享家的具体设计）
- 提升部分
	- 运用 RecyclerView 代替 ListView
	- 配合下拉刷新控件 Swiperefreshlayout 实现下拉刷新，上拉加载
	- 自行补充...
