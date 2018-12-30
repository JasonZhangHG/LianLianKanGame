package whu.iss.sric.utils;

import android.content.Context;

import com.aidebar.greendaotest.gen.DBScoreBeanDao;
import com.aidebar.greendaotest.gen.DaoManager;

import java.util.List;

import whu.iss.sric.bean.DBScoreBean;

public class DBScoreBeanDaoUtils {

    private DBScoreBeanDao resultDaoDao;
    private static DBScoreBeanDaoUtils dbBeanResultDaoUtils = null;

    public static DBScoreBeanDaoUtils getInstance() {
        return dbBeanResultDaoUtils;
    }

    public static void Init(Context context) {
        if (dbBeanResultDaoUtils == null) {
            dbBeanResultDaoUtils = new DBScoreBeanDaoUtils(context);
        }
    }

    public DBScoreBeanDaoUtils(Context context) {
        resultDaoDao = DaoManager.getInstance(context).getNewSession().getDBScoreBeanDao();
    }

    /**
     * 完成对数据库中插入一条数据操作
     *
     * @param resultDao
     * @return
     */
    public void insertOneData(DBScoreBean resultDao) {
        resultDaoDao.insertOrReplace(resultDao);
    }

    /**
     * 完成对数据库中插入多条数据操作
     *
     * @param resultDaoList
     * @return
     */
    public boolean insertManyData(List<DBScoreBean> resultDaoList) {
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
    public boolean deleteOneData(DBScoreBean resultDao) {
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
    public boolean deleteManData(List<DBScoreBean> resultDaoList) {
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
    public boolean updateData(DBScoreBean resultDao) {
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
    public boolean updateManData(List<DBScoreBean> resultDaoList) {
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
    public DBScoreBean queryOneData(long id) {
        return resultDaoDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<DBScoreBean> queryAllData() {
        return resultDaoDao.loadAll();
    }
}
