package net.motionintelligence.client;

public class Constants {

    public static final int NO_VALUE_ENTRY_TROVE_MAPS = -1;

    public static final String POLYGON_VALUES                                           = "values";
    public static final String POLYGON_INTERSECTION_MODE                                = "intersectionMode";
    public static final String MAX_ROUTING_TIME                                         = "maxRoutingTime";
    public static final String MAX_ROUTING_LENGTH                                       = "maxRoutingLength";
    public static final String SERIALIZER                                               = "serializer";
    public static final String POLYGON_SERIALIZER                                       = "polygonSerializer";
    public static final String POINT_REDUCTION                                          = "pointReduction";
    public static final String MIN_POLYGON_HOLE_SIZE                                    = "minPolygonHoleSize";
    public static final String POLYGON                                                  = "polygon";
    public static final String ID                                                       = "id";
    public static final String LATITUDE                                                 = "lat";
    public static final String LONGITUDE                                                = "lng";
    public static final String TRANSPORT_MODE                                           = "tm";
    public static final String SOURCES                                                  = "sources";
    public static final String TARGETS                                                  = "targets";
    public static final String ENABLE_ELEVATION                                         = "elevation";
    public static final String JSON_POLYGON_SERIALIZER                                  = "json";
    public static final String GEO_JSON_POLYGON_SERIALIZER                              = "geojson";
    public static final String TRAVEL_TYPE_WALK                                         = "walk";
    public static final String TRAVEL_TYPE_BIKE                                         = "bike";
    public static final String TRAVEL_TYPE_CAR                                          = "car";
    public static final String TRAVEL_TYPE_TRANSIT                                      = "transit";
    public static final String TRAVEL_TYPE_WALKTRANSIT                                  = "walktransit";
    public static final String TRAVEL_TYPE_BIKETRANSIT                                  = "biketransit";
    public static final String PATH_SERIALIZER                                          = "pathSerializer";
    public static final String TRAVEL_TIME_PATH_SERIALIZER                              = "travelTime";
    public static final String COMPACT_PATH_SERIALIZER                                  = "compact";
    public static final String GEO_JSON_PATH_SERIALIZER                                 = "geojson";
    public static final String TRANSPORT_MODE_TRANSIT_RECOMMENDATIONS                   = "recommendations";
    public static final String TRANSPORT_MODE_TRANSIT_FRAME                             = "frame";
    public static final String TRANSPORT_MODE_TRANSIT_FRAME_TIME                        = "time";
    public static final String TRANSPORT_MODE_TRANSIT_FRAME_DURATION                    = "duration";
    public static final String TRANSPORT_MODE_TRANSIT_FRAME_DATE                        = "date";
    public static final String EXCEPTION_ERROR_CODE_NO_ROUTE_FOUND                      = "no-route-found";
    public static final String EXCEPTION_ERROR_CODE_TRAVEL_TIME_EXCEEDED                = "travel-time-exceeded";
    public static final String EXCEPTION_ERROR_CODE_COULD_NOT_CONNECT_POINT_TO_NETWORK  = "could-not-connect-point-to-network";
    public static final String EXCEPTION_ERROR_CODE_UNKNOWN_EXCEPTION                   = "unknown-exception";
    public static final String BUFFER                                                   = "buffer";
    public static final String SIMPLIFY                                                 = "simplify";
    public static final String REVERSE                                                  = "reverse";
    public static final String Y                                                        = "y";
    public static final String X                                                        = "x";
    public static final String CALLBACK                                                 = "callback";
    public static final String SRID                                                     = "srid";
    public static final String DECIMAL_PRECISION                                        = "decimalPrecision";

