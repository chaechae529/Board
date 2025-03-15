package board.controller;

import board.BoardService;
import board.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ReadController {
    private BoardService boardService;

    public ReadController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void readPostbyId() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("어떤 게시물을 조회할까요? ");
        int readId = Integer.parseInt(br.readLine());

        Post findPost = boardService.findById(readId);

        if (findPost == null){
            System.out.println(readId + "번 게시글은 존재하지 않습니다");
            return;
        }

        System.out.println("제목: " + findPost.getTitle());
        System.out.println("내용: " + findPost.getContent());


    }

    public void readPostAll()  {
        List<Post> postList = boardService.findAll();
        StringBuilder sb = new StringBuilder();

        for (Post post : postList) {

            sb.append(post.getId()).append("번 게시글").append("\n");
            sb.append("제목: ").append(post.getTitle()).append("\n");
            sb.append("내용: ").append(post.getContent()).append("\n");
            sb.append("\n");

        }

        System.out.println(sb);

    }


}
