import endpoint.UniversityRestService;
import endpoint.UniversityService;
import lombok.SneakyThrows;
import models.UniversityResponse;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TestUniversities {

    @Test
    public void getUniversityOfRomania(){
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
