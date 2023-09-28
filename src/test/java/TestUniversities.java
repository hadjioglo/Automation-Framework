import endpoint.UniversityRestService;
import models.UniversityResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

import static enums.CountryCodeEnum.RO;

public class TestUniversities {
    private static final Logger logger = LogManager.getLogger(TestUniversities.class);

    @Test
    public void getUniversityOfRomania() {
        UniversityRestService universityRestService = new UniversityRestService();
        var response = universityRestService.getUniversityByCountry("romania").body();

        Assert.assertNotNull(response);
        var countryCode = response.stream()
                .map(UniversityResponse::getAlfaTwoCode)
                .collect(Collectors.toList());

        Assertions.assertThat(countryCode)
                .contains(RO.name());
        logger.error("Assertion passed" + countryCode + " contains " + "RO");
    }

    @Test
    public void getAllUniversities() {
        UniversityRestService universityRestService = new UniversityRestService();

        var response = universityRestService.getAllRequest().body();
        logger.error("response is received");

        Assert.assertNotNull(response);
        var countryCode = response.stream()
                .map(UniversityResponse::getAlfaTwoCode)
                .collect(Collectors.toList());

        Assertions.assertThat(countryCode)
                .contains("RO");
        logger.error("Assertion passed" + countryCode + " contains " + "RO");
    }
}
