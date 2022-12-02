package com.example.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data // lombok 이 멤버변수 제외하고 관리해줌! -> 나는 멤버변수만 만들면 됨.
public class Article {
    // db 보고 멤버변수 만들면 됨
    // 멤버변수 : 접근제한자 - 타입 - 변수명
    // 변수 직접 쓸 수 없도록 private 씀
    // int 는 기본형 Integer는 객체에서 씀 = <Integer>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // pk(구별이 되고 중요한 데이터)
    // lombok 에서는 pk 를 따로 표시 해줌!!
    // 안적는다고 문제되지않지만 어노테이션으로 정확하게 쓰는 것.. 라이브러리가 아니고 프레임워크 니까 ! ㅎㅎ
    private String subject;
    private String content;

}
