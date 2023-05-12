<h1>자바웹개발워크북 3장 실습 쿠키 && 세션 </h1>
<br>
<p>1. TodoDAOTest를 실행해 등록, 목록, 조회, 삭제, 수정 만들기 </p>
<br>
<br>

<br>
<p>2. 서비스 와 컨트롤러 연동  </p>
<br>
<br>


<h1>📆 개발일정</h1>
<br>
2023.05 ~ 2023.05<br><br>
<br>


<h1>⚡ 핵심기능</h1> <br>
<li> TodoDAOTest를 실행해 등록, 목록, 조회, 삭제, 수정 만들기  <br> <br>
&nbsp;&nbsp; : TodoVO 생성 @Getter -> TodoDAO 생성 ( String sql 만들고 @CleanUP 이용, 매개변수 TodoVO, 리턴타입 cbc) -> TodoDAOTests 에서  todoDAO.selectAll(); 실행  <br><br></li><br> <br>

<img width="700" alt="Pasted Graphic 2" src="https://user-images.githubusercontent.com/94521647/236224443-25d77240-1326-4f81-87c6-55f00cfd084c.png">
 <br> <br>


<li>서비스 와 컨트롤러 연동  <br> <br>
&nbsp;&nbsp; : 1. 등록  TodoDTO 셍성 - MapperUtil세팅(객체 정보 다른객체로 복사) - Todoservice (register DTO를 파라미터로 받아 VO로 변환) - TodoServicesTests를 통한 확인 <br><br></li><br> <br>
&nbsp;&nbsp; : 2. 목록  2. Todoservice (listAll() 구현, TodoVO목록을 모두 TodoDTO로 변환
- TodoListController 에서 setAttrivute()통해 Todoservice객체 저장, requestDispatcher를 통해 JSP전달 -> list.jsp에서 ${dto}로 받아줌 
<br><br></li><br> <br>


<img width="700" alt="RESET REGISTER" src="https://user-images.githubusercontent.com/94521647/236225084-91cedfd5-a5a1-425b-bb83-327913eeebcc.png">  <br> <br>

<img width="700" alt="Todo List" src="https://user-images.githubusercontent.com/94521647/236225160-32138e82-bb1f-476f-8f60-89865b32e5a8.png">  <br> <br>

<img width="700" alt="Pasted Graphic 6" src="https://user-images.githubusercontent.com/94521647/236225244-8606e8d1-cd9c-4fed-9e37-d3ce65c621da.png"> <br> <br>

<img width="700" alt="Pasted Graphic 7" src="https://user-images.githubusercontent.com/94521647/236225295-81928408-a241-4e0a-8a0a-d74d0460b3fa.png"> <br> <br>

<img width="700" alt="Pasted Graphic 8" src="https://user-images.githubusercontent.com/94521647/236225362-e77a9ea4-5f91-4507-b41a-d214cdc0c175.png"> <br> <br>







<br><p>본 내용은 자바 웹 개발 워크북을 공부하며, 개발하였습니다. </p>
