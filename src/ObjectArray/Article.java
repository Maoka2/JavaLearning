package ObjectArray;
import java.util.Date;
public class Article {

    private int articleId;
    private String content;
    private int userSeq;
    private int viewCnt;
    private Date regDate;

    Article(){

    }

    public Article(int articleId, String content, int userSeq, int viewCnt) {
        this.articleId = articleId;
        this.content = content;
        this.userSeq = userSeq;
        this.viewCnt = viewCnt;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getContent() {
        return content;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", content='" + content + '\'' +
                ", userSeq=" + userSeq +
                ", viewCnt=" + viewCnt +
                ", regDate=" + regDate +
                '}';
    }
}

