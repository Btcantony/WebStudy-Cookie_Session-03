package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {

        System.out.println(todoDAO.getTime());
    }

    // 1-2 (1.등록) 테스트 TodoVO 객체 만들어 넣기 (@Builder는 필요한 만큼 데이터 세팅)
    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVO);
    }

    // 1-2 (2.목록) selectAll 메소드 출력
    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    // 1-2 (3.조회) selectOne 메소드 출력
    @Test
    public void testSelectOne() throws Exception {

        Long tno = 1L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    // 1-2 (5.수정) 정보가 담겨있는 데이터를 받아 수정
    @Test
    public void testUpdateOne() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title....")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
