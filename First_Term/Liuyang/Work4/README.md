##实现的功能
* 利用API解析出数据并且展示
* 无网络时弹出提示
* 使用Okhttp
* 封装网络
* Gilde加载网络图片
* Sharedpreference存储数据，实现缓存功能
 
##遇到的问题
* 在使用sharedpreference存储数据时，因为存储的数据类型是数组，但是不能直接通过Sharedpreference存储数组形式的数据，最后在网上搜索到可以将数据形式的数据转化为JSONArray形式，将JsonArray数据保存。
* 在写代码时候，本来是只有一个MainActivity，但是因为要获取数据，所以需要延迟时间，不知道该怎么办。最终，在MainAcitivity之前加入了一个First页面，在这个页面中获取数据，再延迟跳转到MainActivity。
 
##收获
* Gilde的使用
* Sharedpreference对数据的存储，读取
* 熟悉了Gson解析数据
* 熟悉了网络请求
* 第三方API的了解和使用
* 检测有无网络
* 以前内容的熟练