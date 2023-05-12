package org.zerock.w2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// 2-1 @Data를 이용해 getter/setter생성
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
