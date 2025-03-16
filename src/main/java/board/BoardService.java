package board;

import board.exceptions.PostNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardService {
    private List<Post> postsList = new ArrayList<>();
    private int postIdCounter = 1;

    public void create(String title, String content) {
        postsList.add(new Post(title, content, postIdCounter++));
        System.out.println("게시글이 작성되었습니다.");
    }


    public Optional<Post> findById(int id) {
        return postsList.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    public List<Post> findAll() {
        return postsList;
    }

    public void update(String title, String content, int id) {
        Post updatePost = findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        updatePost.setTitle(title);
        updatePost.setContent(content);
        System.out.println(id + "번 게시글이 수정되었습니다.");
    }

    public void delete(int id) {
        Post deletePost = findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        postsList.remove(deletePost);
        System.out.println(id + "번 게시글이 삭제되었습니다");
    }




}

/*
기본적인 CRUD 메소드들이 포함됨
 - 추가 조회(특정, 전체) 갱신 삭제
 - 그 외 (정렬, 키워드 검색, 개수 반환...)
 */