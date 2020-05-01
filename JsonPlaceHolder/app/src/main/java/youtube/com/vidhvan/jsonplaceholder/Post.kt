package youtube.com.vidhvan.jsonplaceholder

import java.io.Serializable

data class Post(
	val id: Int? = null, //This will be automatically generated, we need not to send it
	val title: String? = null,
	val body: String? = null,
	val userId: Int? = null
)