package board.service;

import board.domain.Post;
import board.exceptions.PostNotFoundException;
import board.repository.PostRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(int boardId, String title, String content) {
        Post post = new Post();
        post.setId(boardId);
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void update(int id, String title, String content) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        post.setTitle(title);
        post.setContent(content);
        postRepository.update(post);
    }

    public void delete(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        postRepository.delete(post);

    }

    public String getPostDetail(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));

        String createdAt = post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String updatedAt = post.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return String.format(
                "[%d]번 게시글\n작성일: %s\n수정일: %s\n제목: %s\n내용: %s",
                post.getId(),
                createdAt,
                updatedAt,
                post.getTitle(),
                post.getContent()
        );
    }

    //    private List<Post> postsList = new ArrayList<>();
//    private int postIdCounter = 1;
//
//    public void create(String title, String content) {
//        postsList.add(new Post(title, content, postIdCounter++));
//        System.out.println("게시글이 작성되었습니다.");
//    }
//
//
//    public Optional<Post> findById(int id) {
//        return postsList.stream()
//                .filter(post -> post.getId() == id)
//                .findFirst();
//    }
//
//    public List<Post> findAll() {
//        return postsList;
//    }
//
//    public void update(String title, String content, int id) {
//        Post updatePost = findById(id)
//                .orElseThrow(() -> new PostNotFoundException(id));
//        updatePost.setTitle(title);
//        updatePost.setContent(content);
//        System.out.println(id + "번 게시글이 수정되었습니다.");
//    }
//
//    public void delete(int id) {
//        Post deletePost = findById(id)
//                .orElseThrow(() -> new PostNotFoundException(id));
//        postsList.remove(deletePost);
//        System.out.println(id + "번 게시글이 삭제되었습니다");
//    }


}

/*
기본적인 CRUD 메소드들이 포함됨
 - 추가 조회(특정, 전체) 갱신 삭제
 - 그 외 (정렬, 키워드 검색, 개수 반환...)
 */