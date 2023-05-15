package api.tests;

import api.enums.EndPoint;
import api.model.account.AccountDTO;
import api.model.bookStoreDTO.ContactDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.print.Book;
import java.util.List;

public class BookStoreApi extends ApiBase{
    AccountDTO accountDTO;
    Response response;
    ContactDto contactDto;
    boolean trueFalse;
    @BeforeMethod(onlyForGroups = {"positive"})
    public void precondition(){
        accountDTO = createContact();
        response = doPostRequest(EndPoint.POST_ACCOUNT_AUTHORIZED, 200, accountDTO);
        boolean tureFalse = response.jsonPath().getBoolean("true");
    }
    @Test
    public void bookStoreV1Books() {

    }
}
