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
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Repost,
    val views: Views,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int,
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean,
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String,
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean,
)

data class Repost(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int,
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val canPublishFreeCopy: Boolean,
    val editMode: String,
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
                    from_id = post.from_id,
                    created_by = post.created_by,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    signerId = post.signerId,
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