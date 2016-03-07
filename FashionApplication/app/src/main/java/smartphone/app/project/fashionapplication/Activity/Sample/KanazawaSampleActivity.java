package smartphone.app.project.fashionapplication.Activity.Sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import smartphone.app.project.fashionapplication.Dagger.DaggerProductionComponent;
import smartphone.app.project.fashionapplication.Dagger.ProductionApiManager;
import smartphone.app.project.fashionapplication.Dagger.ProductionComponent;
import smartphone.app.project.fashionapplication.Entity.Item.KanazawaItem;
import smartphone.app.project.fashionapplication.R;
import smartphone.app.project.fashionapplication.Utils.KanazawaCallBacks;
import smartphone.app.project.fashionapplication.Utils.RxUtils;

public class KanazawaSampleActivity extends AppCompatActivity implements KanazawaCallBacks{
    @Inject
    ProductionApiManager m_apiManager;//依存性の注入をしています　意味わかんないと思いますが気にする必要はありません。とりあえず書こう

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanazawa_sample);

        ProductionComponent component = DaggerProductionComponent.create();
        component.inject(this);//お作法です。書いてください。ちなみに新しくActivityを作りそこに依存性の注入をしたい場合は
        //ProductionComponentに書いてください

        RxUtils.INSTANCE.parseKanazawaObserver(KanazawaSampleActivity.this,m_apiManager.getItem());//getItemでAPIを叩いています　そうするとObservable<T>が帰ってきます
        /*RxUtilsにゲットしたObservableを投げるとParseしてくれます。RxListenerをcallbackとして用いているのでそこでいじくりまわしてください。
        */
    }

    @Override
    public void BaseUrlCallBack(@NotNull String baseUrl) {}

    @Override
    public void KanazawaItemListCallBack(@NotNull List<KanazawaItem> list) {}
}