    public static final String MULTIGRAPH                                               = "multigraph";
    public static final String MULTIGRAPH_EDGE_CLASSES                                  = "edgeClasses";
    public static final String MULTIGRAPH_LAYER                                         = "layer";
    public static final String MULTIGRAPH_LAYER_TYPE                                    = "type";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_EDGE                           = "edge";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_NODE                           = "node";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_TILE                           = "tile";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_TILE_NODE                      = "tile_node";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_HEXAGON                        = "hexagon";
    public static final String KEY_MULTIGRAPH_LAYER_TYPE_HEXAGON_NODE                   = "hexagon_node";
    public static final String MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE                   = "edgeAggregationType";
    public static final String KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MINIMUM       = "min";
    public static final String KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MAXIMUM       = "max";
    public static final String KEY_MULTIGRAPH_LAYER_EDGE_AGGREGATION_TYPE_MEAN          = "mean";
    public static final String MULTIGRAPH_LAYER_GEOMETRY_DETAIL_PER_TILE                = "geometryDetailPerTile";
    public static final String MULTIGRAPH_LAYER_MIN_GEOMETRY_DETAIL_LEVEL               = "minGeometryDetailLevel";
    public static final String MULTIGRAPH_LAYER_MAX_GEOMETRY_DETAIL_LEVEL               = "maxGeometryDetailLevel";
    public static final String MULTIGRAPH_LAYER_GEOMETRY_DETAIL_LEVEL                   = "geometryDetailLevel";
    public static final String MULTIGRAPH_TILE                                          = "tile";
    public static final String MULTIGRAPH_TILE_ZOOM                                     = "zoom";
    public static final String MULTIGRAPH_TILE_X                                        = "x";
    public static final String MULTIGRAPH_TILE_Y                                        = "y";
    public static final String MULTIGRAPH_SERIALIZATION                                 = "serialization";
    public static final String MULTIGRAPH_SERIALIZATION_DECIMAL_PRECISION               = "decimalPrecision";
    public static final String MULTIGRAPH_SERIALIZATION_MAX_GEOMETRY_COUNT              = "maxGeometryCount";
    public static final String MULTIGRAPH_SERIALIZATION_FORMAT                          = "format";
    public static final String KEY_MULTIGRAPH_SERIALIZATION_FORMAT_JSON                 = "json";
    public static final String KEY_MULTIGRAPH_SERIALIZATION_FORMAT_GEOJSON              = "geojson";
    public static final String KEY_MULTIGRAPH_SERIALIZATION_FORMAT_MAPBOX_VECTOR_TILES  = "mvt";
    public static final String MULTIGRAPH_AGGREGATION                                   = "aggregation";
    public static final String MULTIGRAPH_AGGREGATION_TYPE                              = "type";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_NONE                     = "none";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_MINIMUM                  = "min";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_MAXIMUM                  = "max";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_SUM                      = "sum";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_MEAN                     = "mean";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_MEDIAN                   = "median";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_NEAREST                  = "nearest";
    public static final String KEY_MULTIGRAPH_AGGREGATION_TYPE_ROUTING_UNION            = "routing_union";
    public static final String MULTIGRAPH_AGGREGATION_IGNORE_OUTLIERS                   = "ignoreOutliers";
    public static final String MULTIGRAPH_AGGREGATION_OUTLIER_PENALTY                   = "outlierPenalty";
    public static final String MULTIGRAPH_AGGREGATION_MIN_SOURCES_RATIO                 = "minSourcesRatio";
    public static final String MULTIGRAPH_AGGREGATION_MIN_SOURCES_COUNT                 = "minSourcesCount";
    public static final String MULTIGRAPH_AGGREGATION_MAX_RESULT_VALUE_RATIO            = "maxResultValueRatio";
    public static final String MULTIGRAPH_AGGREGATION_MAX_RESULT_VALUE                  = "maxResultValue";

    public static final String EDGE_WEIGHT                                              = "edgeWeight";
    public static final String MAX_EDGE_WEIGTH                                          = "maxEdgeWeight";
    public static final String STATISTIC_GROUP_ID                                       = "statisticGroupId";
    public static final String STATISTICS_ID                                            = "statistics";
    public static final String FORMAT                                                   = "format";
    public static final String INTER_SERVICE_KEY                                        = "interServiceKey";
}
