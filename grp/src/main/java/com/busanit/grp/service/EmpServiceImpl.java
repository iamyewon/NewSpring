package com.busanit.grp.service;

import com.busanit.grp.entity.Employee;
import com.busanit.grp.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{
    // 이 interface를 사용하려면 EmpService에 있는 메소드?들을 쓰든 안쓰든 일단 다 가져와야함
    // implements EmpService를 썼을때 무조건 빨간줄 뜨고,
    // alt+shift+enter 기능 => implements methods 하면됨 !

    @Autowired // 자동으로 당겨와줌 = 의존성 주입 이라고 말함 //별도로 만든 파일을 쉽게 가져와서 사용
    EmpRepository empRepository; // new EmpRepository(); -> 쉽게 가져오기

    @Override
    public Employee addEmp(Employee emp) {
        return empRepository.save(emp);
        // save(id, username, email, passwd) 대신 저렇게 한번에 씀
        // insert 같은 것 없이도 알아서 저장됨
        // addEmp(파라미터) 파라미터 있으면 밑에 save부분에도 파라미터 쓰고
    }

    @Override
    public List<Employee> getAllEmployees() { //findAll();
        return empRepository.findAll();
        // getAllEmployees() 에 파라미터가 없으니 밑에 findAll()에도 파라미터 없음
    }

    // Service 에서는 데이터 가공 : 빈 값 x -> 같은 예외 처리를 할 때 서비스
    @Override
    public Employee deleteEmployee(long id) throws Exception { //findById
        // 예외처리
        // 객체(id, username, email, passwd)가 삭제되면 - true, false / null 과 같이 판단
        // 삭제 안되면 User Not Found 메시지 출력

        Employee emp = null;
        // return 뒤에 써주기 위해서 상위로 빼줌
        try{
            // Employee emp = empRepository.findById(id).orElse(null); 였음
            emp = empRepository.findById(id).orElse(null);
            // 사원 데이터를 조회 // id, username, email, passwd 이렇게 결과 나올텐데
            // int, String, String, String emp 이렇게 받을 순 없음 !
            // 받는 방법 = 객체 = Employee emp = ~
            if(emp == null){ // 객체니까 null
                throw new Exception("User Not Found");
            }else{
                empRepository.deleteById(id);
            }
        }catch (Exception e){
            throw e;
        }

        return emp;
    }

    @Override
    public Employee getEmployeeOne(long id) { //findById
        return empRepository.findById(id).orElse(null);
        // 밑줄 나오는 이유는 값이 없을 때 문제가 될 수 있기 때문에
        // else 처리 해주면 됨 =>
        // .orElse(null);
    }

}
