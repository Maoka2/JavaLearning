package ObjectPrc;

import java.util.Date;

public class Comment {

    int commentId;
    int articleId;
    int userSeq;
    String content;
    Date regDate = new Date();


    Comment(){

    }

    public Comment(int commentId, int articleId, int userSeq, String content) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userSeq = userSeq;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", articleId=" + articleId +
                ", userSeq=" + userSeq +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
