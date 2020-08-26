package daimlerapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "gps_data")
public class DublinGpsDataModel {
    @Id
    private Long id;
    private Long timestamp;
    private Integer lineId;
    private Integer direction;
    private String journeyPatternId;
    private LocalDate timeframe;
    private Integer vehicleJourneyId;
    private String operator;
    private Boolean congestion;
    private Double lon;
    private Double lat;
    private Integer delay;
    private Integer blockId;
    private Integer vehicleId;
    private Integer stopId;
    private Boolean atStop;

    public Long getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getJourneyPatternId() {
        return journeyPatternId;
    }

    public void setJourneyPatternId(String journeyPatternId) {
        this.journeyPatternId = journeyPatternId;
    }

    public LocalDate getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(LocalDate timeframe) {
        this.timeframe = timeframe;
    }

    public Integer getVehicleJourneyId() {
        return vehicleJourneyId;
    }

    public void setVehicleJourneyId(Integer vehicleJourneyId) {
        this.vehicleJourneyId = vehicleJourneyId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getCongestion() {
        return congestion;
    }

    public void setCongestion(Boolean congestion) {
        this.congestion = congestion;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public Boolean getAtStop() {
        return atStop;
    }

    public void setAtStop(Boolean atStop) {
        this.atStop = atStop;
    }
}
