<h1>자바웹개발워크북 3장 실습 쿠키 && 세션 </h1>
<br>
<p>1. 로그인 체크, 로그 아웃, 자동 로그인 처리 </p>
<br>
<br>


<h1>📆 개발일정</h1>
<br>
2023.05 ~ 2023.05<br><br>
<br>


<h1>⚡ 핵심기능</h1> <br>
<li> 게시글 쓸 떄, 로그인 체크   <br> <br>
&nbsp;&nbsp; :  TodoRegisterController (쿠키가 새로만들어진 사용자, 로그인한 정보가 없는 사용자 -> login.jsp 아니면 register.jsp로) ->  LoginController 생성 doGet -> login.jsp 에 아이디(Mid)와 패스워드(mpw) 저장 -> LoginController doPost() Mid와 mpw 수집하고 loginInfo로 반환 
 <br><br></li><br> <br>


<img width="700" alt="Pasted Graphic" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/06512d40-cd7c-4aa7-a684-8dee225b1111">  
<img width="700" alt="INSERT TITLE" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/427f67cc-370d-4d55-b1d5-53051c44560f"> <br> <br>


<li>로그인한 사용자 정보 띄우기   <br> <br>
&nbsp;&nbsp; : DB연결 -> MemberVO, MemberDAO구현 -> MemberDTO 구현 -> MemberService 에 login()메소드 작성 -> LoginController의 doPost에서 로그인 작동 (로그인시 HttpSession을 통해 loginInfo로 객체 저장) -> login.jsp에서 로그인 에러 처리 <c:if> -> list.jsp에 ${loginInfo}호출 
 <br><br></li><br> <br>

 <img width="700" alt="Pasted Graphic" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/3156218c-143f-4b8e-9f83-f8938b08c571"> <br> <br>
 
 <img width="700" alt="Todo List" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/655b8bb0-30eb-470d-81fa-a3f394eccb03"> <br> <br>

 
 
<li>자동로그인 처리  (사용자 정의 쿠키 처리) <br> <br>
&nbsp;&nbsp; (1) : Todo번호(tno)를 쿠키를 이용해서 보관 -> TodoReadController에서 //모델담기 //쿠키찾기 //findCookie생성 
 <br><br></li><br> <br>
 &nbsp;&nbsp; (2) : login.sjp에 체크박스 추가 -> LoginController의 doPost()에서 체크박스 전송값 on 확인 , 임의의 UUID 생성 -> MemberVO, MemberDTO수정 -> MemberService 메소드 추가 -> LoginController반영 (doPost에 remember-me 생성 + 전송) -> MemberDAO , MemberSErvice변경 -> LoginCheckFIlter쿠키 체크 
 <br><br></li><br> <br>
 
<img width="700" alt="Pasted Graphic 3" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/fe54ea1c-d7dc-4bc3-9279-146b7c60a422">
<img width="700" alt="Pasted Graphic 4" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/9a7fa979-d0fe-4443-a285-5334666fa493"> <br><br></li><br> <br>

<img width="700" alt="Todo List" src="https://github.com/Btcantony/WebStudy-Cookie_Session-03/assets/94521647/dedfdc2b-79e0-41b7-9186-d279aabb4c1b"> <br> <br>

<br><p>본 내용은 자바 웹 개발 워크북을 공부하며, 개발하였습니다. </p>
