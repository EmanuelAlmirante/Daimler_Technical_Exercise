package daimlerapp.controller.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionHandlerControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getRunningOperatorsByStartTimeAndEndTimeWithInvalidStartTimeFails() throws Exception {
        // Arrange
        String startTime = "1";
        String endTime = "20121123080001000";

        String uri = "/daimler/api/gps-data/running-operators?starttime=" + startTime + "&endtime=" + endTime;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getRunningOperatorsByStartTimeAndEndTimeWithInvalidEndTimeFails() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "1";

        String uri = "/daimler/api/gps-data/running-operators?starttime=" + startTime + "&endtime=" + endTime;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() throws Exception {
        // Arrange
        String startTime = "1";
        String endTime = "20121123080001000";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/vehicle-ids?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "1";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/vehicle-ids?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() throws Exception {
        // Arrange
        String startTime = "1";
        String endTime = "20121123080001000";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/at-stop?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "1";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/at-stop?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorWithInvalidStartTimeFails() throws Exception {
        // Arrange
        String startTime = "1";
        String endTime = "20121123080001000";
        Integer vehicleId = 33445;

        String uri =
                "/daimler/api/gps-data/gps-tracing?starttime=" + startTime + "&endtime=" + endTime + "&vehicleid=" +
                        vehicleId;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Start time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorWithInvalidEndTimeFails() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "1";
        Integer vehicleId = 33445;

        String uri =
                "/daimler/api/gps-data/gps-tracing?starttime=" + startTime + "&endtime=" + endTime + "&vehicleid=" +
                        vehicleId;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"End time is not valid! Please insert time in the format: yyyyMMddHHmmssSSS\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorWithInvalidVehicleIdFails() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "20121123080001000";
        String vehicleId = "ABCDE";

        String uri =
                "/daimler/api/gps-data/gps-tracing?starttime=" + startTime + "&endtime=" + endTime + "&vehicleid=" +
                        vehicleId;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"TechnicalError\":{\"message\":\"Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \\\"ABCDE\\\"\"}}";

        // Assert
        assertNotNull(jsonResponse);
        assertEquals(expectedResponse, jsonResponse);
    }
}
