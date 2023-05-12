package org.zerock.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    // 2-4 register테스트 (TodoDTO받아서 TodoVO로 반환)
    @Test
    public void testRegister()throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Review Test Title")
                .dueDate(LocalDate.now())
                .build();

        log.info("---------------------------------------------"); //테스트 코드의 Log4j2설정 확인
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
