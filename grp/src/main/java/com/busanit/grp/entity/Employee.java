package com.busanit.grp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter // lombok 이 getter setter 해줌
@Getter
@NoArgsConstructor // default 생성자 (파라미터가 없는 생성자) 는 생략하겠다
@AllArgsConstructor // 파라미터가 있는 생성자들도 모두 생략하겠다. = 밑에 안써도 되게 됨..
@Table(name="employees") // Model과 저장할 db를 매칭 (name="테이블이름")
public class Employee {
    //멤버변수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // primary ket, identify(구분해주는 값)
    @Column(name = "username") // name = 데이터베이스 컬럼명
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "passwd")
    private String passwd;


    //생성자


    //접근제한자 데이터타입 메소드명(){}
    //접근제한자 메소드명(Args = arguments){}
    //new String(); = default
    //new String('1','2') = argument가 두개



}
