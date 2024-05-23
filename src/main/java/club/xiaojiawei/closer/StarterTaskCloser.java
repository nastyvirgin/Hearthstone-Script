package club.xiaojiawei.closer;

/**
 * @author 肖嘉威 xjw580@qq.com
 * @date 2024/5/23 9:09
 */
public interface StarterTaskCloser extends Closable{

    void closeStarterTask();

    default void close(){
        closeStarterTask();
    }

}
