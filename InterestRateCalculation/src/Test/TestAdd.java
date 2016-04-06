package Test;

import Model.Asset;
import Model.User;
import Until.HibernateFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * Created by pc on 2016/4/6.
 */
public class TestAdd {

    /*
    * 随机数
    * */
    Random ran = new Random();

    @Test
    public void testAddUser(){
        Session session = null;
        try {
            //获取 session
            session = HibernateFactory.openSession();
            //开始 业务 处理
            session.beginTransaction();

            for (int i = 0;i<500;i++){
                User user = new User(getUserName(),getPassword(),getName());
                session.save(user);
            }

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

    @Test
    public void testAddAsset(){
        Session session = null;
        try {
            //获取 session
            session = HibernateFactory.openSession();
            //开始 业务 处理
            session.beginTransaction();
            /*
            * 用户 500 名
            * 每名用户资产信息 0 ~ 30 条
            * */
            for (int i = 0 ; i < 50 ; i++){
                User user = new User(getUserName(),getPassword(),getName());
                session.save(user);
                for (int j = 0 ; j < ran.nextInt(30) ; j++){
                    Asset asset = new Asset(user , getCatipal() ,getType() , new Date() );
                    session.save(asset);
                }
            }

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

    @Test
    public void testRan() {
        for(int i=0;i<20;i++) {
            System.out.println(ran.nextInt(2));
        }
    }

    private String getType(){
        String[] type = new String[]{"支出","收入"};
        return type[ran.nextInt(type.length)];
    }

    private Long getCatipal(){
        String[] math = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        String catipal =  math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
        return Long.parseLong(catipal);
    }

    private String getPassword(){
        return getUserName();
    }

    private String getUserName(){
        String[] word = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l",
                "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] math = new String[]{"0","1","2","3","4","5","6","7","8","9"};

        if (ran.nextInt(10)<5){
            String w1 = word[ran.nextInt(word.length)] + word[ran.nextInt(word.length)] + word[ran.nextInt(word.length)];
            String m1 = math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
            return w1 + m1;
        }else {
            return word[ran.nextInt(word.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                    math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                    math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
        }
    }

    private String getName() {
        String[] name1 = new String[]{"孔","张","叶","李","叶入","孔令",
                "张立","陈","刘","牛","夏侯","令","令狐","赵","母","穆","倪",
                "张毅","称","程","王","王志","刘金","冬","吴","马","沈"};

        String[] name2 = new String[]{"凡","课","颖","页","源","都",
                "浩","皓","西","东","北","南","冲","昊","力","量","妮",
                "敏","捷","杰","坚","名","生","华","鸣","蓝","春","虎","刚","诚"};

        String[] name3 = new String[]{"吞","明","敦","刀","备","伟",
                "唯","楚","勇","诠","佺","河","正","震","点","贝","侠",
                "伟","大","凡","琴","青","林","星","集","财"};

        boolean two = ran.nextInt(50)>=45?false:true;
        if(two) {
            String n1 = name1[ran.nextInt(name1.length)];
            String n2;
            int n = ran.nextInt(10);
            if(n>5) {
                n2 = name2[ran.nextInt(name2.length)];
            } else {
                n2 = name3[ran.nextInt(name3.length)];
            }
            return n1+n2;
        } else {
            String n1 = name1[ran.nextInt(name1.length)];
            String n2 = name2[ran.nextInt(name2.length)];
            String n3 = name3[ran.nextInt(name3.length)];
            return n1+n2+n3;
        }
    }
}
