package ObjectArray;

public class CommentManager {

    private final static int MAX_COMMENT_SIZE = 1000;
    private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
    private int commentSize = 0;

    public void addComment(Comment comment) {
        if (commentSize < MAX_COMMENT_SIZE) {
            comments[commentSize] = comment;
        } else {
            System.out.println("코멘트 최대 개수 초과");
            return;
        }
    }

    void removeComment(int commentId) {
        for (int i = 0; i < commentSize; i++) {
            if (comments[i].getCommentId() == commentId) {
                for (int j = 0; j < commentSize - 1; j++) {
                    comments[j] = comments[j + 1];

                }
                comments[commentSize - 1] = null;
                commentSize--;
            }
        }
    }

    public void removeArticle(int articleId) {

        for (int i = 0; i < commentSize; i++) {
            if (comments[i].getArticleId() == articleId) {
                comments[i] = null;
            }
        }
    }

    Comment[] getCommentList(int articleId) {
        int count = 0;
        for(int i = 0; i < commentSize; i++){
            if(comments[i].getArticleId() == articleId){
                count++;
            }
        }
        Comment[] cList = new Comment[count];
        for(int i = 0; i < commentSize; i++){
            if(comments[i].getArticleId() == articleId){
                cList[i] = comments[i];
            }
        }
        return cList;
    }

}
