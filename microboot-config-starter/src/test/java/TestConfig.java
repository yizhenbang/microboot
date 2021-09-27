import com.yzb.starter.AutoConfigStarter;
import com.yzb.starter.vo.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * ClassName: TestConfig
 * Description:
 * date: 2021/9/27 22:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = AutoConfigStarter.class)
public class TestConfig {
    @Autowired
    private Person person;

    @Autowired
    private List<String> pigs;

    @Test
    public void get(){
        System.out.println(person);
        System.out.println(pigs);
    }
}
