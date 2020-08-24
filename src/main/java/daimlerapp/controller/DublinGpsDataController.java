package daimlerapp.controller;

import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;
import daimlerapp.service.dublingpsdata.DublinGpsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("daimler/api/gps-data")
public class DublinGpsDataController {
    @Autowired
    private DublinGpsDataService dublinGpsDataService;

    @GetMapping("/running-operators")
    @ResponseStatus(HttpStatus.OK)
    public List<RunningOperatorsProjection> getRunningOperatorsByStartTimeAndEndTime(
            @RequestParam(name = "starttime") String startTime,
            @RequestParam(name = "endtime") String endTime) {
        return dublinGpsDataService.getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);
    }

    @GetMapping("/vehicle-ids")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleIdProjection> getVehicleIdByStartTimeAndEndTimeAndOperator(
            @RequestParam(name = "starttime") String startTime,
            @RequestParam(name = "endtime") String endTime,
            @RequestParam(name = "operator") String operator) {
        return dublinGpsDataService.getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
    }

    @GetMapping("/at-stop")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleAtStopProjection> getVehicleAtStopByStartTimeAndEndTimeAndOperator(
            @RequestParam(name = "starttime") String startTime,
            @RequestParam(name = "endtime") String endTime,
            @RequestParam(name = "operator") String operator) {
        return dublinGpsDataService.getVehicleAtStopByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
    }

    @GetMapping("/gps-tracing")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleTraceProjection> getVehicleTraceByStartTimeAndEndTimeAndOperator(
            @RequestParam(name = "starttime") String startTime,
            @RequestParam(name = "endtime") String endTime,
            @RequestParam(name = "vehicleid") int vehicleId) {
        return dublinGpsDataService.getVehicleTraceByStartTimeAndEndTimeAndOperator(startTime, endTime, vehicleId);
    }
}
