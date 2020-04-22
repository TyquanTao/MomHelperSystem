import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author 罗世杰
 * @date 2019/12/2 10:46
 */
@WebAppConfiguration
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-dao.xml",
        "classpath:spring-service.xml"
})
public class Lsjtext {
    @Test
    public void text1(){
        String comtent="阿斯蒂芬黄色啊实打实暴力大草你麻痹方";
        String str="黄色|暴力|草你麻痹";

        String[] strArr = str.split("\\|");
        for (int i = 0; i < strArr.length; ++i){
            String newString="";
            if(comtent.contains(strArr[i])){
                for(int j = 0; j < strArr[i].length(); ++j){
                    newString+="*";
                }
                comtent=comtent.replace(strArr[i], newString);
            }
        }
        System.out.println(comtent);
    }
}
