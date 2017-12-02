package youp.zvh_android.webservice;

import java.util.List;

import youp.zvh_android.models.Consultant;
import youp.zvh_android.models.HealthIssue;
import youp.zvh_android.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {

    @GET("Consultants")
    Call<List<Consultant>> getAllConsultants();

    @POST("/Users/register")
    Call<User> register (@Body User user);

    @GET("HealthIssues")
    Call<List<HealthIssue>> getAllHealthIssues();

//    @GET("Articles/{nextId}")
//    Call<RootObject> getMoreArticles(@Header("x-authtoken") String api_token, @Path("nextId") int nextId, @Query("count") int count);
//
//    @GET("Articles/?feeds={feedId}")
//    Call<RootObject> getArticlesByCategory(@Header("x-authtoken") String api_token, @Query("feedId") int count);
//
//    @GET("Articles/Liked")
//    Call<RootObject> getLikedArticles(@Header("x-authtoken") String api_token);
//
//    @DELETE("Articles/{Id}/like")
//    Call<Void> Unlik                                                                eArticle(@Header("x-authtoken") String api_token, @Path("Id") String id);
//
//    @PUT("Articles/{Id}/like")
//    Call<Void> likeArticle(@Header("x-authtoken") String api_token, @Path("Id") String id);
//
//    @POST("Users/register")
//    Call <ServerResponse> register (@Body User user);
//
//    @POST("Users/login")
//    Call<AuthTokenResponse> getAuthToken(@Body User user);
}
