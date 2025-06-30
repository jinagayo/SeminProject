# 🎓 JSP/Servlet LMS Project

학사관리 시스템

---

## 🖥️ 프로젝트 소개

JSP/Servlet을 이용하여 만든 학사관리 시스템입니다.  
**사범대**라는 컨셉의 학사관리 시스템을 구현하여  
**시스템 별로 사용자들을 분리**하고,  
개인별로 필요한 학사 일정을 쉽게 관리할 수 있도록 설계하였습니다.

---

## 📅 개발 기간

> **2025.04.25 ~ 2025.05.22**

---

## 👨‍👩‍👧‍👦 멤버 구성

| 이름    | 담당 업무                           |
| ------- | ----------------------------------- |
| 윤진아  | 교수페이지, ID/PW 찾기               |
| 이채원  | 게시판, 학생 페이지, 레이아웃         |
| 장혜민  | 메인화면, 관리자 페이지, DB 연동      |

---

## ⚙️ 개발 환경

### 🔧 개발 언어 & 기술 스택

- Java 11
- SQL (MariaDB)
- HTML5 / CSS3 / JavaScript
- JSTL
- MyBatis (ORM 프레임워크)

### 🎨 프론트엔드

- Bootstrap (UI 프레임워크)
- HTML5 / CSS3
- JavaScript

### 🗄️ 백엔드

- Java (Servlet/JSP 기반)
- MyBatis
- Apache Tomcat 9

### 🛢️ 데이터베이스

- MariaDB (HeidiSQL로 관리)

### 🧰 개발 도구

- Eclipse IDE
- HeidiSQL
- Git / Github

---

## 📌 주요 기능

### 🔑 로그인

- 각 사용자별 ID(학생: 학번, 교수: 교수번호, 관리자: 관리자번호) 및 PW를 이용한 로그인
- **로그인 계정에 따라 구별되는 레이아웃 제공**

| 학생/교수 로그인 | 관리자 로그인 |
|:----------------:|:------------:|
| ![학생/교수 로그인](https://github.com/user-attachments/assets/96f2304c-ed04-4860-98e5-ea747bb9add9) | ![관리자 로그인](https://github.com/user-attachments/assets/ef1ff4ab-8ced-4ae5-93ac-45b91e856e5a) |

---

### 🙋‍♂️ 마이페이지

#### 학생

- **학적 정보 조회**  
  <img src="https://github.com/user-attachments/assets/9c7f87ca-49e4-465c-a31d-8000c52dc17a" width="100%" height="400"/>

- **졸업 사정표**  
  <img src="https://github.com/user-attachments/assets/c53ef4a6-d0a2-49e2-933d-f8c40ba06d5e" width="100%" height="400"/>

- **내 시간표 조회**  
  <img src="https://github.com/user-attachments/assets/b585097c-b596-4a54-a19e-f552f2ab700a" width="100%" height="400"/>

- **교원 자격 취득 조회**  
  <img src="https://github.com/user-attachments/assets/703e1cc8-ee5a-47ac-a645-af760ab25ab1" width="100%" height="400"/>

- **수강신청**  
  <img src="https://github.com/user-attachments/assets/93a7e3d8-fb3e-47b9-b377-723b094d9336" width="100%" height="400"/>

- **게시판**  
  > - 학생: QnA 게시판  
  > - 관리자: 알림마당 게시판  
  > - 교수: 공지사항 게시판  
  <img src="https://github.com/user-attachments/assets/bd4f1119-0fd5-4c3d-b88b-0cdb4d8a152e" width="100%" height="400"/>

#### 관리자

- **교육실습일지**  
  <img src="https://github.com/user-attachments/assets/675614a8-fdba-4121-8b68-d1b71c7e2d43" width="100%" height="400"/>

#### 교수

- **학생 출결/성적 입력**  
  <img src="https://github.com/user-attachments/assets/35b034a9-f07f-46a9-afc9-b83d44b2629c" width="100%" height="400"/>

---

### 🔑 ID/PW 찾기 (이메일 인증)

<img src="https://github.com/user-attachments/assets/f99150f9-7121-4436-a959-9f3c1132a026" width="100%" height="400"/>

---

