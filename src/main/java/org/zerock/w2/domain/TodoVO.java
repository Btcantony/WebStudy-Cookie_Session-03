package org.zerock.w2.domain;

import lombok.*;

import java.time.LocalDate;


@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
// TodoDAO 기능 구현
public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
