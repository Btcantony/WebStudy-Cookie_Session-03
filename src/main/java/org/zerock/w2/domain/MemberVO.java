package org.zerock.w2.domain;


import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
//3장 (3-1.로그인한 사용자 정보 띄우기)
public class MemberVO {

    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
