package Test;

import Model.Asset;
import Model.User;
import Until.HibernateFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by pc on 2016/4/6.
 */
public class TestHibernate {

    @Test
    public void testHibernate(){
        Session session = null;
        try {
            //获取 session
            session = HibernateFactory.openSession();
            //开始 业务 处理
            session.beginTransaction();


            //业务 提交
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //业务 回滚
            if (session != null) session.getTransaction().rollback();
        }finally {
            //业务 结束
            HibernateFactory.close(session);
        }
    }



}
