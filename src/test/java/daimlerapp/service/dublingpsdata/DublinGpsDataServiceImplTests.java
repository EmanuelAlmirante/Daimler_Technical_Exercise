package daimlerapp.service.dublingpsdata;

import daimlerapp.exception.BusinessException;
import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;
import daimlerapp.repository.DublinGpsDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DublinGpsDataServiceImplTests {
    @Mock
    private DublinGpsDataRepository dublinGpsDataRepository;
    @InjectMocks
    private DublinGpsDataServiceImpl dublinGpsDataServiceImpl;
    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    @Test
    public void getRunningOperatorsByStartTimeAndEndTimeSuccessfully() {
        // Arrange
        String operator = "PO";

        RunningOperatorsProjection runningOperatorsProjection =
                factory.createProjection(RunningOperatorsProjection.class);
        runningOperatorsProjection.setOperator(operator);

        List<RunningOperatorsProjection> runningOperatorsProjectionListToBeReturned =
                Collections.singletonList(runningOperatorsProjection);

        // Act
        when(dublinGpsDataRepository.getRunningOperatorsByStartTimeAndEndTime(anyLong(), anyLong()))
                .thenReturn(runningOperatorsProjectionListToBeReturned);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<RunningOperatorsProjection> runningOperatorsProjectionListReturned = dublinGpsDataServiceImpl
                .getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);

        // Assert
        assertNotNull(runningOperatorsProjectionListReturned);
        assertEquals(operator, runningOperatorsProjectionListReturned.get(0).getOperator());
    }

    @Test(expected = BusinessException.class)
    public void getRunningOperatorsByStartTimeAndEndTimeWithInvalidStartTimeFails() {
        // Act & Assert
        String startTime = "1";
        String endTime = "20121123080001000";

        try {
            dublinGpsDataServiceImpl
                    .getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);
        } catch (BusinessException be) {
            String exceptionMessage = "Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid start time was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void getRunningOperatorsByStartTimeAndEndTimeWithInvalidEndTimeFails() {
        // Act & Assert
        String startTime = "20121123080000000";
        String endTime = "1";

        try {
            dublinGpsDataServiceImpl
                    .getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);
        } catch (BusinessException be) {
            String exceptionMessage = "End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid end time was not thrown!");
    }

    @Test
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        String operator = "PO";
        Integer vehicleId = 33445;

        VehicleIdProjection vehicleIdProjection = factory.createProjection(VehicleIdProjection.class);
        vehicleIdProjection.setOperator(operator);
        vehicleIdProjection.setVehicleId(vehicleId);

        List<VehicleIdProjection> vehicleIdProjectionListToBeReturned = Collections.singletonList(vehicleIdProjection);

        // Act
        when(dublinGpsDataRepository.getVehicleIdByStartTimeAndEndTimeAndOperator(anyLong(), anyLong(), anyString()))
                .thenReturn(vehicleIdProjectionListToBeReturned);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<VehicleIdProjection> vehicleIdProjectionListReturned =
                dublinGpsDataServiceImpl.getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);

        // Assert
        assertNotNull(vehicleIdProjectionListReturned);
        assertEquals(operator, vehicleIdProjectionListReturned.get(0).getOperator());
        assertEquals(vehicleId, vehicleIdProjectionListReturned.get(0).getVehicleId());
    }

    @Test(expected = BusinessException.class)
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() {
        // Act & Assert
        String startTime = "1";
        String endTime = "20121123080001000";
        String operator = "PO";

        try {
            dublinGpsDataServiceImpl
                    .getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
        } catch (BusinessException be) {
            String exceptionMessage = "Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid start time was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() {
        // Act & Assert
        String startTime = "20121123080000000";
        String endTime = "1";
        String operator = "PO";

        try {
            dublinGpsDataServiceImpl
                    .getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
        } catch (BusinessException be) {
            String exceptionMessage = "End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid end time was not thrown!");
    }

    @Test
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        String operator = "PO";
        Integer vehicleId = 33445;
        Integer stopId = 1715;
        Boolean atStop = true;

        VehicleAtStopProjection vehicleAtStopProjection = factory.createProjection(VehicleAtStopProjection.class);
        vehicleAtStopProjection.setOperator(operator);
        vehicleAtStopProjection.setVehicleId(vehicleId);
        vehicleAtStopProjection.setStopId(stopId);
        vehicleAtStopProjection.setAtStop(atStop);

        List<VehicleAtStopProjection> vehicleAtStopProjectionListToBeReturned =
                Collections.singletonList(vehicleAtStopProjection);

        // Act
        when(dublinGpsDataRepository
                     .getVehicleAtStopByStartTimeAndEndTimeAndOperator(anyLong(), anyLong(), anyString()))
                .thenReturn(vehicleAtStopProjectionListToBeReturned);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<VehicleAtStopProjection> vehicleAtStopProjectionListReturned =
                dublinGpsDataServiceImpl.getVehicleAtStopByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);

        // Assert
        assertNotNull(vehicleAtStopProjectionListReturned);
        assertEquals(operator, vehicleAtStopProjectionListReturned.get(0).getOperator());
        assertEquals(vehicleId, vehicleAtStopProjectionListReturned.get(0).getVehicleId());
        assertEquals(stopId, vehicleAtStopProjectionListReturned.get(0).getStopId());
        assertEquals(atStop, vehicleAtStopProjectionListReturned.get(0).getAtStop());
    }

    @Test(expected = BusinessException.class)
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() {
        // Act & Assert
        String startTime = "1";
        String endTime = "20121123080001000";
        String operator = "PO";

        try {
            dublinGpsDataServiceImpl
                    .getVehicleAtStopByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
        } catch (BusinessException be) {
            String exceptionMessage = "Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid start time was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() {
        // Act & Assert
        String startTime = "20121123080000000";
        String endTime = "1";
        String operator = "PO";

        try {
            dublinGpsDataServiceImpl
                    .getVehicleAtStopByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);
        } catch (BusinessException be) {
            String exceptionMessage = "End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid end time was not thrown!");
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorSuccessfully() {
        // Arrange
        Integer vehicleId = 33445;

        Long timeStampFirstPosition = 1353628801000000L;
        Double lonFirstPosition = -6.49107600;
        Double latFirstPosition = 53.37223800;

        Long timeStampSecondPosition = 1353628804000000L;
        Double lonSecondPosition = -6.46265700;
        Double latSecondPosition = 53.35524400;

        Long timeStampThirdPosition = 1353628807000000L;
        Double lonThirdPosition = -6.37060000;
        Double latThirdPosition = 53.31783300;

        VehicleTraceProjection vehicleTraceProjectionFirstPosition =
                factory.createProjection(VehicleTraceProjection.class);
        vehicleTraceProjectionFirstPosition.setTimestamp(timeStampFirstPosition);
        vehicleTraceProjectionFirstPosition.setLon(lonFirstPosition);
        vehicleTraceProjectionFirstPosition.setLat(latFirstPosition);
        vehicleTraceProjectionFirstPosition.setVehicleId(vehicleId);


        VehicleTraceProjection vehicleTraceProjectionSecondPosition =
                factory.createProjection(VehicleTraceProjection.class);
        vehicleTraceProjectionSecondPosition.setTimestamp(timeStampSecondPosition);
        vehicleTraceProjectionSecondPosition.setLon(lonSecondPosition);
        vehicleTraceProjectionSecondPosition.setLat(latSecondPosition);
        vehicleTraceProjectionSecondPosition.setVehicleId(vehicleId);

        VehicleTraceProjection vehicleTraceProjectionThirdPosition =
                factory.createProjection(VehicleTraceProjection.class);
        vehicleTraceProjectionThirdPosition.setTimestamp(timeStampThirdPosition);
        vehicleTraceProjectionThirdPosition.setLon(lonThirdPosition);
        vehicleTraceProjectionThirdPosition.setLat(latThirdPosition);
        vehicleTraceProjectionThirdPosition.setVehicleId(vehicleId);

        List<VehicleTraceProjection> vehicleTraceProjectionListToBeReturned =
                Arrays.asList(vehicleTraceProjectionFirstPosition, vehicleTraceProjectionSecondPosition,
                              vehicleTraceProjectionThirdPosition);

        // Act
        when(dublinGpsDataRepository.getVehicleTraceByStartTimeAndEndTimeAndOperator(anyLong(), anyLong(), anyInt()))
                .thenReturn(vehicleTraceProjectionListToBeReturned);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<VehicleTraceProjection> vehicleTraceProjectionListReturned =
                dublinGpsDataServiceImpl.getVehicleTraceByStartTimeAndEndTimeAndOperator(startTime, endTime, vehicleId);

        // Assert
        assertNotNull(vehicleTraceProjectionListReturned);

        assertEquals(vehicleTraceProjectionFirstPosition, vehicleTraceProjectionListReturned.get(0));
        assertEquals(timeStampFirstPosition, vehicleTraceProjectionListReturned.get(0).getTimestamp());
        assertEquals(lonFirstPosition, vehicleTraceProjectionListReturned.get(0).getLon());
        assertEquals(latFirstPosition, vehicleTraceProjectionListReturned.get(0).getLat());
        assertEquals(vehicleId, vehicleTraceProjectionListReturned.get(0).getVehicleId());


        assertEquals(vehicleTraceProjectionSecondPosition, vehicleTraceProjectionListReturned.get(1));
        assertEquals(timeStampSecondPosition, vehicleTraceProjectionListReturned.get(1).getTimestamp());
        assertEquals(lonSecondPosition, vehicleTraceProjectionListReturned.get(1).getLon());
        assertEquals(latSecondPosition, vehicleTraceProjectionListReturned.get(1).getLat());
        assertEquals(vehicleId, vehicleTraceProjectionListReturned.get(1).getVehicleId());


        assertEquals(vehicleTraceProjectionThirdPosition, vehicleTraceProjectionListReturned.get(2));
        assertEquals(timeStampThirdPosition, vehicleTraceProjectionListReturned.get(2).getTimestamp());
        assertEquals(lonThirdPosition, vehicleTraceProjectionListReturned.get(2).getLon());
        assertEquals(latThirdPosition, vehicleTraceProjectionListReturned.get(2).getLat());
        assertEquals(vehicleId, vehicleTraceProjectionListReturned.get(2).getVehicleId());

    }

    @Test(expected = BusinessException.class)
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() {
        // Act & Assert
        String startTime = "1";
        String endTime = "20121123080001000";
        Integer vehicleId = 33445;

        try {
            dublinGpsDataServiceImpl
                    .getVehicleTraceByStartTimeAndEndTimeAndOperator(startTime, endTime, vehicleId);
        } catch (BusinessException be) {
            String exceptionMessage = "Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid start time was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() {
        // Act & Assert
        String startTime = "20121123080000000";
        String endTime = "1";
        Integer vehicleId = 33445;

        try {
            dublinGpsDataServiceImpl
                    .getVehicleTraceByStartTimeAndEndTimeAndOperator(startTime, endTime, vehicleId);
        } catch (BusinessException be) {
            String exceptionMessage = "End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid end time was not thrown!");
    }
}
