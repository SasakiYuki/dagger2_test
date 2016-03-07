package smartphone.app.project.fashionapplication.Api;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import smartphone.app.project.fashionapplication.Entity.BrandEntity;
import smartphone.app.project.fashionapplication.Entity.GuestEntity;
import smartphone.app.project.fashionapplication.Entity.NewsEntity;

/**
 * Created by Yuki on 2016/03/05.
 */
public interface FashionApi {
    @GET("/news/all")
    public Observable<NewsEntity> getNews();

    @GET("/news/{item_id}")
    public Observable<NewsEntity> getNews(@Path("item_id")int id);

    @GET("/brand/all")
    public Observable<BrandEntity> getBrand();

    @GET("/brand/{item_id")
    public Observable<BrandEntity> getBrand(@Path("item_id")int id);

    @GET("/guest/all")
    public Observable<GuestEntity> getGuest();

    @GET("/guest/{item_id")
    public Observable<GuestEntity> getGuest(@Path("item_id")int id);
}
