package dev.ask.auth.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private String id;
    private String name;
    private String description;
}