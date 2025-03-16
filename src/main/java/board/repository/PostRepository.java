package board.repository;

import board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(int id);
    List<Post> findAll();
    void delete(Post post);
    void update(Post post);

}
