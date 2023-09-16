import endpoint.UniversityRestService;
import models.UniversityResponse;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class TestUniversities {

    @Test
    public void getUniversityOfRomania() {
        UniversityRestService universityRestService = new UniversityRestService();
        var response = universityRestService.getUniversityByCountry("romania").body();
        Assert.assertNotNull(response);
        var countryCode = response.stream()
                .map(UniversityResponse::getAlfaTwoCode)
                .collect(Collectors.toList());

        Assertions.assertThat(countryCode)
                .contains("RO");
    }
}
