package Until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by pc on 2016/4/6.
 */
public class HibernateFactory {
    /*
        * Hibernate Factory 类
        * 简化 调用 实现工厂类
        * */
    public final static SessionFactory FACTORY = buildSessionFactory();

    /*
    * 配置 hibernate
    * */
    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    /*
    *  获取 sessionFactory
    * */
    public static SessionFactory getFactory(){
        return FACTORY;
    }

    /*
    * 获取 session
    * */
    public static Session openSession(){
        return FACTORY.openSession();
    }

    /*
    * 关闭 session
    * */
    public static void close(Session session){
        if(session != null) session.close();
    }
}
