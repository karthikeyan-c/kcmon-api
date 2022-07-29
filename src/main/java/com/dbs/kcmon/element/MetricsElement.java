package com.dbs.kcmon.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricsElement {
    String name;
    String service;
    String query;
    List<MetricsElement> child;
}
