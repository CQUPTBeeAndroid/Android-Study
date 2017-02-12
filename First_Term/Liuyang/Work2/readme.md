##实现的功能
 * 使用RecyclerView代替ListView的列表页
 * 使用圆形图像
 * 页面的跳转
 * 配合Swiperefreshlayout 实现下拉刷新，上拉加载
 * 分割线

##遇到的问题
 * 在做下拉刷新的时候，在刷新结束之后，重新建了一个adapter，所以导致刷新之后的item无法点击，不能实现监听事件。后来去掉之后，运行正常了。
 * 在导入圆形图像包的时候，在网上下载的是第三方包，按照正常导入之后，发现并不能正常使用。之后，在网上搜索到导包的方法不一样了，最新导包方法直接在gradle里面加入就行，之后运行正常。

##收获
 * RecyclerView逻辑更加的熟悉
 * 圆形切图工具的使用
 * 以前学习RecyclerView的时候总是卡在下拉刷新和上拉加载，这次因为RecyclerView的逻辑更加清晰了，而且也问了学长，搜索了很多。终于使用Swiperefreshlayout实现了RecyclerView的下拉刷新和上拉加载，理解了Swiperefreshlayout里面是如何实现的拉下刷新和上拉加载。
 * RecyclerView的点击监听事件，因为RecyclerView并不像LisrView一样自带了点击监听事件的方法，而是要自己去添加实现。在adapter中定义接口，然后在onBindViewHolder中去为holder.itemView去设置相应 
的监听最后回调我们设置的监听。
 * 分割线的绘制