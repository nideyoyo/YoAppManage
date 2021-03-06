package com.yoyo.yoappmanage.common.util;


import com.yoyo.yoappmanage.config.AppConfig;

import org.xutils.DbManager;
import org.xutils.x;

import java.util.List;

/**
 * 项目名称：PartTimeCat
 * 类描述：
 * 创建人：yoyo
 * 创建时间：2015/11/5 20:51
 * 修改人：yoyo
 * 修改时间：2015/11/5 20:51
 * 修改备注：
 */
public class X3DBUtils {
    public static  DbManager.DaoConfig getDaoConfig(String dbName){
       /* DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName(dbName)
                .setDbVersion(AppConfig.DBVersion);*/
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName(dbName)
               // .setDbDir(new File("/sdcard"))
                .setDbVersion(AppConfig.DBVersion)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                    }
                });
        return daoConfig;
    }
   /* public static DbManager getDb(String dbName){
        DbManager db = x.getDb(getDaoConfig(dbName));
        return db;
    }*/
    public static DbManager getDb(){
        String dbName=ACacheUtils.getOpenId(x.Ext.app)+AppConfig.DBName;
        DbManager db = x.getDb( getDaoConfig(dbName));
        return db;
    }
    public static boolean save(Object items) {
        boolean isSaveSuccess=false;
        if (items == null) {
            return isSaveSuccess;
        }
        try {
            DbManager db = getDb();
            db.saveOrUpdate(items);
            isSaveSuccess=true;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return isSaveSuccess;
    }
    public static boolean delectById(Class<?> entityType, Object idValue) {
        boolean isDelectSuccess=false;
        if (idValue == null) {
            return isDelectSuccess;
        }
        try {
            DbManager db = getDb();
            db.deleteById(entityType, idValue);
            isDelectSuccess=true;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return isDelectSuccess;
    }

    public static  <T> List<T> findAll(Class<T> entityType)  {
        List<T> list=null;
        try {
            DbManager db = getDb();
            list= db.findAll(entityType);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return list;
    }
    public static  <T> List<T> findAll(Class<T> entityType,String columnName, String op, Object value)  {
        List<T> list=null;
        try {
            DbManager db = getDb();
            list= db.selector(entityType).where(columnName,op,value).findAll();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return list;
    }

    public static  <T> T findItem(Class<T> entityType, Object idValue)  {
        T item=null;
        try {
            DbManager db = getDb();
            item= db.findById(entityType,idValue);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return item;
    }

}
