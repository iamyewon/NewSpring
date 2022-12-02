package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 어노테이션은 기능을 부여 or 의존성 주입 (new 객체명())
// 파일 전체를 관리 (주소 관리)
@RequestMapping("/users") // 주소가 /users/~~ 로 계속 /users가 사용되니까,
public class WelcomeController {

    @GetMapping("/welcome") // PostMapping 도 있음
    // 여기 주소를 쓰면 이 아래의 내용이 보임
    // 접근제한자 데이터타입(반환형) 메소드명(파라미터)
    // 타입 과 리턴 타입을 정확히 적어줘야함.
    // void 쓰면 return이 없음.
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/all")
    public int all() {
        return 100;
    }

    @GetMapping("/debug")
    public void debug(){
        System.out.println("debug 주소 확인");
    }

    /*
    db에 저장 -> userid, passwd
    ->>>>>> getter(출력) ->>>>>> setter(저장) ->>>>>> db 에 저장
    객체지향은 꼭 getter와 setter를 거쳐서 감
    */


    /*
    1명 표시할 때 : 상세보기 - 1명 표시 할 때는 getter, setter 같은 객체를 사용

    파일이름 user.class
    setId(), setPasswd() -> 1명분 자료
    public User(string, int 처럼) -> User는 깡통같은 역할..
     */



    /*
    여러명 표시할 때 : 여러줄 - List<객체>
    List<User> = 한명한명씩 반복해서 저장되는 것 -> 여러줄
    public List<User> users(){
      return List~
    }
    */

}
