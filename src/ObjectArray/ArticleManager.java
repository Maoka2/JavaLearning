package ObjectArray;

import java.util.Arrays;

public class ArticleManager {

    private final static int MAX_ARTICLE_SIZE = 1000;
    private int articleSize = 0;
    private Article[] articles = new Article[MAX_ARTICLE_SIZE];

    public void addArticle(Article article) {
        if (articleSize < MAX_ARTICLE_SIZE) {
            articles[articleSize] = article;
            articleSize++;
        }
    }

    public Article[] getArticleList() {
        Article[] aList = new Article[articleSize];
        aList = Arrays.copyOf(articles, articleSize);
        return aList;

    }

    public void removeArticle(int articleId) {
        for (int i = 0; i < articleSize; i++) {
            if (articles[i].getArticleId() == articleId) {
                for (int j = 0; j < articleSize - 1; j++) {
                    articles[j] = articles[j + 1];
                }
                articles[articleSize -1] = null;
                articleSize--;
            }
        }
    }

    public Article getArticle(int articleId){
        int index = 0;
        for(int i = 0; i < articleSize; i++){
            if(articles[i].getArticleId() == articleId){
                index = i;
            }
        }
        return articles[index];
    }
}
