package com.busanit.grp.controller;


import com.busanit.grp.entity.Employee;
import com.busanit.grp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    // Service를 사용할때 이 이름을 사용하겠다..

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


    //ModelAndView : db + 화면 같이 출력
    //Model : db자료를 가져와서 html로 전달(node에서 res send 같은..)
        // 사용 => model.attribute();
        // 어디선가 db자료를 가져오겠다....

    //listEmp : 화면에 출력(get)
    // @GetMapping("/listEmp")
    @GetMapping // 이렇게만 사용하면 /grp 의 인덱스?메인?페이지가 됨
    public String listEmp(Model model){ // Model은 Springframework ui 를 import
        model.addAttribute("empList",empService.getAllEmployees()); //서비스쪽에 db자료를 가져오는 메서드가 있는데 가져와서 사용
        // getAllEmployees() 메소드에서 가져온 전체 데이터를 empList 이름으로 html 에 전달
        System.out.println(model);
        return "listEmp"; // listEmp.html
    }

    @GetMapping("/deleteEmp")
    public String deleteEmp(Long id) throws Exception{ // 껍질 : 데이터 타입 + 이름
        System.out.println(id);
        empService.deleteEmployee(id); // 사용 : 이름만
        // Service 에 쓰인 형태와 똑같이 맞춰야함 !! throws Exception이 필요함!!
        return "redirect:/grp"; //   redirect:/grp ~  ==>  주소이동
    }









}
