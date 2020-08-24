package daimlerapp.model.projection;

public interface VehicleTraceProjection {
    Long getTimestamp();

    void setTimestamp(Long timestamp);

    Double getLon();

    void setLon(Double lon);

    Double getLat();

    void setLat(Double lat);

    Integer getVehicleId();

    void setVehicleId(Integer vehicleId);
}
