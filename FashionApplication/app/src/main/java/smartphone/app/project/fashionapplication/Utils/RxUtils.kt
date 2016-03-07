package smartphone.app.project.fashionapplication.Utils

import android.content.Context
import android.util.Log
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import smartphone.app.project.fashionapplication.Entity.BrandEntity
import smartphone.app.project.fashionapplication.Entity.GuestEntity
import smartphone.app.project.fashionapplication.Entity.Item.KanazawaItem
import smartphone.app.project.fashionapplication.Entity.KanazawaEntity
import smartphone.app.project.fashionapplication.Entity.NewsEntity

/**
 * Created by Yuki on 2016/03/05.
 */
object RxUtils {
    private val COMPLETED = "COMPLETED"
    private val ERROR = "ERROR"

    fun parseNewsObserver(context: Context, newsEntityObservable: Observable<NewsEntity>) {
        newsEntityObservable.subscribe(object : Subscriber<NewsEntity>() {
            override fun onCompleted() {
                Log.d("RxUtils.news", COMPLETED)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                Log.d("RxUtils.news", ERROR)
            }

            override fun onNext(newsEntity: NewsEntity) {
                (context as NewsCallBacks).BaseUrlCallBack(newsEntity.baseUrl)
                context.NewsListCallBack(newsEntity.newsItems)
            }
        })
    }

    fun parseBrandObserver(context: Context, brandEntityObservable: Observable<BrandEntity>) {
        brandEntityObservable.subscribe(object : Subscriber<BrandEntity>() {
            override fun onCompleted() {
                Log.d("RxUtils.brand", COMPLETED)
            }

            override fun onError(e: Throwable) {
                Log.d("RxUtils.brand", ERROR)
                e.printStackTrace()
            }

            override fun onNext(brandEntity: BrandEntity) {
                (context as BrandCallBacks).BaseUrlCallBack(brandEntity.baseUrl)
                context.BrandListCallBack(brandEntity.brandItems)
            }
        })
    }

    fun parseGuestObserver(context: Context, guestEntityObservable: Observable<GuestEntity>) {
        guestEntityObservable.subscribe(object : Subscriber<GuestEntity>() {
            override fun onCompleted() {
                Log.d("RxUtils.guest", COMPLETED)
            }

            override fun onError(e: Throwable) {
                Log.d("RxUtils.guest", ERROR)
                e.printStackTrace()
            }

            override fun onNext(guestEntity: GuestEntity) {
                (context as GuestCallBacks).BaseUrlCallBack(guestEntity.baseUrl)
                context.GuestListCallBack(guestEntity.GuestItems)
            }
        })
    }

    //金沢
    fun parseKanazawaObserver(context: Context, kanazawaEntityObservable: Observable<KanazawaEntity>) {
        kanazawaEntityObservable.map { kanazawaEntity -> kanazawaEntity.kanazawaItemses }.subscribeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<List<KanazawaItem>>() {
            override fun onCompleted() {
                Log.d("RxUtils", "COMPLETED")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                Log.d("RxUtils", "ERROR")
            }

            override fun onNext(kanazawaItemses: List<KanazawaItem>) {
                (context as KanazawaCallBacks).KanazawaItemListCallBack(kanazawaItemses)
            }
        })
        return
    }
}
