import org.example.endpoint.UniversityRestService;
import org.example.models.UniversityResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.example.university.RomaniaUniversity;
import org.example.university.TurkeyUniversity;

import java.util.stream.Collectors;

import static org.example.enums.CountryCodeEnum.RO;

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

    @Test
    public void compareUniversitiesOfRomaniaAndTurkey() {

        System.setProperty("log4j.configurationFile", "log4j2.xml");

        logger.info("University test started");
        logger.error("University test started");
        RomaniaUniversity romaniaUniversity = new RomaniaUniversity();
        var response1 = romaniaUniversity.getUniversityByCountryRomania().body();
        romaniaUniversity.getAllUniversitiesIgroningCountryFilter();

        TurkeyUniversity turkeyUniversity = new TurkeyUniversity();
        var response2 = turkeyUniversity.getUniversityByCountryTurkey().body();
        turkeyUniversity.getAllUniversitiesIgroningCountryFilter();

        Assert.assertNotNull(response1);
        Assert.assertNotNull(response2);

        Assertions.assertThat(response1.size())
            .describedAs("There are more universities in Romania(" + response1.size()
                             + ") then in Turkey(" + response2.size() + ").")
            .isLessThan(response2.size());

        logger.info("University test ended");
        logger.error("University test ended");
    }


}
