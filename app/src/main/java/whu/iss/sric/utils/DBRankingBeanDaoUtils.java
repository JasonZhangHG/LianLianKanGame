package whu.iss.sric.utils;

import android.content.Context;

import com.aidebar.greendaotest.gen.DBRankingBeanDao;
import com.aidebar.greendaotest.gen.DaoManager;

import java.util.List;

import whu.iss.sric.bean.DBRankingBean;


public class DBRankingBeanDaoUtils {

    private DBRankingBeanDao resultDaoDao;

    private static DBRankingBeanDaoUtils dbBeanResultDaoUtils = null;

    public static DBRankingBeanDaoUtils getInstance() {
        return dbBeanResultDaoUtils;
    }

    public static void Init(Context context) {
        if (dbBeanResultDaoUtils == null) {
            dbBeanResultDaoUtils = new DBRankingBeanDaoUtils(context);
        }
    }

    public DBRankingBeanDaoUtils(Context context) {
        resultDaoDao = DaoManager.getInstance(context).getNewSession().getDBRankingBeanDao();
    }

    /**
     * 完成对数据库中插入一条数据操作
     *
     * @param resultDao
     * @return
     */
    public void insertOneData(DBRankingBean resultDao) {
        resultDaoDao.insertOrReplace(resultDao);
    }

    /**
     * 完成对数据库中插入多条数据操作
     *
     * @param resultDaoList
     * @return
     */
    public boolean insertManyData(List<DBRankingBean> resultDaoList) {
        boolean flag = false;
        try {
            resultDaoDao.insertOrReplaceInTx(resultDaoList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据操作
     *
     * @param resultDao
     * @return
     */
    public boolean deleteOneData(DBRankingBean resultDao) {
        boolean flag = false;
        try {
            resultDaoDao.delete(resultDao);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据 ByKey操作
     *
     * @return
     */
    public boolean deleteOneDataByKey(long id) {
        boolean flag = false;
        try {
            resultDaoDao.deleteByKey(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     *
     * @return
     */
    public boolean deleteManData(List<DBRankingBean> resultDaoList) {
        boolean flag = false;
        try {
            resultDaoDao.deleteInTx(resultDaoList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库更新数据操作
     *
     * @return
     */
    public boolean updateData(DBRankingBean resultDao) {
        boolean flag = false;
        try {
            resultDaoDao.update(resultDao);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库批量更新数据操作
     *
     * @return
     */
    public boolean updateManData(List<DBRankingBean> resultDaoList) {
        boolean flag = false;
        try {
            resultDaoDao.updateInTx(resultDaoList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库查询数据操作
     *
     * @return
     */
    public DBRankingBean queryOneData(long id) {
        return resultDaoDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<DBRankingBean> queryAllData() {
        return resultDaoDao.loadAll();
    }
}
