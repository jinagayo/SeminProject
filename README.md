# 🎓 학사관리 시스템 LMS Project

[<시연영상>](https://drive.google.com/file/d/1gh_L2BQJBMT5ifu5pnM9WWdfmBY41r5t/view?usp=drive_link)   &nbsp;  [<피피티>](https://docs.google.com/presentation/d/1fuvDoESwM3mgBnr0PEMoWbuYNLi5FaqU/edit?usp=drive_link&ouid=111927043237543963840&rtpof=true&sd=true)   



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
## 완성도 및 배포

- 4주간의 개발 기간 동안 계획된 핵심 기능을 모두 구현하여 프로젝트를 기능적으로 완성하였습니다 <br>
- 현재 해당 애플리케이션은 로컬 환경(Tomcat 서버 및 MariaDB 데이터베이스)에서 실행 가능하며, 별도의 웹 배포는 이루어지지 않았습니다.
  <br>
  <br>
---

## 핵심 기술

- **이메일 인증 기반 비밀번호 찾기**
  -  사용자가 ID 또는 비밀번호를 분실했을 때 등록된 이메일로 인증 번호를 발송하고, 해당 번호를 입력하여 비밀번호를 재설정할 수 있도록 구현하였습니다. JavaMail SMTP를 활용하여 랜덤 인증 코드를 발송하고 검증하며, 이를 통해 보안성과 사용자 편의성을 높였습니다.

- **WYSIWYG 에디터 적용**
  - 게시판 글 작성 시 Summernote와 같은 WYSIWYG 에디터를 적용하여 사용자가 풍부한 서식의 콘텐츠를 작성할 수 있도록 지원하였습니다. 이를 통해 공지사항 및 Q&A 작성의 편의성을 크게 향상시켰습니다.

- **레이아웃 템플릿 적용**
  - SiteMesh를 활용한 공통 레이아웃 템플릿을 도입하여, 각 권한별 페이지에서 공통 요소를 일관성 있게 제공하였습니다. 화면 구성의 중복을 줄이고, 이러한 템플릿 기반 구조를 통해 JSP 뷰를 효율적으로 관리할 수 있었습니다.
  <br>
  <br>
---

## 📌 주요 기능
> 본 시스템은 MVC 아키텍처 기반으로, 학생·교수·관리자 세 종류의 사용자 권한에 따라 개별적인 페이지 레이아웃과 기능을 제공합니다. <br>
>  주요 구현 기능은 다음과 같습니다 
<br>

### 🔑 로그인

- 각 사용자별 ID(학생: 학번, 교수: 교수번호, 관리자: 관리자번호) 및 PW를 이용한 로그인
- **로그인 계정에 따라 구별되는 레이아웃 제공**

| 학생/교수 로그인 | 관리자 로그인 |
|:----------------:|:------------:|
| ![학생/교수 로그인](https://github.com/user-attachments/assets/96f2304c-ed04-4860-98e5-ea747bb9add9) | ![관리자 로그인](https://github.com/user-attachments/assets/ef1ff4ab-8ced-4ae5-93ac-45b91e856e5a) |

<br>
<br>

### 🙋‍♂️ 마이페이지

#### 학생
> 학적 정보 조회, 졸업 요건 확인(졸업 사정표), 개인 시간표 조회, 교원 자격 취득 현황 조회, 수강신청 등 학사 관련 기능을 제공하며,<br>
>  QnA 게시판을 통해 궁금한 사항을 문의할 수 있습니다.
<br>

- **학적 정보 조회**  
  <img src="https://github.com/user-attachments/assets/9c7f87ca-49e4-465c-a31d-8000c52dc17a" width="100%" height="400"/>

- **졸업 사정표**  
  <img src="https://github.com/user-attachments/assets/c53ef4a6-d0a2-49e2-933d-f8c40ba06d5e" width="100%" height="400"/>

- **내 시간표 조회**  
  <img src="https://github.com/user-attachments/assets/b585097c-b596-4a54-a19e-f552f2ab700a" width="100%" height="400"/>


<br>


#### 관리자
학생들의 교육실습 일지 등 학사 데이터 관리 기능을 담당하며, 알림마당 게시판을 통해 전체 공지 사항을 게시할 수 있습니다

- **교육실습일지**


https://github.com/user-attachments/assets/675614a8-fdba-4121-8b68-d1b71c7e2d43

<br>


#### 교수
담당 학생들의 출결 현황 및 성적 입력 기능과 더불어 공지사항 게시판을 통한 안내 기능을 갖추고 있습니다

- **학생 출결/성적 입력**


https://github.com/user-attachments/assets/35b034a9-f07f-46a9-afc9-b83d44b2629c

<br>
<br>

### 게시판  
  > - 학생: QnA 게시판  
  > - 관리자: 알림마당 게시판  
  > - 교수: 공지사항 게시판


https://github.com/user-attachments/assets/bd4f1119-0fd5-4c3d-b88b-0cdb4d8a152e


<br>
<br>

### 🔑 ID/PW 찾기 (이메일 인증)


https://github.com/user-attachments/assets/f99150f9-7121-4436-a959-9f3c1132a026


---

