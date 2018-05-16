package net.motionintelligence.client.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import net.motionintelligence.client.Constants;

import java.util.Locale;
import java.util.stream.Stream;

public enum MultiGraphLayerEdgeAggregationType {

    MIN(Constants.KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MINIMUM),
    MAX(Constants.KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MAXIMUM),
    MEAN(Constants.KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MEAN);

    private String key;

    MultiGraphLayerEdgeAggregationType(String key) {
		this.key = key;
	}

    @JsonCreator
    public static MultiGraphLayerEdgeAggregationType fromString(String key) {
        return key == null ? null : Stream.of(MultiGraphLayerEdgeAggregationType.values())
                .filter( enu -> enu.key.equalsIgnoreCase(key)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid " +
                        MultiGraphAggregationType.class.getSimpleName() + " specified: " + key + " doesn't exist"));
    }

    @JsonValue
    public String getKey() {
		return key;
	}
}
