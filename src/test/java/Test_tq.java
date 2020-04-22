import com.cn.dao.QuestionMapper;
import com.cn.pojo.Question;
import com.cn.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-dao.xml"
})
public class Test_tq {
    @Autowired
    private QuestionMapper questionMapper;

    private QuestionService questionService;

    @Test
    public void test01() {
        List<Question> q = questionMapper.findQuestionLikeTitle("宝宝");
        if (q.size() > 0) {
            for (Question question : q) {
                System.out.println(question);
            }
        }
    }
//    @Test
//    public void test02() throws IOException {
////        questionMapper.delQuestionFabulous(new QuestionFabulous(1008,19));
//        String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
//                + "然后法.轮.功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
//                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三.级.片 深人静的晚上，关上电话静静的发呆着。";
//        Set<String> sensitiveWord = SensitiveWordsUtil.getSensitiveWord(string, 1);
//        String s = SensitiveWordsUtil.sensitiveHelper(string, sensitiveWord);
//        System.out.println(s);
//    }
    @Test
    public void test03(){
        int i =12;
        System.out.println(i+=i-=i*=i);
    }
    @Test
    public void test04(){
        class A{
            public int i = 3;
        }
        Object o = (Object) new A();
        A a = (A) o;
        System.out.println("i="+a.i);
    }
    @Test
    public void test05(){
        Map<Object, Object> map = new HashMap<>();
        map.put("a","a");
        map.put("test",Integer.valueOf("123"));

        System.out.println(map);

    }
}
