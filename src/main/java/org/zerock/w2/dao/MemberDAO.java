package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    //3장 (3-2.로그인한 사용자 정보 띄우기)
   public MemberVO getWithPassword(String mid, String mpw) throws Exception {

       String query = "select mid, mpw, mname from tbl_member where mid =? and mpw = ?";

       MemberVO memberVO = null;

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

       preparedStatement.setString(1, mid);
       preparedStatement.setString(2, mpw);

       @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

       resultSet.next();

       memberVO = MemberVO.builder()
               .mid(resultSet.getString(1))
               .mpw(resultSet.getString(2))
               .mname(resultSet.getString(3))
               .build();

       return memberVO;
    }

    //3장 (4-3. 자동 로그인 임의의 UUID생성)
    public void updateUuid(String mid, String uuid) throws Exception {

       String sql = "update tbl_member set uuid =? where mid = ?";

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

       preparedStatement.setString(1, uuid);
       preparedStatement.setString(2, mid);

       preparedStatement.executeUpdate();
    }


    //3장 (4-7. 해당 사용자의 정보 로딩해 오는 기능 )

    public MemberVO selectUUID(String uuid) throws Exception {

       String query = "select mid, mpw, mname, uuid from tbl_member where uuid =? ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString(1))
                .mpw(resultSet.getString(2))
                .mname(resultSet.getString(3))
                .uuid(resultSet.getString(4))
                .build();

        return memberVO;
    }
}
