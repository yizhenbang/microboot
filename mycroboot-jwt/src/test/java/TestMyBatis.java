import com.fasterxml.jackson.core.JsonProcessingException;
import com.yzb.StarterJWT;
import com.yzb.service.impl.JWTServiceImpl;
import com.yzb.vo.JWTProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = StarterJWT.class)
public class TestMyBatis {

    private final String token = "eyJhdXRob3IiOiLljp_mnaXmmK_lsI_mmJMiLCJtb2R1bGUiOiJhcHBfeWl6aGVuYmFuZyIsImFsZyI6IkhTMjU2IiwiZGVzYyI6IueugOWNleeahOa1i-ivleS4gOS4i0pXVCJ9.eyJzaXRlIjoid3d3Lnl6Yi5jb20iLCJpc3MiOiJ4aWFveWkiLCJjb21wYW55Ijoi5oyv6YKm5L-h5oGvIiwianRpIjoiMTZkYzNiNzYtMWI0NS00Yjk1LWE2NGQtNDA0NTY0MzMzNThmIn0.rJn6TNtK3VH2G9jodSq1SRCnoXKue2YrpUTjo_Q5gpc";

    @Autowired
    private JWTProperties jwtProperties;

    @Autowired
    private JWTServiceImpl jwtService;

    @Test
    void testJWTProperties() {
        System.out.println(jwtProperties);
    }

    @Test
    void createToken() {
        Map<String, Object> subject = new HashMap<>();
        subject.put("我是附加sss信息", "附加信息");
        try {
            System.out.println(jwtService.createToken(UUID.randomUUID().toString(), subject));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseToken() {
        Jws<Claims> claimsJws = jwtService.parseToken(token);
        System.out.println(claimsJws.getBody());
        String subject = claimsJws.getBody().getSubject();
        System.out.println(subject);
        // LocalDateTime now = LocalDateTime.now();//当前时间
        // LocalDateTime failureTime = now.plusSeconds(10);//失效时间
        // System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        // System.out.println(failureTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }


}
