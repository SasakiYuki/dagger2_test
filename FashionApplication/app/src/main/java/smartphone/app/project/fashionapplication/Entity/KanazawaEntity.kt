package smartphone.app.project.fashionapplication.Entity

import com.google.gson.annotations.SerializedName
import smartphone.app.project.fashionapplication.Entity.Item.KanazawaItem

/**
 * Created by Yuki on 2016/03/05.
 */
class KanazawaEntity {
    @SerializedName("items")
    val kanazawaItemses: List<KanazawaItem>? = null

    @SerializedName("base_url")
    val baseUrll: String? = null
}
