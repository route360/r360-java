package net.motion_intelligence.client.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.motion_intelligence.client.api.enums.PathSerializerType;
import net.motion_intelligence.client.api.enums.PolygonIntersectionMode;
import net.motion_intelligence.client.api.enums.PolygonSerializerType;
import net.motion_intelligence.client.api.enums.TravelType;
import net.motion_intelligence.client.api.geo.R360Point;
import net.motion_intelligence.client.api.geo.Source;
import net.motion_intelligence.client.api.geo.Target;
import net.motion_intelligence.client.api.util.TimeUtil;

public class TravelOptions {

	private Map<String,Source> sources					= new HashMap<>();
	private Map<String,Target> targets 				    = new HashMap<>();
	
    private double bikeSpeed                         	= 15.0;
    private double bikeUphill                        	= 20.0;
    private double bikeDownhill                      	= -10.0;
    private double walkSpeed                         	= 5.0;
    private double walkUphill                        	= 10.0;
    private double walkDownhill                      	= 0.0;
                 
    private List<Integer> travelTimes                	= Arrays.asList(600, 1200, 1800);
    private TravelType travelType                    	= TravelType.UNSPECIFIED;
    private Boolean elevationEnabled                 	= false;
    private boolean pointReduction                   	= true;
    private long minPolygonHoleSize                  	= 100000000;
                 
    private int time                                 	= TimeUtil.getCurrentTime();
    private int date                                 	= TimeUtil.getCurrentDate();
    private int frame                                	= 18000;
    private int recommendations                      	= 0;

    private PolygonIntersectionMode intersectionMode 	= PolygonIntersectionMode.UNION;
    private PathSerializerType pathSerializer        	= PathSerializerType.COMPACT_PATH_SERIALIZER;
    private PolygonSerializerType polygonSerializerType = PolygonSerializerType.JSON_POLYGON_SERIALIZER;
    private int maxRoutingTime                       	= 3600;
    private String serviceUrl                        	= "";
    private String serviceKey                        	= "";
	private boolean onlyPrintReachablePoints			= true;

	private List<String> statistics;
	
	/**
	 * 
	 * @return
	 */
	public double[][] getSourceCoordinates() {
		return getCoordinates(this.sources);
	}
	
	/**
	 * 
	 * @return
	 */
	public double[][] getTargetCoordinates(){
		return getCoordinates(this.targets);
	}
	
	/**
	 * 
	 * @param points
	 * @return
	 */
	private double[][] getCoordinates(Map<String, ? extends R360Point> points) {
		
		R360Point[] pointList = points.values().toArray(new R360Point[0]);
		
		double[][] coordinates = new double[points.size()][];
		for ( int i = 0 ; i < points.size() ; i ++ ) 
			coordinates[i] = new double[]{pointList[i].getLongitude(), pointList[i].getLatitude()};
		
		return coordinates;
	}
	
