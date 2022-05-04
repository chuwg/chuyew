package com.tistory.roobistory.chuyew.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data // lombok 사용하기 위해서
@AllArgsConstructor // 전체 필드를 파라미터로 가지고 오기 위해서

public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}
