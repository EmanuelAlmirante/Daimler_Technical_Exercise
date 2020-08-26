package daimlerapp.service.dublingpsdata;

import daimlerapp.exception.BusinessException;
import daimlerapp.model.projection.RunningOperatorsProjection;
import daimlerapp.model.projection.VehicleAtStopProjection;
import daimlerapp.model.projection.VehicleIdProjection;
import daimlerapp.model.projection.VehicleTraceProjection;
import daimlerapp.repository.DublinGpsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DublinGpsDataServiceImpl implements DublinGpsDataService {
    private final DublinGpsDataRepository dublinGpsDataRepository;
    private static final int TIME_FORMAT_SIZE = 17;

    @Autowired
    public DublinGpsDataServiceImpl(DublinGpsDataRepository dublinGpsDataRepository) {
        this.dublinGpsDataRepository = dublinGpsDataRepository;
    }

    @Override
    public List<RunningOperatorsProjection> getRunningOperatorsByStartTimeAndEndTime(String startTime, String endTime) {
        verifyTimeInputIsValid(startTime, endTime);

        long epochStartTime = 0;
        long epochEndTime = 0;

        try {
            epochStartTime = convertTimeToEpochTime(startTime);
            epochEndTime = convertTimeToEpochTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dublinGpsDataRepository.getRunningOperatorsByStartTimeAndEndTime(epochStartTime, epochEndTime);
    }

    @Override
    public List<VehicleIdProjection> getVehicleIdByStartTimeAndEndTimeAndOperator(String startTime, String endTime,
                                                                                  String operator) {
        verifyTimeInputIsValid(startTime, endTime);

        long epochStartTime = 0;
        long epochEndTime = 0;

        try {
            epochStartTime = convertTimeToEpochTime(startTime);
            epochEndTime = convertTimeToEpochTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dublinGpsDataRepository
                .getVehicleIdByStartTimeAndEndTimeAndOperator(epochStartTime, epochEndTime, operator);
    }

    @Override
    public List<VehicleAtStopProjection> getVehicleAtStopByStartTimeAndEndTimeAndOperator(String startTime,
                                                                                          String endTime,
                                                                                          String operator) {
        verifyTimeInputIsValid(startTime, endTime);

        long epochStartTime = 0;
        long epochEndTime = 0;

        try {
            epochStartTime = convertTimeToEpochTime(startTime);
            epochEndTime = convertTimeToEpochTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dublinGpsDataRepository
                .getVehicleAtStopByStartTimeAndEndTimeAndOperator(epochStartTime, epochEndTime, operator);
    }

    @Override
    public List<VehicleTraceProjection> getVehicleTraceByStartTimeAndEndTimeAndOperator(String startTime,
                                                                                        String endTime,
                                                                                        int vehicleId) {
        verifyTimeInputIsValid(startTime, endTime);

        long epochStartTime = 0;
        long epochEndTime = 0;

        try {
            epochStartTime = convertTimeToEpochTime(startTime);
            epochEndTime = convertTimeToEpochTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dublinGpsDataRepository
                .getVehicleTraceByStartTimeAndEndTimeAndOperator(epochStartTime, epochEndTime, vehicleId);
    }

    private void verifyTimeInputIsValid(String startTime, String endTime) {
        if (startTime.length() != TIME_FORMAT_SIZE) {
            throw new BusinessException("Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS");
        }

        if (endTime.length() != TIME_FORMAT_SIZE) {
            throw new BusinessException("End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS");
        }
    }

    private long convertTimeToEpochTime(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = simpleDateFormat.parse(time);

        long epochTime = date.getTime() * 1000;

        return epochTime;
    }
}
