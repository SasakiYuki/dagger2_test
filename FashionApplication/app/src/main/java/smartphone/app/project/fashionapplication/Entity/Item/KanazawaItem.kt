package smartphone.app.project.fashionapplication.Entity.Item

import com.google.gson.annotations.SerializedName

/**
 * Created by Yuki on 2016/03/05.
 */
class KanazawaItem {

    val group: String? = null

    @SerializedName("date_from")
    val dataFrom: String? = null

    @SerializedName("date_to")
    val dataTo: String? = null

    val dates: List<String>? = null

    val title: String? = null

    val link: String? = null

    val description: String? = null

    val images: List<String>? = null
}
