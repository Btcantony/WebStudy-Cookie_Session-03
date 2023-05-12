package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 2-3 (1.등록) TodoDTO를 파라미터로 받아 TodoVO로 변환
    public void register (TodoDTO todoDTO) throws Exception {

        // modelMapper를 이용해 객체 복사
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        // System.out.println("todoVO: " + todoVO);
        log.info(todoVO);

        dao.insert(todoVO);
    }

    // 2-3 (2.목록) 등록된 TodoVO목록을 TodoDTO로 변환
    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info("voList...............");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    // 2-3 (3.조회) 등록된 TodoVO객체를 가져오고, ModelMapper를 통해 TodoDTO로 반환
    public TodoDTO get(Long tno) throws Exception {

        log.info("tno : " + tno);

        TodoVO todoVO = dao.selectOne(tno);

        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    public void remove(Long tno) throws Exception {

        log.info("tno :" + tno);
        dao.deleteOne(tno);
    }


    // 2-3 (4.수정) 등록처럼 TodoDTO를 파라미터로 받아, TodoVO를 반환
    public void modify(TodoDTO todoDTO) throws Exception {

        log.info("todoDTO : " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);

    }
}
