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
public class Node {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String renderer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;
    @JsonProperty("class")
    String _class = "normal";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer maxVolume;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long updated;
    List<Node> nodes = new ArrayList<>();
    List<Connection> connections = new ArrayList<>();

    public Node(String name,String renderer){
        this.name = name;
        this.renderer = renderer;
    }
}
