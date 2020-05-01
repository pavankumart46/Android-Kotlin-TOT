package youtube.com.vidhvan.jsonplaceholder

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonPlaceHolderService
{
    @GET("posts")
    suspend fun getAllValues():Response<List<Post>>

    @POST("posts")
    suspend fun postValue(@Body post: Post):Response<Post>
}