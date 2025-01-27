package ObjectPrc;

import java.util.Date;

public class Article {
    int articleId;
    String title;
    String content;
    int userSeq;
    int viewCnt;
    Date regDate = new Date();

    Article(){

    }

    public Article(int articleId, String title, String content, int userSeq, int viewCnt) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.userSeq = userSeq;
        this.viewCnt = viewCnt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userSeq=" + userSeq +
                ", viewCnt=" + viewCnt +
                ", regDate=" + regDate +
                '}';
    }
}
