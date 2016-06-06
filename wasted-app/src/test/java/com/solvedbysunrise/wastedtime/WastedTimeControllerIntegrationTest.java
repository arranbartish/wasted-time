package com.solvedbysunrise.wastedtime;

import com.solvedbysunrise.wastedtime.config.TestConfiguration;
import com.solvedbysunrise.wastedtime.dto.WastedTime;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

import static com.solvedbysunrise.wastedtime.util.UriUtil.getFullyQualifiedUriPattern;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.arrayContaining;
import static org.joda.time.DateTime.now;
import static org.joda.time.Duration.standardMinutes;
import static org.junit.Assert.assertThat;

@Rollback
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WastedtimeApplication.class, TestConfiguration.class})
@WebIntegrationTest
public class WastedTimeControllerIntegrationTest {

    private static final String WASTED_RESOURCE = "wasted";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String wastedTimeBaseUrl;


    @Test
    public void wasted_time_will_be_ok_with_payload() throws Exception {
        final URI wastedUri = new UriTemplate(getFullyQualifiedUriPattern(wastedTimeBaseUrl, WASTED_RESOURCE)).expand();
        final WastedTime wasted = new WastedTime("Arran", standardMinutes(30), "Tracking time", now());
        final RequestEntity<WastedTime> entity = new RequestEntity<>(wasted, HttpMethod.POST, wastedUri);

        ResponseEntity<String> exchange = restTemplate.exchange(entity, String.class);
        assertThat(exchange.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void wasted_time_will_return_collection_including_item_when_posted_with_item() throws Exception {
        final URI wastedUri = new UriTemplate(getFullyQualifiedUriPattern(wastedTimeBaseUrl, WASTED_RESOURCE)).expand();
        final WastedTime wasted = new WastedTime("Arran", standardMinutes(30), "Tracking time", now());

        ResponseEntity<WastedTime[]> wastedTimeResponseEntity = restTemplate.postForEntity(wastedUri, wasted, WastedTime[].class);
        WastedTime[] wastedTime = wastedTimeResponseEntity.getBody();
        assertThat(wastedTime, arrayContaining(wasted));
    }

    @Test
    public void wasted_time_will_be_ok_on_get() throws Exception {
        final URI wastedUri = new UriTemplate(getFullyQualifiedUriPattern(wastedTimeBaseUrl, WASTED_RESOURCE)).expand();

        ResponseEntity<WastedTime[]> exchange = restTemplate.getForEntity(wastedUri, WastedTime[].class);
        assertThat(exchange.getStatusCode(), is(HttpStatus.OK));
    }

}