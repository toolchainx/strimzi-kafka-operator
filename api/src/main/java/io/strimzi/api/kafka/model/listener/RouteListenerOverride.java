/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model.listener;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.strimzi.crdgenerator.annotations.Description;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Configures overrides for Route listeners
 */
@JsonPropertyOrder({"bootstrap", "brokers"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Buildable(
    editableEnabled = false,
    generateBuilderPackage = false,
    builderPackage = "io.fabric8.kubernetes.api.builder"
)
@EqualsAndHashCode
public class RouteListenerOverride implements Serializable {
    private static final long serialVersionUID = 1L;

    private RouteListenerBootstrapOverride bootstrap;
    private List<RouteListenerBrokerOverride> brokers;

    @Description("External bootstrap service configuration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public RouteListenerBootstrapOverride getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(RouteListenerBootstrapOverride bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Description("External broker services configuration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<RouteListenerBrokerOverride> getBrokers() {
        return brokers;
    }

    public void setBrokers(List<RouteListenerBrokerOverride> brokers) {
        this.brokers = brokers;
    }
}
