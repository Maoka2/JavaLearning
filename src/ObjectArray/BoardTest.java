package ObjectArray;

import java.util.*;
public class BoardTest {
    public static void main(String[] args) {

        System.out.println("----------------------------------------");
        System.out.println("게시판 접속");
        System.out.println("----------------------------------------");
        System.out.println("작업을 선택하세요.");
        System.out.println("1. 로그인 \n2. 회원가입\n0. 종료");

        Scanner sc = new Scanner(System.in);


        UserManager um = new UserManager();
        switch(sc.nextInt()){

            case 1:

                um.login(sc.nextLine(),sc.nextLine());
                break;
            case 2:
                um.signup(new User());
                break;
            case 3:
                break;
        }

        ArticleManager am = new ArticleManager();
        CommentManager cm = new CommentManager();
        System.out.println("----------------------------------------");
        System.out.println("게시글 목록\n 0 공지사항\n1 코딩테스트란 \n2 취뽀는 나에게\n3 Java 완전정복 ");
        System.out.println("----------------------------------------");
        System.out.println("1. 게시글 작성\n2. 게시글 선택\n3. 로그아웃\n0. 종료");
        System.out.println("----------------------------------------");

        switch(sc.nextInt()){
            case 1:
                am.addArticle(new Article());
                break;

            case 2:
                int n = sc.nextInt();
                System.out.println(am.getArticle(n));
                System.out.println("----------------------------------------");
                Comment[] coList = cm.getCommentList(n);
                System.out.println("총 댓글의 수 : " + coList.length);
                for(Comment c : coList){
                    System.out.println(c);
                }
                break;

            case 3:
                um.logout();
                break;

            case 0:
                break;
        }

        System.out.println("----------------------------------------");
        System.out.println("1. 게시글 삭제\n2. 댓글 작성\n3. 댓글 삭제\n0. 종료");

        switch(sc.nextInt()){
            case 1:
                int n = sc.nextInt();
                am.removeArticle(n);
                cm.removeComment(n);
                break;

            case 2:
                cm.addComment(new Comment());
                break;

            case 3:
                int commentId = sc.nextInt();
                cm.removeComment(commentId);
                break;

            case 0:
                break;
        }

    }
}
