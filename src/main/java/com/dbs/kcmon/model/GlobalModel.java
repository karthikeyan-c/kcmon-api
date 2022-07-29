package com.dbs.kcmon.model;

import com.dbs.kcmon.element.Connection;
import com.dbs.kcmon.element.Metrics;
import com.dbs.kcmon.element.Node;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GlobalModel {
    public Node globalNode = new Node("FINACLE", "global");
    public Node gatewayRegionNode = new Node("Gateway", "region");
    public Node gatewayChildNode = new Node("Gateway", "focusedChild");
    public Node apiNode = new Node("GAPI API", "region");
    public Node onlineNode = new Node("ONLINE", "region");
    public Node isoNode = new Node("ISO API", "region");
    public Node eventNode = new Node("EVENTS", "region");

    public Node fetchGlobalModel() {
        return this.globalNode;
    }

    GlobalModel() {
        globalNode.setMaxVolume(50000);

        apiModel();
        onlineModel();
        isoModel();

        globalNode.setNodes(List.of(
                gatewayRegionNode,
                apiNode,
                onlineNode,
                isoNode
        ));

        globalNode.setConnections(List.of(
                new Connection("Gateway", "GAPI API",
                        new Metrics("iso-danger","iso-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway", "ONLINE",
                        new Metrics("huniser-danger","huniser-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway", "ISO API",
                        new Metrics("huniser-danger","huniser-normal"),
                        new ArrayList<>(),"normal")
        ));
    }

    private void isoModel() {
        isoNode.setMaxVolume(50000);
        isoNode.setUpdated(1466838546805L);
        isoNode.setNodes(List.of(
                gatewayChildNode,
                new Node("ISO-GATEWAY","focusedChild"),
                new Node("HUNISER","focusedChild")
        ));
        isoNode.setConnections(List.of(
                new Connection("Gateway", "ISO-GATEWAY",
                        new Metrics("iso-danger","iso-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ISO-GATEWAY", "HUNISER",
                        new Metrics("huniser-danger","huniser-normal"),
                        new ArrayList<>(),"normal")
        ));
    }

    private void onlineModel() {
        // Online
        onlineNode.setMaxVolume(50000);
        onlineNode.setUpdated(1466838546805L);
        onlineNode.setNodes(List.of(
                gatewayChildNode,
                new Node("FININFRA","focusedChild"),
                new Node("FRONTEND-CASA","focusedChild"),
                new Node("FRONTEND-LOANS","focusedChild"),
                new Node("FRONTEND-PYMT","focusedChild"),
                new Node("FRONTEND-LM","focusedChild"),
                new Node("FRONTEND-ALL","focusedChild"),
                new Node("BACKEND-CASA","focusedChild"),
                new Node("BACKEND-LOANS","focusedChild"),
                new Node("BACKEND-PYMT","focusedChild"),
                new Node("BACKEND-LM","focusedChild"),
                new Node("BACKEND-ALL","focusedChild")
        ));
        onlineNode.setConnections(List.of(
                new Connection("Gateway","FRONTEND-CASA",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","FRONTEND-LOANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","FRONTEND-PYMT",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","FRONTEND-LM",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","FRONTEND-ALL",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),

                // Backend
                new Connection("FRONTEND-CASA","BACKEND-CASA",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("FRONTEND-LOANS","BACKEND-LOANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("FRONTEND-PYMT","BACKEND-PYMT",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("FRONTEND-LM","BACKEND-LM",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("FRONTEND-ALL","BACKEND-ALL",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),

                // apihub
                // APIHUB
                new Connection("BACKEND-CASA","APIHUB",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("BACKEND-LOANS","APIHUB",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("BACKEND-PYMT","APIHUB",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("BACKEND-LM","APIHUB",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("BACKEND-ALL","APIHUB",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal")
                ));
    }

    private void apiModel() {
        // Api
        apiNode.setMaxVolume(50000);
        apiNode.setUpdated(1466838546805L);
        apiNode.setNodes(List.of(
                gatewayChildNode,
                new Node("CASA-INQUIRY","focusedChild"),
                new Node("CASA-COMMAND","focusedChild"),
                new Node("CASA-UPDATE","focusedChild"),
                new Node("LOANS-INQUIRY","focusedChild"),
                new Node("LOANS-COMMAND","focusedChild"),
                new Node("LOANS-UPDATE","focusedChild"),
                new Node("ALL-INQUIRY","focusedChild"),
                new Node("ALL-COMMAND","focusedChild"),
                new Node("ALL-UPDATE","focusedChild"),
                new Node("BACKEND-CASA","focusedChild"),
                new Node("BACKEND-LOANS","focusedChild"),
                new Node("BACKEND-PYMT","focusedChild"),
                new Node("BACKEND-LM","focusedChild"),
                new Node("BACKEND-ALL","focusedChild"),
                new Node("INTERNAL-API","focusedChild"),
                new Node("FINCACHE","focusedChild"),
                new Node("FINCACHE-INQ","focusedChild"),
                new Node("FINCACHE-FEEM","focusedChild")
        ));
        apiNode.setConnections(List.of(
                new Connection("Gateway","CASA-INQUIRY",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","CASA-COMMAND",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","CASA-TRANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","LOANS-INQUIRY",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","LOANS-COMMAND",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","LOANS-TRANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","ALL-INQUIRY",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","ALL-COMMAND",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("Gateway","ALL-TRANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                // CASA-INQUIRY
                new Connection("CASA-INQUIRY","BACKEND-CASA",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-INQUIRY","BACKEND-LOANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-INQUIRY","BACKEND-PYMT",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-INQUIRY","BACKEND-LM",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-INQUIRY","BACKEND-ALL",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                // CASA-COMMAND
                new Connection("CASA-COMMAND","BACKEND-CASA",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-COMMAND","BACKEND-LOANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-COMMAND","BACKEND-PYMT",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-COMMAND","BACKEND-LM",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-COMMAND","BACKEND-ALL",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                // CASA-TRAN
                new Connection("CASA-TRAN","BACKEND-CASA",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-TRAN","BACKEND-LOANS",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-TRAN","BACKEND-PYMT",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-TRAN","BACKEND-LM",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-TRAN","BACKEND-ALL",
                        new Metrics("danger-query","casa-normal"),
                        new ArrayList<>(),"normal"),

                // LOANS-INQUIRY
                new Connection("LOANS-INQUIRY","BACKEND-CASA",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-INQUIRY","BACKEND-LOANS",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-INQUIRY","BACKEND-PYMT",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-INQUIRY","BACKEND-LM",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-INQUIRY","BACKEND-ALL",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                // LOANS-COMMAND
                new Connection("LOANS-COMMAND","BACKEND-CASA",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-COMMAND","BACKEND-LOANS",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-COMMAND","BACKEND-PYMT",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-COMMAND","BACKEND-LM",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-COMMAND","BACKEND-ALL",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                // LOANS-TRAN
                new Connection("LOANS-TRAN","BACKEND-CASA",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-TRAN","BACKEND-LOANS",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-TRAN","BACKEND-PYMT",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-TRAN","BACKEND-LM",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-TRAN","BACKEND-ALL",
                        new Metrics("danger-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),

                // ALL-INQUIRY
                new Connection("ALL-INQUIRY","BACKEND-CASA",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-INQUIRY","BACKEND-LOANS",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-INQUIRY","BACKEND-PYMT",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-INQUIRY","BACKEND-LM",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-INQUIRY","BACKEND-ALL",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                // ALL-COMMAND
                new Connection("ALL-COMMAND","BACKEND-CASA",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-COMMAND","BACKEND-LOANS",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-COMMAND","BACKEND-PYMT",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-COMMAND","BACKEND-LM",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-COMMAND","BACKEND-ALL",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                // ALL-TRAN
                new Connection("ALL-TRAN","BACKEND-CASA",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-TRAN","BACKEND-LOANS",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-TRAN","BACKEND-PYMT",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-TRAN","BACKEND-LM",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-TRAN","BACKEND-ALL",
                        new Metrics("danger-query","ALL-normal"),
                        new ArrayList<>(),"normal"),

                // INTERNAL-API
                new Connection("CASA-INQUIRY","INTERNAL-API",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-INQUIRY","INTERNAL-API",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-INQUIRY","INTERNAL-API",
                        new Metrics("casa-query","casa-normal"),
                        new ArrayList<>(),"normal"),

                // CASA-FINCACHE-INQ
                new Connection("CASA-INQUIRY", "FINCACHE-INQ",
                        new Metrics("CASA-query","CASA-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-COMMAND","FINCACHE-INQ",
                        new Metrics("CASA-query","CASA-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("CASA-TRAN","FINCACHE-INQ",
                        new Metrics("CASA-query","CASA-normal"),
                        new ArrayList<>(),"normal"),

                // LOANS-FINCACHE-INQ
                new Connection("LOANS-INQUIRY", "FINCACHE-INQ",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-COMMAND","FINCACHE-INQ",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("LOANS-TRAN","FINCACHE-INQ",
                        new Metrics("LOANS-query","LOANS-normal"),
                        new ArrayList<>(),"normal"),

                // ALL-FINCACHE-INQ
                new Connection("ALL-INQUIRY", "FINCACHE-INQ",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-COMMAND","FINCACHE-INQ",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal"),
                new Connection("ALL-TRAN","FINCACHE-INQ",
                        new Metrics("ALL-query","ALL-normal"),
                        new ArrayList<>(),"normal")
                ));
    }
}
