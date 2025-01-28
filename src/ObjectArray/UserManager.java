package ObjectArray;

import java.util.*;

public class UserManager {

    private final static int MAX_USER_SIZE = 100;

    private User loginUser;

    private User[] users = new User[MAX_USER_SIZE];

    private int userSize = 0;

    public void signup(User user) {
        if (userSize < MAX_USER_SIZE) {
            Scanner sc = new Scanner(System.in);
            User newUser = user;
            System.out.println("아이디 뭐로?");
            newUser.setUserId(sc.nextLine());
            System.out.println("비밀번호 뭐로?");
            newUser.setPassword(sc.nextLine());
            System.out.println("이름?");
            newUser.setUserName(sc.nextLine());
            System.out.println("닉네임?");
            newUser.setNickName(sc.nextLine());
            System.out.println("이메일?");
            newUser.setEmail(sc.nextLine());
            users[userSize] = newUser;
            userSize++;
        } else {
            System.out.println("최대 유저수 초과");
        }

    }

    public User login(String id, String password) {
        int idx = 0;
        for (int i = 0; i < userSize; i++) {
            if (users[i].getUserId().equals(id) && users[i].getPassword().equals(password)) {
                System.out.println("로그인 성공");
                System.out.println(id + "님 환영합니다.");
                idx = i;
                this.loginUser = users[idx];
                return loginUser;

            }

        }
        System.out.println("로그인 실패");
        return null;
    }

    public User getLoginUser() {
        return this.loginUser;
    }

    public void logout(){
        if(this.loginUser != null){
            System.out.println(this.loginUser.getUserId() + "님 로그아웃 되었습니다.");
        } else{
            System.out.println("로그인 되어있지 않습니다.");
        }
    }

    public User getUser(int userSeq) {
        int index = 0;
        for (int i = 0; i < userSize; i++) {
            if (users[i].getUserSeq() == userSeq) {
                index = i;
                break;
            }
        }
        return users[index];
    }


}
