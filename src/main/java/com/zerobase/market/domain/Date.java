package com.zerobase.market.domain;

import org.hibernate.annotations.Comment;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Date {
    @Comment("등록일")
    private LocalDateTime registDate;

    @Comment("수정일")
    private LocalDateTime updateDate;
}
