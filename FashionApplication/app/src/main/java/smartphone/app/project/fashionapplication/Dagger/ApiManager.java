package smartphone.app.project.fashionapplication.Dagger;

import rx.Observable;
import smartphone.app.project.fashionapplication.Entity.BrandEntity;
import smartphone.app.project.fashionapplication.Entity.GuestEntity;
import smartphone.app.project.fashionapplication.Entity.KanazawaEntity;
import smartphone.app.project.fashionapplication.Entity.NewsEntity;

/**
 * Created by Yuki on 2016/03/05.
 */
public interface ApiManager {
    public Observable<NewsEntity> getNews();
    public Observable<NewsEntity> getNews(int id);
    public Observable<GuestEntity> getGuest();
    public Observable<GuestEntity> getGuest(int id);
    public Observable<BrandEntity> getBrand();
    public Observable<BrandEntity> getBrand(int id);
    public Observable<KanazawaEntity> getItem();
}
