package com.example.securitydb.repository;

import com.example.securitydb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // id 검색 말고 이름으로 검색을 하거나 등의 다른 기능이 필요하다 => 커스텀
    // interface 를 만들어서 하는 건 다음에
    // save(), findById() 같은 기능으로는 내가 원하는 기능을 할 수 없을 때 만들어서 사용

    // 접근제한 리턴타입 메소드이름(파라미터)
    Users findByUsername(String username);
    // = public Users findByUsername(String username);



}
