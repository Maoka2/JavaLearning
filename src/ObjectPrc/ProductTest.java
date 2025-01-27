package ObjectPrc;

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("R00001","S냉장고",1000000,20,"삼성","삼성에서 출시한 스마트냉장고 입니다");
        Product p2 = new Product("P00001","우주폰S",500000,100,"삼성","삼성에서 출시한 우주폰S입니다" );

        System.out.println("********** 제품목록 **********");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("********** 리뷰내용 **********");

        ProductReview pr1 = new ProductReview(1,"P00001","yang","성능이 아주 좋습니당~!");
        System.out.println(pr1);
    }
}
