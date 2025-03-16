package board.controller;

import board.service.PostService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateController {
    private PostService postService;

    public CreateController(PostService postService) {
        this.postService = postService;
    }

    public void createPost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("제목을 입력하세요: ");
        String title = br.readLine();
        System.out.print("내용을 입력하세요: ");
        String content = br.readLine();

        postService.createPost(title, content);
    }
}
