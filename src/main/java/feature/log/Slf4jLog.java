package feature.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在一个logger对象中,输出到不同的文件
 * https://stackoverflow.com/questions/5653062/how-can-i-configure-logback-to-log-different-levels-for-a-logger-to-different-de#answer-13233538
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/8
 */
public class Slf4jLog {


    @Test
    public void log() {

        //xml编辑配置:
        /*
            本案例使用logback作为log实现,默认读取classpath下的logback.xml
            logback.xml标签主要分为3种:
               appender
               logger
               root

            appender 负责制定输出的格式(文件,控制台),使用filter控制输出的内容
            logger   是代日志执行方案的门面,logger包含一个或者多个appender
            root     代表的是默认使用的日志方式,包含一个或者多个appender

            详细请见 http://logback.qos.ch/manual/configuration.html
         */


        // java代码流程:
        //1. get logger
        Logger logger = LoggerFactory.getLogger("goodLogger");

        //log trace debug info warn error
        logger.info("info");
        logger.error("error");
        logger.debug("debug");

        // xml 配置实践
        /*
        使用同一个logger,不同的level的日志放在不同的文件种
         */

        //底层原理
        /*
        Slf4j module 提供api,加载 concrete logger
        加载方式:
            https://www.oracle.com/technetwork/java/jndi/index.html
        具体实现:
            ...
         */


    }

}
