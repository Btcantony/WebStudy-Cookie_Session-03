package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;

@Log4j2
public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    //3장 (3-3.로그인한 사용자 정보 띄우기)
    public MemberDTO login(String mid, String mpw) throws Exception {

        MemberVO vo = dao.getWithPassword(mid, mpw);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    //3장 (4-4. 자동 로그인 임의의 UUID생성)
   public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
   }

    //3장 (4-7. GetByUUID()추가)
    public MemberDTO getByUUID(String uuid) throws Exception {

        MemberVO vo = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
}
