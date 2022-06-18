package nextstep.subway.station;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.subway.BaseAcceptanceTest;
import nextstep.subway.ResponseAssertTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("지하철역 관련 기능")
public class StationAcceptanceTest extends BaseAcceptanceTest {
    static final String rootPath = "/stations";
    static final List<String> stationNames = new ArrayList<>(Arrays.asList("수락산역", "마들역"));

    public static ExtractableResponse<Response> 지하철역_생성_요청(String name) {
        return RestAssured.given().log().all()
            .body(new HashMap<String, String>() {
                {
                    put("name", name);
                }
            })
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .when().post(rootPath)
            .then().log().all()
            .extract();
    }

    /**
     * When 지하철역을 생성하면
     * Then 지하철역이 생성된다
     * Then 지하철역 목록 조회 시 생성한 역을 찾을 수 있다
     */
    @DisplayName("지하철역을 생성한다.")
    @Test
    void createStation() {
        // when
        ExtractableResponse<Response> response = 지하철역_생성_요청(stationNames.get(0));

        // then
        ResponseAssertTest.생성_확인(response);

        // then
        ExtractableResponse<Response> getResponse = 지하철역_목록조회_요청();
        List<String> stationNamesOfResponse = getResponse.jsonPath().getList("name", String.class);
        assertThat(stationNamesOfResponse).containsAnyOf(stationNames.get(0));
    }

    /**
     * Given 지하철역을 생성하고
     * When 기존에 존재하는 지하철역 이름으로 지하철역을 생성하면
     * Then 지하철역 생성이 안된다
     */
    @DisplayName("기존에 존재하는 지하철역 이름으로 지하철역을 생성한다.")
    @Test
    void createStationWithDuplicateName() {
        // given
        지하철역_생성_요청(stationNames.get(0));

        // when
        ExtractableResponse<Response> response = 지하철역_생성_요청(stationNames.get(0));

        // then
        ResponseAssertTest.요청오류_확인(response);
    }

    /**
     * Given 2개의 지하철역을 생성하고
     * When 지하철역 목록을 조회하면
     * Then 2개의 지하철역을 응답 받는다
     */
    @DisplayName("지하철역을 조회한다.")
    @Test
    void getStations() {
        // given
        for (String station : stationNames) {
            지하철역_생성_요청(station);
        }

        // when
        ExtractableResponse<Response> response = 지하철역_목록조회_요청();

        // then
        assertAll(
            () -> ResponseAssertTest.성공_확인(response),
            () -> {
                List<String> findStations = response.jsonPath().getList("name", String.class);
                assertThat(findStations.size()).isEqualTo(stationNames.size());
                assertThat(findStations).contains(stationNames.toArray(new String[0]));
            }
        );
    }

    /**
     * Given 지하철역을 생성하고
     * When 그 지하철역을 삭제하면
     * Then 그 지하철역 목록 조회 시 생성한 역을 찾을 수 없다
     */
    @DisplayName("지하철역을 제거한다.")
    @Test
    void deleteStation() {
        // given
        ExtractableResponse<Response> createdResponse = 지하철역_생성_요청(stationNames.get(1));

        // when
        Long stationId = createdResponse.jsonPath().getLong("id");
        ExtractableResponse<Response> deleteResponse = 지하철역_삭제_요청(stationId);

        // then
        ExtractableResponse<Response> getResponse = 지하철역_목록조회_요청();
        assertAll(
            () -> ResponseAssertTest.빈응답_확인(deleteResponse),
            () -> ResponseAssertTest.성공_확인(getResponse),
            () -> {
                List<String> findStations = getResponse.jsonPath().getList("name", String.class);
                assertThat(findStations.size()).isZero();
                assertThat(findStations).doesNotContain(stationNames.get(1));
            }
        );
    }

    private ExtractableResponse<Response> 지하철역_삭제_요청(Long stationId) {
        return RestAssured.given().log().all()
            .when().delete(rootPath + "/" + stationId)
            .then().log().all()
            .extract();
    }

    private ExtractableResponse<Response> 지하철역_목록조회_요청() {
        return RestAssured.given().log().all()
            .when().get(rootPath)
            .then().log().all()
            .extract();
    }
}
