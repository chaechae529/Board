package board.repository;

import board.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryPostRepository implements PostRepository {
    private static int nextId = 1;
    private final List<Post> postList = new ArrayList<>();

    @Override
    public Post save(Post post) {
        post.setId(nextId++);
        postList.add(post);
        return post;
    }

    @Override
    public Optional<Post> findById(int id) {
        return postList.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    // postList를 직접 반환하면 내부 저장소 리스트가 영향 받을 수 있음
    @Override
    public List<Post> findAll() {
        return new ArrayList<>(postList);
    }

    @Override
    public void delete(Post post) {
        postList.remove(post);
    }

    @Override
    public void update(Post post) {
        findById(post.getId()).ifPresent(existingPost -> {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
        });
    }
}
