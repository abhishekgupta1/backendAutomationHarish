import Constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class PatchTeams {


    public void UpdateTeamID(){
        int TeamID = 3708330;

        RestAssured.baseURI = Constants.BASEURI;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "New Team Four"); // Cast
        requestParams.put("description", "A great team");
        requestParams.put("permission", "admin");
        requestParams.put("privacy", "closed");

        request.body(requestParams.toJSONString());
        Response response = request.put("/PATCH/"+ TeamID);

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 201);

    }
}