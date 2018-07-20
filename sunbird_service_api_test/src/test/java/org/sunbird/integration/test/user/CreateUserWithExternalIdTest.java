package org.sunbird.integration.test.user;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.testng.CitrusParameters;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.sunbird.integration.test.common.BaseCitrusTestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateUserWithExternalIdTest extends BaseCitrusTestRunner {

  public static final String TEST_NAME_CREATE_USER_FAILURE_WITH_DUPLICATE_EXTERNAL_ID =
      "testCreateUserFailureWithDuplicateExternalId";
  public static final String
      TEST_NAME_CREATE_USER_FAILURE_WITH_DUPLICATE_EXTERNAL_TYPE_AND_PROVIDER =
          "testCreateUserFailureWithDuplicateExternalIdTypeAndProvider";

  public static final String TEMPLATE_DIR = "templates/user/create";

  private String getCreateUserUrl() {

    return getLmsApiUriPath("/api/user/v1/create", "/v1/user/create");
  }

  @DataProvider(name = "createUserFailureDataProvider")
  public Object[][] createUserFailureDataProvider() {

    return new Object[][] {
      new Object[] {
        TEST_NAME_CREATE_USER_FAILURE_WITH_DUPLICATE_EXTERNAL_ID, false, HttpStatus.BAD_REQUEST
      },
      new Object[] {
        TEST_NAME_CREATE_USER_FAILURE_WITH_DUPLICATE_EXTERNAL_TYPE_AND_PROVIDER,
        false,
        HttpStatus.BAD_REQUEST
      }
    };
  }

  @Test(dataProvider = "createUserFailureDataProvider")
  @CitrusParameters({"testName", "isAuthRequired", "httpStatusCode"})
  @CitrusTest
  public void testCreateUserFailure(
      String testName, boolean isAuthRequired, HttpStatus httpStatusCode) {
    performPostTest(
        this,
        TEMPLATE_DIR,
        testName,
        getCreateUserUrl(),
        REQUEST_JSON,
        MediaType.APPLICATION_JSON,
        isAuthRequired,
        httpStatusCode,
        RESPONSE_JSON);
  }
}
