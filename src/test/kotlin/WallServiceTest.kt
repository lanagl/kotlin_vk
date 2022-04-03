import WallService.add
import WallService.update
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

val post1 = Post(
    owner_id = 1,
    from_id = 6,
    created_by = 1,
    date = 756757865,
    text = "uy , iyuiyu iyu",
    replyOwnerId = 6,
    replyPostId = 7,
    friendsOnly = false,
    comments = Comments(4, canPost = false, groupsCanPost = true, canClose = false, canOpen = false),
    copyright = Copyright(6, link = "jhjkhkh", name = "mkk", type = "jjg"),
    likes = Likes(2, userLikes = false, canLike = false, canPublish = false),
    reposts = Repost(8, false),
    views = Views(7),
    postType = "hkjhgk",
    signerId = 5,
    canPin = false,
    canDelete = true,
    canEdit = false,
    isPinned = false,
    markedAsAds = true,
    isFavorite = false,
    donut = Donut(isDonut = false, paidDuration = 0, canPublishFreeCopy = true, editMode = "glkjl"),
    postponedId = 1,
    attachments = null
)
val post2 = Post(
    id = 1,
    owner_id = 1,
    from_id = 6,
    created_by = 1,
    date = 756757865,
    text = "uy , iyuiyu iyu",
    replyOwnerId = 6,
    replyPostId = 7,
    friendsOnly = false,
    comments = Comments(4, canPost = false, groupsCanPost = true, canClose = false, canOpen = false),
    copyright = Copyright(6, link = "jhjkhkh", name = "mkk", type = "jjg"),
    likes = Likes(2, userLikes = false, canLike = false, canPublish = false),
    reposts = Repost(8, false),
    views = Views(7),
    postType = "hkjhgk",
    signerId = 5,
    canPin = false,
    canDelete = true,
    canEdit = false,
    isPinned = false,
    markedAsAds = true,
    isFavorite = false,
    donut = Donut(isDonut = false, paidDuration = 0, canPublishFreeCopy = true, editMode = "glkjl"),
    postponedId = 1,
    attachments = null
)
val post3 = Post(
    id = 888888,
    owner_id = 1,
    from_id = 6,
    created_by = 1,
    date = 756757865,
    text = "uy , iyuiyu iyu",
    replyOwnerId = 6,
    replyPostId = 7,
    friendsOnly = false,
    comments = Comments(4, canPost = false, groupsCanPost = true, canClose = false, canOpen = false),
    copyright = Copyright(6, link = "jhjkhkh", name = "mkk", type = "jjg"),
    likes = Likes(2, userLikes = false, canLike = false, canPublish = false),
    reposts = Repost(8, false),
    views = Views(7),
    postType = "hkjhgk",
    signerId = 5,
    canPin = false,
    canDelete = true,
    canEdit = false,
    isPinned = false,
    markedAsAds = true,
    isFavorite = false,
    donut = Donut(isDonut = false, paidDuration = 0, canPublishFreeCopy = true, editMode = "glkjl"),
    postponedId = 1,
    attachments = null
)

class WallServiceTest {

    @Test
    fun add_1() {
        add(post1)
        val result = uniqueId
        Assert.assertNotEquals(0, result)
    }

    @Before
    fun prepare() {
        add(post1)
    }

    @Test
    fun update_with_id() {
        val result = update(post2)
        Assert.assertEquals(true, result)
    }

    @After
    fun clear() {
        WallService.clearPosts()
    }

    @Test
    fun update_without_id() {
        val result = update(post3)
        Assert.assertEquals(false, result)
    }
}