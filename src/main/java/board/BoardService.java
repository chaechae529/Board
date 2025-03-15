package board;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private List<Post> postsList = new ArrayList<>();
    private int postIdCounter = 1;

    public void create(String title, String content) {
        postsList.add(new Post(title, content, postIdCounter++));
        System.out.println("게시글이 작성되었습니다.");
    }

    public Post findById(int id) {
        for (Post post : postsList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List<Post> findAll() {
        return postsList;
    }

    public void update(String title, String content, int id) {
        Post updatePost = findById(id);
        updatePost.setTitle(title);
        updatePost.setContent(content);
        System.out.println(id + "번 게시글이 수정되었습니다.");
    }

    public void delete(int id) {
        Post deletePost = findById(id);
        postsList.remove(deletePost);
        System.out.println(id + "번 게시글이 삭제되었습니다");
    }




}

/*
기본적인 CRUD 메소드들이 포함됨
 - 추가 조회(특정, 전체) 갱신 삭제
 - 그 외 (정렬, 키워드 검색, 개수 반환...)
 */