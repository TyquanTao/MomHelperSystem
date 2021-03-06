import com.cn.dao.CommentMapper;
import com.cn.dao.PostMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-dao.xml",
        "classpath:spring-service.xml"
})
@WebAppConfiguration
public class YxlTest {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentService commentService;


    @Test
    public void test01(){
        Boolean aa = postMapper.deleteByPostId(1);
        if (aa) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void test02(){
        Post post = new Post();
        post.setPostId(1);
        post.setPostTitle("我是你爹");
        post.setPostContent("nmsl");
        post.setCircleId(2);
        Integer ints = postMapper.updatePost(post);
        if (ints>0) {
            System.out.println("删除成功");
        }
        System.out.println("删除失败");
    }

    @Test
    public void test03(){
        Post post = postMapper.findByPostId(1);
        if (post==null) {
            System.out.println("查询失败");
        }
        System.out.println("查询成功");
    }

    @Test
    public void test04(){
        Integer integer = commentMapper.countLike(1);
        System.out.println(integer);
    }

    @Test
    public void test05(){
        JsonResult test = commentService.findAllComment(1,1001);
        System.out.println("test");
    }
}
