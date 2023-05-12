package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

//todo로 시작하는 모든 경로 필터링
@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("Login check filter....");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if (session.getAttribute("loginInfo") == null) {

            resp.sendRedirect("/login");

            return;
        }


        //3장 (4-7. GetByUUID()추가)
        //session에 loginInfo 값이 없다면 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        //세션에도 없고 쿠키도 없다면 그냥 로그인
        if (cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        //쿠키가 존재하면
        log.info("cookie는 존재하는 상황");
        //uuid값
        String uuid = cookie.getValue();

        try {
            //DB확인
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보: " + memberDTO);
            if(memberDTO == null) {
                throw new Exception("Cookie value is not valid");
            }

            //회원 정보를 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/login");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name) {

        if(cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent()?result.get():null;
    }
}
