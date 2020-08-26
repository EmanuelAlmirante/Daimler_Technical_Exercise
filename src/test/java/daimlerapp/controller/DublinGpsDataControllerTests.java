package daimlerapp.controller;

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

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DublinGpsDataControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getRunningOperatorsByStartTimeAndEndTimeSuccessfully() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "20121123080001000";

        String uri = "/daimler/api/gps-data/running-operators?starttime=" + startTime + "&endtime=" + endTime;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void getVehicleIdByStartTimeAndEndTimeAndOperatorSuccessfully() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "20121123080001000";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/vehicle-ids?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void getVehicleAtStopByStartTimeAndEndTimeAndOperatorSuccessfully() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "20121123080001000";
        String operator = "PO";

        String uri = "/daimler/api/gps-data/at-stop?starttime=" + startTime + "&endtime=" + endTime + "&operator=" +
                operator;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void getVehicleTraceByStartTimeAndEndTimeAndOperatorSuccessfully() throws Exception {
        // Arrange
        String startTime = "20121123080000000";
        String endTime = "20121123080001000";
        Integer vehicleId = 33445;

        String uri =
                "/daimler/api/gps-data/gps-tracing?starttime=" + startTime + "&endtime=" + endTime + "&vehicleid=" +
                        vehicleId;

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }
}
