package kr.co.FortunaFinance_Server.Validation.LoginRegister;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * The RegisterVal class provides functionality to validate an address and its associated postcode
 * by querying the Kakao Maps API.
 *
 * This class uses the Kakao Maps API to verify if a given address corresponds to a specified postcode.
 * It sends a request to the API, parses the JSON response, and checks if any of the returned addresses
 * match the given postcode.
 */
@Component
public class RegisterVal {

    private static final Logger logger = LoggerFactory.getLogger(RegisterVal.class);
    private static final String API_KEY = "f640fbd12e6e76290f4175aa9dc7fef2"; // 카카오 API 키를 여기에 입력
    private static final String API_URL = "https://dapi.kakao.com/v2/local/search/address.json?query={address}";

    /**
     * Validates if the given address corresponds to the specified postcode by querying the Kakao Maps API.
     *
     * @param address The address to be validated.
     * @param postcode The postcode to be validated against.
     * @return true if the address matches the postcode, false otherwise.
     * @throws ParseException If there is an error parsing the JSON response from the API.
     */
    public boolean validateAddress(String address, String postcode) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("query", address);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        // 응답 로그 남기기
        logger.info("API Response: {}", response.getBody());

        // JSON 파싱
        JSONParser parser = new JSONParser();
        JSONObject responseBody = (JSONObject) parser.parse(response.getBody());
        JSONArray documents = (JSONArray) responseBody.get("documents");

        boolean isValid = false;
        for (Object document : documents) {
            JSONObject doc = (JSONObject) document;
            String returnedPostcode = (String) doc.get("zone_no");
            if (returnedPostcode != null && returnedPostcode.equals(postcode)) {
                isValid = true; // 우편번호와 주소가 매치되면 true 반환
                break;
            }
        }

        // 결과 로그 남기기
        if (isValid) {
            logger.info("Address validation successful: Address [{}] matches the postcode [{}]", address, postcode);
        } else {
            logger.info("Address validation failed: No matching address found for postcode [{}]", postcode);
        }

        return isValid; // 매치되는 주소가 없다면 false 반환
    }
}
