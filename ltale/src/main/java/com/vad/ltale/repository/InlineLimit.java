package com.vad.ltale.repository;

import com.vad.ltale.entity.Limit;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;

@Projection(name = "inlineLimit", types = Limit.class)
public interface InlineLimit {
    Long getId();
    Long getUserId();
    Long getTime();
    Date getDateUpdate();
}
