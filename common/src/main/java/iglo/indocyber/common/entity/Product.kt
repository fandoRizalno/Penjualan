package iglo.indocyber.common.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Product(
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("isSelected")
    var isSelected: Boolean
)