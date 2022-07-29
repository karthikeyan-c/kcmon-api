package com.dbs.kcmon.element;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Metrics {
    @JsonIgnore
    String dangerQuery;
    @JsonIgnore
    String normalQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Double danger = 1.00;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Double normal = 5.00;

    public Metrics(String dangerQuery, String normalQuery) {
        this.dangerQuery = dangerQuery;
        this.normalQuery = normalQuery;
    }
}
