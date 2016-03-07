package smartphone.app.project.fashionapplication.Utils

import smartphone.app.project.fashionapplication.Entity.Item.KanazawaItem

/**
 * Created by Yuki on 2016/03/05.
 */
interface KanazawaCallBacks {
    fun BaseUrlCallBack(baseUrl: String)
    fun KanazawaItemListCallBack(list: List<KanazawaItem>)
}