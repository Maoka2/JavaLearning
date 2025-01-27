package ObjectPrc;

public class RestaurantTest {
    public static void main(String[] args) {

        Restaurant r1 = new Restaurant(101,"을미대","서울","냉면",4);
        Restaurant r2 = new Restaurant(401,"도마29","대구","연어초밥",3);

        System.out.println("********** 맛집 목록 **********");
        System.out.println(r1);
        System.out.println(r2);

        Review rev1 = new Review(1,101,"김사피","너무 맛있네요.");
        Review rev2 = new Review(2,401,"나싸피","연어초밥은 여기가 최고!");
        System.out.println("********** 리뷰 목록 **********");
        System.out.println(rev1);
        System.out.println(rev2);
    }
}
