package B6R4EduardoGuerrero.B6R4EduardoGuerrero.Repositories;

import B6R4EduardoGuerrero.B6R4EduardoGuerrero.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