	/**
	 * @return the sources
	 */
	public Map<String,Source> getSources() {
		return sources;
	}
	/**
	 * @param sources the sources to set
	 */
	public void setSources(Map<String,Source> sources) {
		this.sources = sources;
	}
	/**
	 * @return the targets
	 */
	public Map<String,Target> getTargets() {
		return targets;
	}
	/**
	 * @param targets the targets to set
	 */
	public void setTargets(Map<String,Target> targets) {
		this.targets = targets;
	}
	/**
	 * @return the bikeSpeed
	 */
	public double getBikeSpeed() {
		return bikeSpeed;
	}
	/**
	 * @param bikeSpeed the bikeSpeed to set
	 */
	public void setBikeSpeed(double bikeSpeed) {
		this.bikeSpeed = bikeSpeed;
	}
	/**
	 * @return the bikeUphill
	 */
	public double getBikeUphill() {
		return bikeUphill;
	}
	/**
	 * @param bikeUphill the bikeUphill to set
	 */
	public void setBikeUphill(double bikeUphill) {
		this.bikeUphill = bikeUphill;
	}
	/**
	 * @return the bikeDownhill
	 */
	public double getBikeDownhill() {
		return bikeDownhill;
	}
	/**
	 * @param bikeDownhill the bikeDownhill to set
	 */
	public void setBikeDownhill(double bikeDownhill) {
		this.bikeDownhill = bikeDownhill;
	}
	/**
	 * @return the walkSpeed
	 */
	public double getWalkSpeed() {
		return walkSpeed;
	}
	/**
	 * @param walkSpeed the walkSpeed to set
	 */
	public void setWalkSpeed(double walkSpeed) {
		this.walkSpeed = walkSpeed;
	}
	/**
	 * @return the walkUphill
	 */
	public double getWalkUphill() {
		return walkUphill;
	}
	/**
	 * @param walkUphill the walkUphill to set
	 */
	public void setWalkUphill(double walkUphill) {
		this.walkUphill = walkUphill;
	}
	/**
	 * @return the walkDownhill
	 */
	public double getWalkDownhill() {
		return walkDownhill;
	}
	/**
	 * @param walkDownhill the walkDownhill to set
	 */
	public void setWalkDownhill(double walkDownhill) {
		this.walkDownhill = walkDownhill;
	}
	/**
	 * @return the travelTimes
	 */
	public List<Integer> getTravelTimes() {
		return travelTimes;
	}
	/**
	 * @param travelTimes the travelTimes to set
	 */
	public void setTravelTimes(List<Integer> travelTimes) {
		this.travelTimes = travelTimes;
	}
	/**
	 * @return the travelType
	 */
	public TravelType getTravelType() {
		return travelType;
	}
	/**
	 * @param travelType the travelType to set
	 */
	public void setTravelType(TravelType travelType) {
		this.travelType = travelType;
	}
	/**
	 * @return the elevationEnabled
	 */
	public Boolean isElevationEnabled() {
		return elevationEnabled;
	}
	/**
	 * @param elevationEnabled the elevationEnabled to set
	 */
	public void setElevationEnabled(Boolean elevationEnabled) {
		this.elevationEnabled = elevationEnabled;
	}
	/**
	 * @return the minPolygonHoleSize
	 */
	public long getMinPolygonHoleSize() {
		return minPolygonHoleSize;
	}
	/**
	 * @param minPolygonHoleSize the minPolygonHoleSize to set
	 */
	public void setMinPolygonHoleSize(long minPolygonHoleSize) {
		this.minPolygonHoleSize = minPolygonHoleSize;
	}
	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Integer time) {
		this.time = time;
	}
	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Integer date) {
		this.date = date;
	}
	/**
	 * @return the frame
	 */
	public int getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(int frame) {
		this.frame = frame;
	}
	/**
	 * @return the recommendations
	 */
	public int getRecommendations() {
		return recommendations;
	}
	/**
	 * @param recommendations the recommendations to set
	 */
	public void setRecommendations(int recommendations) {
		this.recommendations = recommendations;
	}
	/**
	 * @return the intersectionMode
	 */
	public PolygonIntersectionMode getIntersectionMode() {
		return intersectionMode;
	}
	/**
	 * @param intersectionMode the intersectionMode to set
	 */
	public void setIntersectionMode(PolygonIntersectionMode intersectionMode) {
		this.intersectionMode = intersectionMode;
	}
	/**
	 * @return the pathSerializer
	 */
	public PathSerializerType getPathSerializer() {
		return pathSerializer;
	}
	/**
	 * @param pathSerializer the pathSerializer to set
	 */
	public void setPathSerializer(PathSerializerType pathSerializer) {
		this.pathSerializer = pathSerializer;
	}
	/**
	 * @return the polygonSerializerType
	 */
	public PolygonSerializerType getPolygonSerializerType() {
		return polygonSerializerType;
	}
	/**
	 * @param polygonSerializerType the polygonSerializerType to set
	 */
	public void setPolygonSerializerType(PolygonSerializerType polygonSerializerType) {
		this.polygonSerializerType = polygonSerializerType;
	}
	/**
	 * @return the pointReduction
	 */
	public boolean isPointReduction() {
		return pointReduction;
	}
	/**
	 * @param pointReduction the pointReduction to set
	 */
	public void setPointReduction(boolean pointReduction) {
		this.pointReduction = pointReduction;
	}
	/**
	 * @return the maxRoutingTime
	 */
	public int getMaxRoutingTime() {
		return maxRoutingTime;
	}
	/**
	 * @param maxRoutingTime the maxRoutingTime to set
	 */
	public void setMaxRoutingTime(int maxRoutingTime) {
		this.maxRoutingTime = maxRoutingTime;
	}
	/**
	 * @return the serviceUrl
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}
	/**
	 * @param serviceUrl the serviceUrl to set
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	/**
	 * @return the serviceKey
	 */
	public String getServiceKey() {
		return serviceKey;
	}
	/**
	 * @param serviceKey the serviceKey to set
	 */
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	
	/**
	 * @param source
	 */
	public void addSource(Source source) {
		this.sources.put(source.getId(), source);
	}
	
	/**
	 * @param target
	 */
	public void addTarget(Target target) {
		this.targets.put(target.getId(), target);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TravelOptions {\n\tsources: " + sources.size() + "\n\ttargets: " + targets.size() + "\n\tbikeSpeed: " + bikeSpeed + "\n\tbikeUphill: " + bikeUphill + "\n\tbikeDownhill: " + bikeDownhill + "\n\twalkSpeed: " + walkSpeed + "\n\twalkUphill: " + walkUphill + "\n\twalkDownhill: " + walkDownhill
				+ "\n\ttravelTimes: " + travelTimes + "\n\ttravelType: " + travelType + "\n\televationEnabled: " + elevationEnabled + "\n\tpointReduction: " + pointReduction + "\n\tminPolygonHoleSize: " + minPolygonHoleSize + "\n\ttime: " + time + "\n\tdate: " + date + "\n\tframe: " + frame
				+ "\n\trecommendations: " + recommendations + "\n\tintersectionMode: " + intersectionMode + "\n\tpathSerializer: " + pathSerializer + "\n\tpolygonSerializerType: " + polygonSerializerType + "\n\tmaxRoutingTime: " + maxRoutingTime + "\n\tserviceUrl: " + serviceUrl + "\n\tserviceKey: "
				+ serviceKey + "\n}";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Source getSource(String id) {
		return this.sources.get(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Target getTarget(String id) {
		return this.targets.get(id);
	}
	
	public List<String> getStatistics() {
		return this.statistics;
	}
	
	public void setStatistics(List<String> statistics) {
		this.statistics = statistics ;
	}
	public void setOnlyPrintReachablePoints(boolean onlyPrintReachablePoints) {
		this.onlyPrintReachablePoints = onlyPrintReachablePoints;
	}
	
	public boolean getOnlyPrintReachablePoints() {
		return onlyPrintReachablePoints;
	}
}
