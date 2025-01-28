package ObjectArray;

public class RestaurantTest {
    public static void main(String[] args) {
        Restaurant r1 = new Restaurant(1,"name1","address1","signature1",5);
        Restaurant r2 = new Restaurant(2,"name2","address2","signature2",4);
        Restaurant r3 = new Restaurant(3,"name3","address3","signature3",3);
        RestaurantManager rm = new RestaurantManager();

        rm.addRestaurant(r1);
        rm.addRestaurant(r2);
        System.out.println("***** Restaurant List *****");
        for(Restaurant r : rm.getRestaurantList()){
            System.out.println(r);
        }
        System.out.println("***** Restaurant Update *****");
        rm.updateRestaurant(r3);


        for(Restaurant r : rm.getRestaurantList()){
            System.out.println(r);
        }

        Review re1 = new Review(1,1,"writer1","content1");
        Review re2 = new Review(2,2,"writer2","content2");

        rm.addReview(re1);
        rm.addReview(re2);
        System.out.println("***** Review *****");
        for(Review re : rm.getRestaurantReview(1)){
            System.out.println(re);
        }
        System.out.println("***** Restaurant Remove");
        rm.removeRestaurant(1);
        for(Restaurant r : rm.getRestaurantList()){
            System.out.println(r);
        }

        rm.removeReview(1);
        System.out.println("***** Review Remove");
        for(Review re : rm.getRestaurantReview(1)){
            System.out.println(re);
        }

        System.out.println("Search by resId");
        rm.searchByresId(1);
        for(Restaurant r : rm.getRestaurantList()){
            System.out.println(r);
        }
    }
}
