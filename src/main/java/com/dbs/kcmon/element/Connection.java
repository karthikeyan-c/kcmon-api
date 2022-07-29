package com.dbs.kcmon.element;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Connection {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String source;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String target;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Metrics metrics;
    List<Notice> notices = new ArrayList<>();
    @JsonProperty("class")
    String _class;
}
