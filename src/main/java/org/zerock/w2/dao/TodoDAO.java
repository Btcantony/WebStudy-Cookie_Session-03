package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

   public String getTime() {

       String now = null;

       //1. ConnectionUtil 연결 2. PreparedStatement(insert/delete/update 사용) 3. resultSet (select사용) + next
       try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("select now()");

           ResultSet resultSet = preparedStatement.executeQuery();
       ) {

           resultSet.next();

           now = resultSet.getString(1);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return now;
   }

   // 1-1 (1.등록) TodoVO객체를 이용해 DML(insert/update/delete) 실행
   public void insert(TodoVO vo) throws Exception {

       String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ?, ?)";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       preparedStatement.setString(1, vo.getTitle());
       preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
       preparedStatement.setBoolean(3, vo.isFinished());

       preparedStatement.executeUpdate();
   }

   // 1-1 (2.목록) tbl_todo의 모든 데이터를 객체로 만들어줌
   public List<TodoVO> selectAll() throws Exception {

       String sql = "select * from tbl_todo";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

       List<TodoVO> list = new ArrayList<>();

       while (resultSet.next()) {
           TodoVO vo = TodoVO.builder()
                   .tno(resultSet.getLong("tno"))
                   .title(resultSet.getString("title"))
                   .dueDate(resultSet.getDate("dueDate").toLocalDate())
                   .finished(resultSet.getBoolean("finished"))
                   .build();

           list.add(vo);
       }

       return list;
    }

    // 1-1 (3.조회) 특정 번호(tno) 데이터를 가져옴
    public TodoVO selectOne(Long tno) throws Exception {

       String sql = "select * from tbl_todo where tno = ?";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       preparedStatement.setLong(1, tno);

       @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

       resultSet.next();
       TodoVO vo = TodoVO.builder()
               .tno(resultSet.getLong("tno"))
               .title(resultSet.getString("title"))
               .dueDate(resultSet.getDate("dueDate").toLocalDate())
               .finished(resultSet.getBoolean("finished"))
               .build();

       return vo;
    }

    // 1-1 (4.삭제)
    public void deleteOne(Long tno) throws Exception {

       String sql = "delete from tnl_todo where tno = ?";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       preparedStatement.setLong(1, tno);

       preparedStatement.executeUpdate();
    }

    // 1-1 (5.수정) 특정 번호(tno)를 가진 데이터의 제목, 만료일... update
    public void updateOne(TodoVO todoVO) throws Exception {

       String sql = "update tbl_todo set title = ?, dueDate =?, finished = ? where tno = ?";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       preparedStatement.setString(1, todoVO.getTitle());
       preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
       preparedStatement.setBoolean(3, todoVO.isFinished());
       preparedStatement.setLong(4, todoVO.getTno());

       preparedStatement.executeUpdate();
    }
}