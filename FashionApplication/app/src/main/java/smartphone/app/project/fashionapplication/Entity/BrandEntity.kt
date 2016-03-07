package smartphone.app.project.fashionapplication.Entity

import smartphone.app.project.fashionapplication.Entity.Item.BrandItem
import java.util.*

/**
 * Created by Yuki on 2016/03/05.
 */
data class BrandEntity(
        val baseUrl:String,
        val brandItems: ArrayList<BrandItem>
)
