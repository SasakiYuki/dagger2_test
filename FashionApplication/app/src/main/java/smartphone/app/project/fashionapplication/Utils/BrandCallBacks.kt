package smartphone.app.project.fashionapplication.Utils

import smartphone.app.project.fashionapplication.Entity.Item.BrandItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
interface BrandCallBacks {
    fun BaseUrlCallBack(url: String)
    fun BrandListCallBack(list: ArrayList<BrandItem>)
}
