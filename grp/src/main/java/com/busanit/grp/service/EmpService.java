package com.busanit.grp.service;


import com.busanit.grp.entity.Employee;

import java.util.List;

// 여러명이서 이름과 메소드 접근제한자, 타입을 정해진 대로 사용하기 위해서 interface로 작성
// interface는 { } 없음
public interface EmpService {

    // 입력
    // public 리턴타입 addEmp(매개변수(=id, username, email, passwd)); // 저장하거나 검색할 자료
     public Employee addEmp(Employee emp); // 저장하거나 검색할 자료


    // 목록
    public List<Employee> getAllEmployees();

    // 삭제 - 쿼리문에 where 가 붙으면 파라미터 필요
    public Employee deleteEmployee(long id) throws Exception;

    // 수정(다음에)

    // 상세보기 - 쿼리문에 where 가 붙으면 파라미터 필요
    public Employee getEmployeeOne(long id);

}
