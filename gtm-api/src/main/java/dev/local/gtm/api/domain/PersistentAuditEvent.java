package dev.local.gtm.api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 存储 Spring Boot actuator 管理的 AuditEvent
 *
 * @see org.springframework.boot.actuate.audit.AuditEvent
 *
 * @author Peng Wang (wpcfan@gmail.com)
 */
@Data
@Document(collection = "api_audit_events")
public class PersistentAuditEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field("event_id")
    private String id;

    @NotNull
    private String principal;

    @Field("event_date")
    private Instant auditEventDate;

    @Field("event_type")
    private String auditEventType;

    private Map<String, String> data = new HashMap<>();
}
