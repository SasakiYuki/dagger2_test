package smartphone.app.project.fashionapplication.Utils

import smartphone.app.project.fashionapplication.Entity.Item.GuestItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
interface GuestCallBacks {
    fun BaseUrlCallBack(url: String)
    fun GuestListCallBack(list: ArrayList<GuestItem>)
}
