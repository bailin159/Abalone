package com.example.bailin.abalone.tools;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;

import com.example.bailin.abalone.service.CollectBean;
import com.example.bailin.abalone.service.CollectBeanDao;
import com.example.bailin.abalone.service.DaoMaster;
import com.example.bailin.abalone.service.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 白霖 on 16/10/8.
 */
public class DBTools {
    private static DBTools dbTools;
    private final CollectBeanDao collectBeanDao;
    private final Handler mHandler;
    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    private DBTools(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getContext(), "BL.db");
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        collectBeanDao = daoSession.getCollectBeanDao();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static DBTools getInstance(){
        if (dbTools == null) {
            synchronized (DBTools.class){
                if (dbTools == null) {
                    dbTools = new DBTools();
                }
            }
        }
        return dbTools;
    }

    // 单个插入
    public void singleInsert(final CollectBean collectBean) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                collectBeanDao.insert(collectBean);
            }
        });
    }

    // 查询全部
    public void queryAll(final QueryListener queryListener){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder<CollectBean> queryBuilder = collectBeanDao.queryBuilder();
                List<CollectBean> list = queryBuilder.list();
                mHandler.post(new HandlerRunnable(list, queryListener));
            }
        });
    }

    // 条件查询
    public void singleQuery(final String str, final QueryListener queryListener){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder<CollectBean> queryBuilder = collectBeanDao.queryBuilder();
                queryBuilder.where(CollectBeanDao.Properties.Res_title.eq(str)).build();
                List<CollectBean> list = queryBuilder.list();
                mHandler.post(new HandlerRunnable(list, queryListener));
            }
        });
    }

    // 删除数据
    public void singleDelete(final String str){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder<CollectBean> queryBuilder = collectBeanDao.queryBuilder();
                queryBuilder.where(CollectBeanDao.Properties.Res_title.eq(str)).build();
                List<CollectBean> list = queryBuilder.list();
                for (CollectBean collectBean : list) {
                    collectBeanDao.delete(collectBean);
                }
            }
        });
    }

    class HandlerRunnable implements Runnable{
        List<CollectBean> list;
        QueryListener queryListener;

        public HandlerRunnable(List<CollectBean> list, QueryListener queryListener) {
            this.list = list;
            this.queryListener = queryListener;
        }

        @Override
        public void run() {
            queryListener.onQueryComplete(list);
        }
    }

    public interface QueryListener{
        void onQueryComplete(List<CollectBean> list);
    }
}