package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.EmailDetailsRequest;
import com.example.studentemployee.dto.response.EmailDetailsResponse;
import com.example.studentemployee.entity.EmailDetails;
import org.springframework.stereotype.Component;

@Component
public class EmailDetailsMapper {
    public EmailDetails toEntity(EmailDetailsRequest r) {
        if (r == null) return null;
        EmailDetails e = new EmailDetails();
        apply(r, e);
        return e;
    }

    public void apply(EmailDetailsRequest r, EmailDetails e) {
        if (r == null) return;

        e.setPrimaryEmail(r.primaryEmail());
        e.setSecondaryEmail(r.secondaryEmail());
    }

    public EmailDetailsResponse toResponse(EmailDetails e) {
        return e == null ? null : new EmailDetailsResponse(e.getPrimaryEmail(), e.getSecondaryEmail());
    }
}
