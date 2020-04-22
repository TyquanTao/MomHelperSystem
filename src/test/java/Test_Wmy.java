import com.aliyuncs.exceptions.ClientException;
import com.cn.dao.AdminMapper;
import com.cn.dao.PostMapper;
import com.cn.dao.SearchMapper;
import com.cn.dao.UserMapper;
import com.cn.pojo.*;
import com.cn.service.SearchService;
import com.cn.utils.MD5Util;
import com.cn.utils.RandomNumberUtil;
import com.cn.utils.SendCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/28 10:02
 * Description:
 */
@WebAppConfiguration
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-dao.xml",
        "classpath:spring-service.xml"
})
public class Test_Wmy {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SearchMapper searchMapper;




    @Autowired
    private SearchService searchService;
    @Test
    public void find(){
        Admin admin = adminMapper.findByAdminName("admin");
        System.out.println(admin);
    }

    @Test
    public void md5(){
        String s = MD5Util.MD55("1234567");
        System.out.println(s);
    }

    @Test
    public void code(){
        System.out.println(RandomNumberUtil.getCode());
    }

//    @Test
//    public void sendMsg(){
//        try {
//            SendCodeUtil.sendSms("",RandomNumberUtil.getCode());
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void likeTitle(){
        List<Post> posts = postMapper.findByPostTitle("ws");
        for (Post post : posts) {
            System.out.println(post);

        }
    }

    @Test
    public void likeUser(){
        List<User> users = userMapper.findByUserName("三");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    @Test
    public  void addSearch(){
        boolean search = searchService.addSearch("怀孕1", 1002);

        System.out.println(search);
    }

    @Test
    public void  findSearch(){
        Integer s = searchMapper.deleteAllHistory(1002);
        System.out.println(s);
    }

    @Test
    public  void test03(){
        UserState userstate = userMapper.findUserStateStateId(1001);
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        String d = new SimpleDateFormat("d").format(System.currentTimeMillis() - userstate.getStateStarttime().getTime());
        int a = Integer.parseInt(d);
        System.out.println(d);

    }
    @Test
    public void  test04(){
        Integer integer = adminMapper.updateAdminMessage(new Admin(3, "2333", "123456", "656"));
        System.out.println(integer);
    }

}
