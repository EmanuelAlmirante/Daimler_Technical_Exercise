package daimlerapp.repository;

import daimlerapp.model.DublinGpsDataModel;
import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DublinGpsDataRepository extends JpaRepository<DublinGpsDataModel, Long> {
    @Query("select d from DublinGpsDataModel d where d.timestamp >= :startTime and d.timestamp <= :endTime")
    List<RunningOperatorsProjection> getRunningOperatorsByStartTimeAndEndTime(long startTime, long endTime);

    @Query("select d from DublinGpsDataModel d where d.timestamp >= :startTime and d.timestamp <= :endTime and d.operator = :operator")
    List<VehicleIdProjection> getVehicleIdByStartTimeAndEndTimeAndOperator(long startTime, long endTime,
                                                                           String operator);

    @Query("select d from DublinGpsDataModel d where d.timestamp >= :startTime and d.timestamp <= :endTime and d.operator = :operator and d.atStop = true")
    List<VehicleAtStopProjection> getVehicleAtStopByStartTimeAndEndTimeAndOperator(long startTime, long endTime,
                                                                                   String operator);

    @Query("select d from DublinGpsDataModel d where d.timestamp >= :startTime and d.timestamp <= :endTime and d.vehicleId = :vehicleId order by d.timestamp")
    List<VehicleTraceProjection> getVehicleTraceByStartTimeAndEndTimeAndOperator(long startTime, long endTime,
                                                                                 int vehicleId);
}
