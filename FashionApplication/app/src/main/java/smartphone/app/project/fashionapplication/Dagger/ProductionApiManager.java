package smartphone.app.project.fashionapplication.Dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import smartphone.app.project.fashionapplication.Api.FashionApi;
import smartphone.app.project.fashionapplication.Api.KanazawaApi;
import smartphone.app.project.fashionapplication.Entity.BrandEntity;
import smartphone.app.project.fashionapplication.Entity.GuestEntity;
import smartphone.app.project.fashionapplication.Entity.KanazawaEntity;
import smartphone.app.project.fashionapplication.Entity.NewsEntity;

/**
 * Created by Yuki on 2016/03/05.
 */
public class ProductionApiManager implements ApiManager{
    private static final String END_POINT ="??";//TODO END_POINTの設定
    private static final String END_PONT_KANAZAWA = "http://www.kanazawa-arts.or.jp";
    private static final int ID_NONE = -1;

    @Override
    public Observable<NewsEntity> getNews() {
        return startApi_news(ID_NONE);
    }

    @Override
    public Observable<NewsEntity> getNews(int id) {
        return startApi_news(id);
    }

    @Override
    public Observable<GuestEntity> getGuest() {
        return startApi_guest(ID_NONE);
    }

    @Override
    public Observable<GuestEntity> getGuest(int id) {
        return startApi_guest(id);
    }

    @Override
    public Observable<BrandEntity> getBrand() {
        return startApi_brand(ID_NONE);
    }

    @Override
    public Observable<BrandEntity> getBrand(int id) {
        return startApi_brand(id);
    }

    @Override
    public Observable<KanazawaEntity> getItem() {
        return startApi();
    }

    private Observable<NewsEntity> startApi_news(int id){
        Observable<NewsEntity> newsEntityObservable;
        if(id == ID_NONE) {
            newsEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getNews()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }else {
            newsEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getNews(id)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }
        return newsEntityObservable;
    }

    private Observable<BrandEntity> startApi_brand(int id){
        Observable<BrandEntity> guestEntityObservable;
        if(id == ID_NONE) {
            guestEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getBrand()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }else {
            guestEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getBrand(id)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }
        return guestEntityObservable;
    }

    private Observable<GuestEntity> startApi_guest(int id){
        Observable<GuestEntity> guestEntityObservable;
        if(id == ID_NONE){
            guestEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getGuest()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }else {
            guestEntityObservable =
                    createRestAdapter().create(FashionApi.class)
                            .getGuest(id)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread());
        }
        return guestEntityObservable;
    }

    private Observable<KanazawaEntity> startApi(){
        return createRestAdapter_KANAZAWA().create(KanazawaApi.class)
                .getEvent("event-all")
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Gson createGson(){
        return new GsonBuilder().create();
    }
    private RestAdapter createRestAdapter(){return new RestAdapter.Builder().setEndpoint(END_POINT).setConverter(new GsonConverter(createGson())).build();}
    private RestAdapter createRestAdapter_KANAZAWA(){
        return new RestAdapter.Builder().
                setEndpoint(END_PONT_KANAZAWA).
                setLogLevel(RestAdapter.LogLevel.FULL).
                setLog(new AndroidLog("=NETWORK")).
                setConverter(new GsonConverter(createGson())).
                build();
    }
}
