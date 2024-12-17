package art.shittim

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

@Serializable
data class RequestArticleLine(
    var time: String?,
    val contrib: String,
    val line: String,
    val unsure: Boolean,
    val sensitive: Boolean,
)

val client = OkHttpClient()

fun submit(request: RequestArticleLine, token: String) {
    val request = Request.Builder()
        .url("https://classics.shittim.art/line/append")
        .post(Json.encodeToString(request).toRequestBody("application/json".toMediaTypeOrNull()))
        .header("Authorization", "Bearer $token")
        .build()

    val response = client.newCall(request).execute()
}