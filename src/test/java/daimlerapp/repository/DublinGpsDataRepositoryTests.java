package daimlerapp.repository;

import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DublinGpsDataRepositoryTests {
    @Autowired
    private DublinGpsDataRepository dublinGpsDataRepository;

    @Test
    public void getRunningOperatorsByStartTimeAndEndTimeSuccessfully() {
        // Arrange
        Long startTime = 20121123080000000L;
        Long endTime = 20121123080001000L;

        // Act
        List<RunningOperatorsProjection> runningOperatorsProjectionListReturned =
                dublinGpsDataRepository.getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);

        // Assert
        assertNotNull(runningOperatorsProjectionListReturned);
    }

    @Test
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        Long startTime = 20121123080000000L;
        Long endTime = 20121123080001000L;
        String operator = "PO";

        // Act
        List<VehicleIdProjection> vehicleIdProjectionListReturned =
                dublinGpsDataRepository.getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);

        // Assert
        assertNotNull(vehicleIdProjectionListReturned);
    }

    @Test
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        Long startTime = 20121123080000000L;
        Long endTime = 20121123080001000L;
        String operator = "PO";

        // Act
        List<VehicleAtStopProjection> vehicleAtStopProjectionListReturned =
                dublinGpsDataRepository.getVehicleAtStopByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);

        // Assert
        assertNotNull(vehicleAtStopProjectionListReturned);
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        Long startTime = 20121123080000000L;
        Long endTime = 20121123080001000L;
        Integer vehicleId = 33445;

        // Act
        List<VehicleTraceProjection> vehicleTraceProjectionListReturned =
                dublinGpsDataRepository.getVehicleTraceByStartTimeAndEndTimeAndOperator(startTime, endTime, vehicleId);

        // Assert
        assertNotNull(vehicleTraceProjectionListReturned);
    }
}
