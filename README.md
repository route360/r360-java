# r360-java
Java Client API for Route360° web service

## API-Key
Get your API key [here ](https://developers.route360.net/apikey.html).

## Build the library

     mvn clean install
     
     <dependency>
         <groupId>net.motionintelligence</groupId>
         <artifactId>r360-java-client</artifactId>
         <version>0.0.2</version>
     </dependency>

## PolygonService

Create polygon from source point.

    TravelOptions options = new TravelOptions();
    options.setTravelTimes(Arrays.asList(600, 1200, 1800, 2400, 3000, 3600));
    options.setTravelType(TravelType.TRANSIT);
    options.addSource(new Source("id1", 40.608155, -73.976636));
    options.setServiceKey("ENTER YOUR KEY HERE");
    options.setServiceUrl("https://service.route360.net/germany/");
		
    PolygonResponse polygonResponse = new PolygonRequest(options).get();
    System.out.println(polygonResponse.getRequestTimeMillis() + " " + polygonResponse.getCode());
    System.out.println(polygonResponse.getResult());
    
## TimeService

Return travel times from each source to each target point.

    TravelOptions options = new TravelOptions();
    options.setMaxRoutingTime(3600);
    options.addSource(source);
    options.setTargets(targets);
    options.setTravelType(TravelType.CAR);
    options.setServiceKey("ENTER YOUR KEY HERE");
    options.setServiceUrl("https://service.route360.net/germany/");
    
    TimeResponse timeResponse = new TimeRequest(options, HttpMethod.POST).get();
    // so the api returns all combinations of source and target with the corresponding travel time, or -1 if not reachable
    Map<Source, Map<Target, Integer>> travelTimes = timeResponse.getTravelTimes();

## ReachabilityService

Return total travel time for each source point to all targets.

    TravelOptions options = new TravelOptions();
    options.setMaxRoutingTime(3600);
    options.addSource(source);
    options.setTargets(targets);
    options.setTravelType(TravelType.CAR);
    options.setServiceKey("ENTER YOUR KEY HERE");
    options.setServiceUrl("https://service.route360.net/germany/");

	ReachabilityResponse reachabilityResponse = new ReachabilityRequest(options, HttpMethod.POST).get();
	// source ID, total travel time or -1 if not reachable
	Map<String, Integer> travelTimes = reachabilityResponse.getTravelTimes();

## RouteService

Return possible route from each source point to each target.

    TravelOptions options = new TravelOptions();
    options.setMaxRoutingTime(3600);
    options.addSource(source);
    options.setTargets(targets);
    options.setTravelType(TravelType.BIKE);
    options.setElevationEnabled(true);
    options.setServiceKey("ENTER YOUR KEY HERE");
    options.setServiceUrl("https://service.route360.net/germany/");

	RouteResponse routeResponse = new RouteRequest(options, HttpMethod.POST).get();
	JSONArray routes = routeResponse.getRoutes();