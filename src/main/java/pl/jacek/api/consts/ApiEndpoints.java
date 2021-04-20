package pl.jacek.api.consts;

public class ApiEndpoints {
    private static final String QUERY_PARAM_USER_ID = "/{id}";
    private static final String QUERY_PARAM_MEETING_ID = "/{meeting_id}";

    public static final String AUTHENTICATE = "/authenticate";
    public static final String USER = "/user";

    public static final String MEETING_ALL = ApiEndpoints.USER + ApiEndpoints.QUERY_PARAM_USER_ID + "/meeting";
    public static final String MEETING_SINGLE = ApiEndpoints.MEETING_ALL + ApiEndpoints.QUERY_PARAM_MEETING_ID;


    public static final String PARAM_LIMIT = "limit";
    public static final String PARAM_OFFSET = "offset";
    public static final String PARAM_SEARCH = "search";

}
