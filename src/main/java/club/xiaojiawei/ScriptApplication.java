package club.xiaojiawei;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author 肖嘉威
 * @date 2022/11/24 13:34
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@Slf4j
public class ScriptApplication{

    public static void main(String[] args) {
//        todo
//        String property = System.getProperty("java.version");
        Application.launch(UIApplication.class, args);
    }

}
