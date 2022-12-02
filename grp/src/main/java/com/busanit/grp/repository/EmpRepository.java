package com.busanit.grp.repository;

import com.busanit.grp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// jpa 상속 받고 => service(에서) interface(받고) + implements 구현
// JpaRepository<T, ID>
// T : type  ( -> 객체 : 1명분 정보 )
// 현재 1명에게 long(id), String(username), String(email), String(passwd) 4개의 정보가 있음
// => model에 담으면 객체가 됨
// int, String, float, double - 기본형
// Integer, String, Float, Double - 객체 용
//
// <Integer, ID>
// <entity파일이름, primary key의 타입형>
public interface EmpRepository extends JpaRepository<Employee, Long> {
    // <long, String, String, String> 이렇게 4개를 나열해서 쓰는건 x
    // JpaRepository 에 저장하고 삭제하고 등의 기능이 들어 있음


}
