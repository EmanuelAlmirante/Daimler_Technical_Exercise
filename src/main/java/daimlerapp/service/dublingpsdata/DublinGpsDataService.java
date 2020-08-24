package daimlerapp.service.dublingpsdata;


import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;

import java.util.List;

public interface DublinGpsDataService {
    List<RunningOperatorsProjection> getRunningOperatorsByStartTimeAndEndTime(String startTime, String endTime);

    List<VehicleIdProjection> getVehicleIdByStartTimeAndEndTimeAndOperator(String startTime, String endTime,
                                                                           String operator);

    List<VehicleAtStopProjection> getVehicleAtStopByStartTimeAndEndTimeAndOperator(String startTime, String endTime,
                                                                                   String operator);

    List<VehicleTraceProjection> getVehicleTraceByStartTimeAndEndTimeAndOperator(String startTime, String endTime,
                                                                                 int vehicleId);
}
