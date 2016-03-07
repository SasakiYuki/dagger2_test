package smartphone.app.project.fashionapplication.Entity

import smartphone.app.project.fashionapplication.Entity.Item.NewsItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
data class NewsEntity (
        val baseUrl:String,
        val newsItems: ArrayList<NewsItem>
)