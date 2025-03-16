package board.controller;

import board.service.PostService;
import board.exceptions.PostNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteController {
    private PostService postService;

    public DeleteController(PostService postService) {
        this.postService = postService;
    }

    public void deletePost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("어떤 게시물을 삭제할까요? ");
        int deleteId = Integer.parseInt(br.readLine());

        try {
            postService.delete(deleteId);
        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
