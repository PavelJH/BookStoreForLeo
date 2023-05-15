package api.tests.address;

import api.enums.EndPoint;
import api.model.account.AccountDTO;

import api.model.bookStoreDTO.ContactDto;
import api.tests.ApiBase;

import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginApi extends ApiBase {
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

//    @AfterMethod(onlyForGroups = {"positive"})
//    public void afterTest() {
//        doDeleteRequest(EndPoint.DELETE_CONTACT, 200, id);
//    }

    @Test()
    public void loginWithApi() {
        accountDTO = new AccountDTO();
        accountDTO.setUserName("JH");
        accountDTO.setPassword("Jeffry080%");

        doPostRequest(EndPoint.POST_ACCOUNT_AUTHORIZED, 200, accountDTO);
    }
    @Test
    public void accountUser(){
        contactDto = new ContactDto();
        accountDTO = new AccountDTO();
        accountDTO.setUserName("JH");
        accountDTO.setPassword("Jeffry080%");

        doPostRequest(EndPoint.POST_ACCOUNT_V1_USER,201,contactDto);

    }




}
