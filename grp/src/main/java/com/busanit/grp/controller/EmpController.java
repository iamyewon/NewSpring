package com.busanit.grp.controller;


import com.busanit.grp.entity.Employee;
import com.busanit.grp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 주소, html을 화면에 표시하거나 html로 데이터를 전달 (json 처리 같은 것이 불가능)
// @RestController : 텍스트, json, ajax, axios, fetch 와 같은 객체 타입을 전달/전송 할 때 사용
// controller + ResponseBody = RestController

@RequestMapping("/grp")  //아래의 주소들은 모두 /grp 로 시작하도록
public class EmpController {
    @Autowired
    EmpService empService;

    //addEmp : 화면에 출력(get)
    //@Mapping : GetMapping, PostMapping
    //@Method로 html 화면에 표시 : 리턴 타입은 String
    @GetMapping("/addEmp")
    //접근제한자 리턴타입 메소드명(){}
    public String addEmp(){
        return "addEmp"; // addEmp.html
    }

    @PostMapping("/addEmp")
    //public String addEmpDo(String username, String email, String passwd){ 너무 기니까 이렇게 받지말고
    public String addEmpDo(Employee emp){ // model로 받기 = Employee
        // 저장 기능은 EmpService 에 .save() 부분에서
        empService.addEmp(emp);
        return "redirect:/grp"; // list로 보내기
    }



    //listEmp : 화면에 출력(get)
    // @GetMapping("/listEmp")
    @GetMapping // 이렇게만 사용하면 /grp 의 인덱스?메인?페이지가 됨
    public String listEmp(){
        return "listEmp"; // listEmp.html
    }

    @GetMapping("/deleteEmp")
    public String deleteEmp(){
        return ""; //   redirect:/grp ~  ==>  주소이동
    }









}
