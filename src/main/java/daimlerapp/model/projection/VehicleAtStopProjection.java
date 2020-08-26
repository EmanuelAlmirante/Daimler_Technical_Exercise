package daimlerapp.model.projection;

public interface VehicleAtStopProjection {
    String getOperator();

    void setOperator(String operator);

    Integer getVehicleId();

    void setVehicleId(Integer vehicleId);

    Integer getStopId();

    void setStopId(Integer stopId);

    Boolean getAtStop();

    void setAtStop(Boolean atStop);
}
