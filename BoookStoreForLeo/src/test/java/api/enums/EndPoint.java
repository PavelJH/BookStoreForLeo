package api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndPoint {
    POST_ACCOUNT_AUTHORIZED("/Account/v1/Authorized"),
    POST_ACCOUNT_V1_USER("/Account/v1/User"),
    DELETE_ACCOUNT_USER_ID("/Account/v1/User/{UUID}"),
    GET_ACCOUNT_V1_USER_ID("/Account/v1/User/{UUID}"),

    GET_BOOKSTORE_V1_BOOKS("/BookStore/v1/Books"),
    POST_BOOKSTORE_V1_BOOKS("/BookStore/v1/Books"),
    DELETE_BOOKSTORE_V1_BOOKS("/BookStore/v1/Books"),
    PUT_BOOKSTORE_V1_BOOKS_ISBN("/api/email/{id}/all/{ISBN}");
    private final String value;


}
