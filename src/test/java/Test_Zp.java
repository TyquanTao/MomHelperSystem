import com.cn.dao.UserMapper;
import com.cn.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
@SuppressWarnings("all")
public class Test_Zp {
    @Autowired
    private UserMapper zp_userMapper;
   /* @Test
   public void test01(){
        User login = zp_userMapper.login(135,"111");
        System.out.println(login);
    }*/
    @Test
    public void test02(){
        Integer integer = zp_userMapper.updateState(1001, 2);
        System.out.println(integer);
    }


    @Test
    public void test03(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User("aaaaaaa", "3333", timestamp);
        user.setUserBirthday(timestamp);
        Integer adduser = zp_userMapper.adduser(user);
        System.out.println(adduser);

    }

}
