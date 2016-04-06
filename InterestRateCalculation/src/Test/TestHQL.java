package Test;

import Model.Asset;
import Model.User;
import Until.HibernateFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by pc on 2016/4/6.
 */
public class TestHQL {

    @Test
    public void testCatipal(){
        Session session = null;
        try {
            //获取 session
            session = HibernateFactory.openSession();

            List<User> users = session.createQuery("select user from User user left join user.assets  asset where user.name like '%张%'")
                    .setFirstResult(0).setMaxResults(15)
                    .list();
            for (User user : users){
                for(Asset asset:user.getAssets()) {
                    System.out.println(user.getName() + " " + asset.getCatipal() +" "+ asset.getType() +" "+ asset.getNowdate());
                }
            }

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
