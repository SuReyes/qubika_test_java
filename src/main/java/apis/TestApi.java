package apis;

import base.RestClient;

public class TestApi extends RestClient {
    @Override
    protected String getBaseUrl() {
        return "https://reqres.in/api/";
    }
}
