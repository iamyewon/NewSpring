create database auth;
use auth;

-- spring security password 는 암호화해서 저장해야함..
-- bcrypt 로 변환해서 사용자를 저장
-- username, passwd, role : user(userid=name), 1111, USER(role)
-- 암호화 때문에 비밀번호 500자 줬는데 이만큼은 안해도됨,
-- https://www.browserling.com/tools/bcrypt
create table users(
id bigint not null auto_increment,
username varchar(20),
password varchar(500),
role varchar(10),
primary key(id)
);

INSERT INTO users VALUES(NULL, 'busanit', '$2a$10$pNtbia6zZkhyW0c4A0oXd.diaqukM7M7F9grV8bDTuRu1xhOCPErO', 'ADMIN');
INSERT INTO users VALUES(NULL, 'kim', '$2a$10$cBmb9wB77o0cQRF6dlcKFOMazVtZW9lcTYiHX.QdvtHVsdRMSwGpe', 'USERS');

-- 관리자(admin) 아이디 busanit / 비밀번호 1234
-- 사용자(user) 아이디 kim / 비밀번호 5678