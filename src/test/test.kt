import org.junit.Test
import org.junit.Before
import org.junit.Assert.*

class WallServiceTest {

    @Before
    fun setUp() {
        WallService.clear()
    }

    @Test
    fun add_shouldSetNonZeroId() {
        // Arrange
        val post = Post(
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis()
        )

        // Act
        val result = WallService.add(post)

        // Assert
        assertNotEquals(0, result.id)
    }

    @Test
    fun update_shouldReturnTrueWhenIdExists() {
        // Arrange
        val original = WallService.add(
            Post(
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis()
            )
        )

        val updated = original.copy(text = "Updated text")

        // Act
        val result = WallService.update(updated)

        // Assert
        assertTrue(result)
    }

    @Test
    fun update_shouldReturnFalseWhenIdNotExists() {
        // Arrange
        val nonExistingPost = Post(
            id = 999,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis()
        )

        // Act
        val result = WallService.update(nonExistingPost)

        // Assert
        assertFalse(result)
    }
}