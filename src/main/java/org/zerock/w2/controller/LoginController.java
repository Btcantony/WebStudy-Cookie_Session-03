package org.zerock.w2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {

    //3장 (1-2.로그인 컨트롤러 구현)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("login get.........");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    //3장 (1-4.파라미터를 수집하여 loginInfo라는 이름으로 문자열 저장)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("login post..........");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        //3장 (4-2. 자동 로그인 임의의 UUID생성)
        String auto = req.getParameter("auto");

        boolean rememberMe = auto != null && auto.equals("on");


        //3장 (3-4.HttpSession을 이용해서 'loginInfo'라는 이름으로 객체 저장)
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);


            //3장 (4-5. 데이터베이스에 임의의 값 생성)
            if(rememberMe) {
                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                //3장 (4-6. 브라우저에 remember-me이름의 쿠키 생성 전송 )
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}
