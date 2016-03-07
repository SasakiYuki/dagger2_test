package smartphone.app.project.fashionapplication.Utils

import smartphone.app.project.fashionapplication.Entity.Item.NewsItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
interface NewsCallBacks {
    fun BaseUrlCallBack(url: String)
    fun NewsListCallBack(list: ArrayList<NewsItem>)
}
