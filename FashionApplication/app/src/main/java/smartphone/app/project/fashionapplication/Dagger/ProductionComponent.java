package smartphone.app.project.fashionapplication.Dagger;

import javax.inject.Singleton;

import dagger.Component;
import smartphone.app.project.fashionapplication.Activity.Sample.KanazawaSampleActivity;
import smartphone.app.project.fashionapplication.Activity.Sample.ProductionSampleActivity;

/**
 * Created by Yuki on 2016/03/05.
 */
@Singleton
@Component(modules = ProductionModule.class)
public interface ProductionComponent {
    void inject(ProductionSampleActivity activity);//こんな感じで依存性の注入をしたいActivityを書く
    void inject(KanazawaSampleActivity activity);
}
