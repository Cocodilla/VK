data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = false
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = true
)

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val date: Long,
    val text: String = "",
    val friendsOnly: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val views: Int = 0,
    val postType: String = "post",
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val likes: Likes = Likes(),
    val comments: Comments = Comments()
)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        for ((index, existing) in posts.withIndex()) {
            if (existing.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }
}

fun main() {}