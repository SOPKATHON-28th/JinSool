package response

import com.google.gson.annotations.SerializedName

data class ResponseData(
    val status : String,
    val success : Boolean,
    val message : String,
    val data : Data?

){
    data class Data(

        val penaltyIdx : Int,


    )
}
