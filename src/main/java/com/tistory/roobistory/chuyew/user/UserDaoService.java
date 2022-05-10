package com.tistory.roobistory.chuyew.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// 도메인 정보를 이용해서 사용자 전체 목록 조회라던가
// 사용자 정보 추가, 사용자 정보 상세보기와 같은 비지니스 로직을 추가할 때 Service
// 라는 클래스에 일반적으로 추가한다.

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1,"woong", new Date()));
        users.add(new User(2,"Nang", new Date()));
        users.add(new User(3,"Tae", new Date()));
        // db에 3명의 데이터가 들어있다고 가정한다.
    }
    public List<User> findAll() {
        return users;
        //사용자 전체 데이터
    }
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;

    }
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return  null;
    }

}