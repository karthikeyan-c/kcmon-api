package com.dbs.kcmon.service;

import com.dbs.kcmon.element.Node;
import com.dbs.kcmon.model.GlobalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    @Autowired
    public GlobalModel globalModel;

    public Node getCurrentMetrics() {
        return globalModel.fetchGlobalModel();
    }
}
