package board.controller;

import board.service.AccountService;
import board.service.PostService;

import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostController {
    private final PostService postService;
    private final BufferedReader br;

    public PostController(PostService postService) {
        this.postService = postService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void addPost(int boardId) throws IOException {

        System.out.print("제목을 입력하세요: ");
        String title = br.readLine();

        System.out.print("내용을 입력하세요: ");
        String content = br.readLine();

        postService.createPost(boardId, title,content);
        System.out.println("게시글이 작성되었습니다.");

    }

    public void removePost(int postId)  {
        postService.delete(postId);
        System.out.println("게시글이 삭제되었습니다.");
    }

    public void editPost(int postId) throws IOException {
        System.out.print("제목을 입력하세요: ");
        String title = br.readLine();

        System.out.print("내용을 입력하세요: ");
        String content = br.readLine();

        postService.update(postId, title, content);
        System.out.println("게시글이 수정되었습니다.");
    }

    public void getPostDetail(int postId) {
        System.out.println(postService.getPostDetail(postId));
    }

}
