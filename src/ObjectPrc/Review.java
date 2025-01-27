package ObjectPrc;


public class Review {

    int reviewid;
    int resId;
    String writer;
    String content;

    Review(){

    }

    Review(int reviewid, int resId,String writer, String content){
        this.reviewid = reviewid;
        this.resId = resId;
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewid=" + reviewid +
                ", resId=" + resId +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
