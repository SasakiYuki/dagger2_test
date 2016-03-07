package smartphone.app.project.fashionapplication.Dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yuki on 2016/03/05.
 */
@Module
public class ProductionModule {
    @Provides @Singleton
    public ApiManager provideApiManager(){
        return new ProductionApiManager();
    }
}
