package ObjectPrc;

public class ProductReview {

    int reviewId;
    String pCode;
    String writer;
    String content;

    public ProductReview(){

    }

    public ProductReview(int reviewId, String pCode, String writer, String content) {
        this.reviewId = reviewId;
        this.pCode = pCode;
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "reviewId=" + reviewId +
                ", pCode='" + pCode + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
