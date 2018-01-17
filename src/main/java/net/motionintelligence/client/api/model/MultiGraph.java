package net.motionintelligence.client.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.TIntObjectMap;
import net.motionintelligence.client.api.enums.MultiGraphLayerType;

import java.util.HashMap;
import java.util.Map;

public class MultiGraph extends BaseGraph {

    private final Map<String,TIntIntMap> layers;

    // the type of the layer: values per vertex or per edge
    private final MultiGraphLayerType layerType;

    public MultiGraph(long networkID){
        super(networkID);
        this.layers = new HashMap<>();
        layerType = MultiGraphLayerType.PERVERTEX;
    }

    @JsonCreator
    public MultiGraph(@JsonProperty("networkID") long networkID,
                      @JsonProperty("nodes") TIntObjectMap<double[]> nodes,
                      @JsonProperty("layers") Map<String,TIntIntMap> layers,
                      @JsonProperty("edges") TIntObjectMap<int[]> edges,
                      @JsonProperty("supportingPoints") TIntObjectMap<double[][]> supportingPoints,
                      @JsonProperty("layerType") MultiGraphLayerType layerType) {
        super(networkID,nodes,edges,supportingPoints);
        this.layers = layers;
        this.layerType = layerType;
    }

    public Map<String, TIntIntMap> getLayers() {
        return layers;
    }

    public MultiGraphLayerType getLayerType() {
        return layerType;
    }
}
