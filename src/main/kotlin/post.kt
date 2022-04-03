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

data class Likes(
    var count: Int,
    var userLikes: Boolean,
    var canLike: Boolean,
    var canPublish: Boolean,
)

data class Repost(
    var count: Int,
    var userReposted: Boolean
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