package daimlerapp.service.dublingpsdata;

import daimlerapp.exception.BusinessException;
import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.repository.DublinGpsDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

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

        List<RunningOperatorsProjection> dublinGpsDataModelList = Collections.singletonList(runningOperatorsProjection);

        // Act
        when(dublinGpsDataRepository.getRunningOperatorsByStartTimeAndEndTime(anyLong(), anyLong()))
                .thenReturn(dublinGpsDataModelList);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<RunningOperatorsProjection> runningOperatorsProjectionList = dublinGpsDataServiceImpl
                .getRunningOperatorsByStartTimeAndEndTime(startTime, endTime);

        // Assert
        assertNotNull(runningOperatorsProjectionList);
        assertEquals(operator, runningOperatorsProjectionList.get(0).getOperator());
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

        VehicleIdProjection vehicleIdProjection =
                factory.createProjection(VehicleIdProjection.class);
        vehicleIdProjection.setOperator(operator);
        vehicleIdProjection.setVehicleId(vehicleId);

        List<VehicleIdProjection> dublinGpsDataModelList = Collections.singletonList(vehicleIdProjection);

        // Act
        when(dublinGpsDataRepository.getVehicleIdByStartTimeAndEndTimeAndOperator(anyLong(), anyLong(), anyString()))
                .thenReturn(dublinGpsDataModelList);

        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        List<VehicleIdProjection> vehicleIdProjectionList =
                dublinGpsDataServiceImpl.getVehicleIdByStartTimeAndEndTimeAndOperator(startTime, endTime, operator);

        // Assert
        assertNotNull(vehicleIdProjectionList);
        assertEquals(operator, vehicleIdProjectionList.get(0).getOperator());
        assertEquals(vehicleId, vehicleIdProjectionList.get(0).getVehicleId());
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


}
