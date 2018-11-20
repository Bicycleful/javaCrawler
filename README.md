# javaCrawler
现在用Python做爬虫很是盛行，在学Java的本人寻思着Java如何做爬虫。

本爬虫例子为体育彩票网[http://www.sporttery.cn/](http://www.sporttery.cn/)
![在这里插入图片描述](https://img-blog.csdn.net/20181023232846997?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![在这里插入图片描述](https://img-blog.csdn.net/20181023232923159?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 

本例实现对“足球赛果开奖”的爬取；若要对体育彩票站其他页面爬取，稍微修改代码中URL规则即可；若要爬取非体彩网的其他网站，则需要重新分析其站结构，修改其爬取方式。


![在这里插入图片描述](https://img-blog.csdn.net/20181023232944199?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
**进入正题**，编译器为intellij IDEA,大略分析工程构成，上图为其结构：

**所含jar包**:

第一类 jsoup包，为java爬取页面利器，传送门[https://segmentfault.com/a/1190000007967145](https://segmentfault.com/a/1190000007967145)

第二类 poi包，将数据保存为本地word、excel等利器，传送门[http://www.voidcn.com/article/p-odzwqxka-er.html](http://www.voidcn.com/article/p-odzwqxka-er.html)

**所含代码**：

1.main类

完成对足球赛果开奖”页面分析，制定爬取规则。eg页面[http://info.sporttery.cn/football/match_result.php?page=1&search_league=0&start_date=2018-10-21&end_date=2018-10-23&dan=](http://info.sporttery.cn/football/match_result.php?page=1&search_league=0&start_date=2018-10-21&end_date=2018-10-23&dan=) 感兴趣同学可去分析下页面结构。

指挥DownloadWord对象将页面数据爬到中list中。
指挥SaveEveryRow对象将list数据保存本机Excel中。


2.DownloadWord类，需熟悉jsoup包中函数相关函数、对页面源码分析。
将爬取页面的信息保存到自己定义的ArrayList数据结构中.


3. SaveEveryRow类，需熟悉POI包中相关函数、对数据源字符串进行分割。
将ArrayList数据结构数据存放到本机excel文档中。


4.Match类，竞赛基本信息类。
定义的各变量、get、set函数。


**效果**：爬取足球竞彩结果8月22号到10月22号，一共2292条信息，存储到本机D:\try.xls文件中。（注意main方法引用的函数dd.getTime().before(d2)是指在d2时间前，即23号之前指22号、21号等等，所以d2应该多设置一天）

![在这里插入图片描述](https://img-blog.csdn.net/20181023233043516?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
图为页面信息 共2292条信息

![在这里插入图片描述](https://img-blog.csdn.net/20181023233103165?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
图为爬虫运行结束

![在这里插入图片描述](https://img-blog.csdn.net/20181023233121517?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FfQ2h1YW40OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
图为保存到本地Excel，2292条完全保存。

**结语**：用java爬虫相对Python麻烦，但是亦可通过其java各类jar包所提供的功能丰富接口完工，这也是java强大的一点。
每当需要爬取一个站点时，需分析站点结构，然后这个站及其子站基本就是你的了。
