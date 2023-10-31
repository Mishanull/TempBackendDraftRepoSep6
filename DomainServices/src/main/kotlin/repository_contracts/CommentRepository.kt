package RepositoryContracts

interface CommentRepository {
  fun createComment(comment: Comment)
  fun updateComment(comment: Comment)
  fun deleteComment(commentId: UUID)
  fun getCommentById(commentId: UUID): Comment?
  // Add more methods as needed for specific use cases
}