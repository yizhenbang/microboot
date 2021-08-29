package com.yzb.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Random;

/**
 * ClassName: YZBBanner
 * Description:
 * date: 2021/8/21 16:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class YZBBanner implements Banner {

    private static final String[] YZB_BANNER = {
            " __   __   ____    ___   ",
            " \\ \\ / /  |_  / | _ )  ",
            "  \\ V /    / /   | _ \\  ",
            "  _|_|_   /___|   |___/  ",
            "_| \"\"\" |_|\"\"\"\"\"|_|\"\"\"\"\"| ",
            "\"`-0-0-'\"`-0-0-'\"`-0-0-' "
    };

    private static final String[] XIAOYI_BANNER = {
            " __  __    ___     ___     ___   __   __   ___   ",
            " \\ \\/ /   |_ _|   /   \\   / _ \\  \\ \\ / /  |_ _|  ",
            "  >  <     | |    | - |  | (_) |  \\ V /    | |   ",
            " /_/\\_\\   |___|   |_|_|   \\___/   _|_|_   |___|  ",
            "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\" |_|\"\"\"\"\"| "
    };

    private static final String MY_BANNER = "你好，我是小易";
    private static final Random RANDOM = new Random();
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        int i = RANDOM.nextInt(10);//输出0-9
        out.println();//换行
        if (i==0){
            for (String s : YZB_BANNER) {
                out.println(s);
            }
        }else if(i%2==1){
            for (String s : XIAOYI_BANNER) {
                out.println(s);
            }
        }else{
            out.println(MY_BANNER);
        }
        out.println();//换行
        out.flush();//强制清空缓存
    }
}
