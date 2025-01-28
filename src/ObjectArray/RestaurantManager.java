package ObjectArray;


import java.lang.reflect.Array;
import java.util.*;

public class RestaurantManager {

    private static final int MAX_RESTAURANT_SIZE = 100;
    private static final int MAX_REVIEW_SIZE = 1000;

    private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
    private Review[] reviews = new Review[MAX_REVIEW_SIZE];
    private int restaurantSize = 0;
    private int reviewSize = 0;

    boolean addRestaurant(Restaurant restaurant) {
        if(restaurantSize < MAX_RESTAURANT_SIZE) {
            restaurants[restaurantSize] = restaurant;
            restaurantSize++;
            return true;
        }else {
            return false;
        }
    }

    boolean addReview(Review review) {
        if(reviewSize < MAX_REVIEW_SIZE) {
            reviews[reviewSize] = review;
            reviewSize++;
            return true;
        }else {
            return false;
        }
    }

    boolean updateRestaurant(Restaurant restaurant) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(restaurants[n-1] != null) {
            restaurants[n-1] = restaurant;
            return true;
        } else {
            return false;
        }

    }

    boolean removeRestaurant(int resId) {
        for (int i = 0; i < restaurantSize; i++) {
            if (restaurants[i].getResId() == resId) {
                for (int j = i; j < restaurantSize - 1; j++) {
                    restaurants[j] = restaurants[j + 1];
                }
                restaurants[restaurantSize - 1] = null;
                restaurantSize--;
                return true;
            }
        }
        return false;
    }

    Restaurant[] getRestaurantList(){
        Restaurant[] rList = new Restaurant[restaurantSize];

        rList = Arrays.copyOf(restaurants,restaurantSize);
        return rList;
    }



    boolean removeReview(int reviewId) {
        for (int i = 0; i < restaurantSize; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                for (int j = i; j < reviewSize - 1; j++) {
                    reviews[j] = reviews[j + 1];
                }
                reviews[reviewSize - 1] = null;
                reviewSize--;
                return true;
            }
        }
        return false;
    }

    Restaurant searchByresId(int resId) {
        int idx = 0;
        for(int i = 0; i < restaurantSize; i++){
            if (restaurants[i].getResId() == resId){
                idx = i;
            }
        }
        return restaurants[idx];
    }

    Review[] getRestaurantReview(int resId){
        int count = 0;
        for(int i = 0; i < reviewSize; i++){
            if(reviews[i].getResid() == resId){
                count++;
            }
        }

        Review[] reviewList = new Review[count];
        int index = 0;
        for(int i = 0; i < reviewSize; i++){
            if(reviews[i].getResid() == resId){
                reviewList[index] = reviews[i];
                index++;
            }
        }
        return reviewList;
    }

}
