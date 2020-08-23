package daimlerapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gps_data")
public class DublinGpsDataModel {
    @Id
    private Long id;
    private long timestamp;
    private int lineId;
    private int direction;
    private int journeyPatternId;
    private Date timeframe;
    private int vehicleJourneyId;
    private String operator;
    private boolean congestion;
    private Double lon;
    private Double lat;
    private int delay;
    private int blockId;
    private int vehicleId;
    private int stopId;
    private boolean atStop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getJourneyPatternId() {
        return journeyPatternId;
    }

    public void setJourneyPatternId(int journeyPatternId) {
        this.journeyPatternId = journeyPatternId;
    }

    public Date getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(Date timeframe) {
        this.timeframe = timeframe;
    }

    public int getVehicleJourneyId() {
        return vehicleJourneyId;
    }

    public void setVehicleJourneyId(int vehicleJourneyId) {
        this.vehicleJourneyId = vehicleJourneyId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isCongestion() {
        return congestion;
    }

    public void setCongestion(boolean congestion) {
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

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public boolean isAtStop() {
        return atStop;
    }

    public void setAtStop(boolean atStop) {
        this.atStop = atStop;
    }
}
