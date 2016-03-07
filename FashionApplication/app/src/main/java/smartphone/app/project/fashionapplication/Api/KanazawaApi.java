package smartphone.app.project.fashionapplication.Api;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import smartphone.app.project.fashionapplication.Entity.KanazawaEntity;

/**
 * Created by Yuki on 2016/03/05.
 */
public interface KanazawaApi {
    @GET("/{name}.json")// 「/」から開始しないとはじかれる
    public Observable<KanazawaEntity> getEvent(@Path("name")String url);
}
