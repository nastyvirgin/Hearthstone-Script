package club.xiaojiawei.initializer;

import club.xiaojiawei.data.SpringData;
import club.xiaojiawei.utils.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Properties;

import static club.xiaojiawei.enums.ConfigurationEnum.AUTO_OPEN_WEB;

/**
 * 打开Web页面
 * @author 肖嘉威
 * @date 2023/9/10 15:33
 */
@Component
@Slf4j
public class WebInitializer extends AbstractInitializer{
    @Resource
    private SpringData springData;
    @Resource
    private Properties scriptConfiguration;
    @Override
    public void exec(){
        if (Objects.equals(scriptConfiguration.getProperty(AUTO_OPEN_WEB.getKey()), "true")){
            SystemUtil.openUrlByBrowser("http://127.0.0.1:" + springData.getServerPort());
        }
        if (nextInitializer != null){
            nextInitializer.init();
        }
    }
}
