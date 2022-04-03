var uniqueId: Int = 0

fun main() {

}


data class Post(
    val id: Int = uniqueId + 1,
    val owner_id: Int,
    val from_id: Int,
    val created_by: Int,
    val date: Int,
    var text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    var friendsOnly: Boolean = false,
    var comments: Comments,
    val copyright: Copyright?,
    var likes: Likes,
    var reposts: Repost,
    var views: Views,
    var postType: String,
    val postSource: PostSource?,
    var attachments: ArrayList<Attachment>?,
    var geo: Geo?,
    val signerId: Int?,
    var copyHistory: ArrayList<Post>?,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isPinned: Boolean,
    var markedAsAds: Boolean,
    var isFavorite: Boolean,
    var donut: Donut,
    var postponedId: Int?,
)

data class Comments(
    var count: Int,
    var canPost: Boolean,
    var groupsCanPost: Boolean,
    var canClose: Boolean,
    var canOpen: Boolean,
)

data class Copyright(
    val id: Int,
    var link: String,
    var name: String,
    var type: String,
)

abstract class Like(
    open var count: Int,
    open var userLikes: Boolean
)

data class Likes(
    override var count: Int,
    override var userLikes: Boolean,
    var canLike: Boolean,
    var canPublish: Boolean
) : Like(
    count, userLikes
)

open class Repost(
    open var count: Int,
    open var userReposted: Boolean
)

data class Views(
    var count: Int,
)

data class Donut(
    var isDonut: Boolean,
    var paidDuration: Int,
    var canPublishFreeCopy: Boolean,
    var editMode: String,
)

data class PostSource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)

data class Geo(
    var type: String,
    var coordinates: String,
    var place: Place?
)

data class Place(
    val id: Int,
    var title: String,
    var latitude: Int,
    var longitude: Int,
    var created: Int,
    var icon: String,
    var updated: Int,
    var checkins: Int,
    var type: Int,
    var country: Int,
    var city: Int,
    var address: String,
)

abstract class Attachment(
    open val type: String
)

data class AudioAttachment(val audio: Audio) : Attachment(
    "audio"
) {
    override val type: String
        get() = TODO("Not yet implemented")
}

data class PhotoAttachment(val photo: ExtPhoto) : Attachment(
    "photo"
) {
    override val type: String
        get() = TODO("Not yet implemented")
}

data class VideoAttachment(var video: Video) : Attachment(
    "video"
) {
    override val type: String
        get() = TODO("Not yet implemented")
}

data class DocAttachment(var doc: Doc) : Attachment(
    "doc"
) {
    override val type: String
        get() = TODO("Not yet implemented")
}

data class LinkAttachment(var link: Link) : Attachment(
    "link"
) {
    override val type: String
        get() = TODO("Not yet implemented")
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String?,
    val title: String?,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val noSearch: Boolean,
    val isHq: Boolean,
)

open class Photo(
    open val sizes: ArrayList<Size>,
)

data class ExtPhoto(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    var text: String?,
    val date: Int,
    override val sizes: ArrayList<Size>,
    val width: Int?,
    var height: Int?,
) : Photo(sizes)

data class Size(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int,
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String?,
    val description: String?,
    val duration: Int,
    val image: ArrayList<Image>,
    val firstFrame: ArrayList<Frame>,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int?,
    val comments: Int,
    val player: String?,
    val platform: String?,
    val canAdd: Boolean,
    val accessKey: String,
    val processing: Int,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean,
    val type: String,
    val balance: Int,
    val liveStatus: String,
    val live: Boolean,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: Like,
    val reposts: ExtendRepost,
)

data class Image(
    val height: Int,
    val url: String,
    val width: Int,
    val withPadding: Boolean,
)

data class Frame(
    val height: Int,
    val url: String,
    val width: Int,
)

data class ExtendRepost(
    override var count: Int,
    var wallCount: Int,
    var mailCount: Int,
    override var userReposted: Boolean

) : Repost(
    count,
    userReposted
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    var title: String?,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    var type: Int,
    var preview: Preview
)

data class Preview(
    val photo: Photo,
    val graffiti: Graffiti,
    val audioMessage: AudioMessage
)

data class Graffiti(
    val src: String,
    val width: Int,
    val height: Int,
)

data class AudioMessage(
    val duration: Int,
    val waveform: ArrayList<Int>,
    var linkOgg: String,
    var linkMp3: String
)

data class Link(
    val url: String,
    var title: String?,
    val caption: String?,
    val description: String?,
    val photo: ExtPhoto?,
    val product: Product?,
    var button: Button?,
    val previewPage: String,
    val previewUrl: String
)

data class Product(
    val price: Price
)

data class Price(
    val amount: Int,
    val currency: Currency,
    val text: String
)

data class Currency(
    val id: Int,
    val name: String,
)

data class Button(
    val title: String,
    val action: Action,
)

data class Action(
    val type: String,
    val url: String
)

object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        uniqueId = post.id
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postForUpdate) in posts.withIndex()) {
            if (postForUpdate.id == post.id) {
                val updatePost = post.copy(
                    text = post.text,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
                posts[index] = updatePost
                return true
            }
        }
        return false
    }

    fun clearPosts() {
        posts = emptyArray()
    }
}