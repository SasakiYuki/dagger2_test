package smartphone.app.project.fashionapplication.Activity.Sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import smartphone.app.project.fashionapplication.Dagger.DaggerProductionComponent;
import smartphone.app.project.fashionapplication.Dagger.ProductionApiManager;
import smartphone.app.project.fashionapplication.Dagger.ProductionComponent;
import smartphone.app.project.fashionapplication.Entity.BrandEntity;
import smartphone.app.project.fashionapplication.Entity.GuestEntity;
import smartphone.app.project.fashionapplication.Entity.Item.BrandItem;
import smartphone.app.project.fashionapplication.Entity.Item.GuestItem;
import smartphone.app.project.fashionapplication.Entity.Item.NewsItem;
import smartphone.app.project.fashionapplication.Entity.NewsEntity;
import smartphone.app.project.fashionapplication.R;
import smartphone.app.project.fashionapplication.Utils.BrandCallBacks;
import smartphone.app.project.fashionapplication.Utils.GuestCallBacks;
import smartphone.app.project.fashionapplication.Utils.NewsCallBacks;
import smartphone.app.project.fashionapplication.Utils.RxUtils;

/*
* まずはSampleActivityをご確認ください。似たようなことが書いてあります。ちなみにSampleActivityのほうはIntentさせれば動くのでぜひご確認ください
* 手順としてはMainApiManagerを使いたいActivityをProductionComponentに追加してInjectできるようにする
* お作法となる※1の２行書く
* 必要なObservableを取得する
* ※3でそれぞれに応じたRxUtilsのパーサに投げます
* ※4でcallBackを実装します。そこに値が流れ込んできます。
* */
public class ProductionSampleActivity extends AppCompatActivity implements NewsCallBacks,BrandCallBacks,GuestCallBacks{
    @Inject
    ProductionApiManager m_apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sample);

        //※1
        ProductionComponent component = DaggerProductionComponent.create();
        component.inject(this);

        //※2 news,brand,guestすべてを取得してます
        Observable<NewsEntity> newsEntityObservable = m_apiManager.getNews();
        Observable<NewsEntity> newsEntityObservable1 = m_apiManager.getNews(1);//IDを指定できます
        Observable<BrandEntity> brandEntityObservable = m_apiManager.getBrand();
        Observable<GuestEntity> guestEntityObservable = m_apiManager.getGuest();

        //※3
        RxUtils.INSTANCE.parseNewsObserver(ProductionSampleActivity.this,newsEntityObservable);
        RxUtils.INSTANCE.parseBrandObserver(ProductionSampleActivity.this,brandEntityObservable);
        RxUtils.INSTANCE.parseGuestObserver(ProductionSampleActivity.this,guestEntityObservable);
    }

    @Override
    public void BrandListCallBack(@NotNull ArrayList<BrandItem> list) {

    }

    @Override
    public void GuestListCallBack(@NotNull ArrayList<GuestItem> list) {

    }

    @Override
    public void BaseUrlCallBack(@NotNull String url) {

    }

    @Override
    public void NewsListCallBack(@NotNull ArrayList<NewsItem> list) {

    }
}
