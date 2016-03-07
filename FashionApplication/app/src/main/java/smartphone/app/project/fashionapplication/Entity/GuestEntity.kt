package smartphone.app.project.fashionapplication.Entity

import smartphone.app.project.fashionapplication.Entity.Item.GuestItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
data class GuestEntity(
        val baseUrl:String,
        val GuestItems: ArrayList<GuestItem>
)
