package com.busanit.grp.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter // lombok 이 getter setter 해줌
@Getter
public class Employee {
    //멤버변수
    private long id;
    private String username;
    private String email;
    private String passwd;
}
