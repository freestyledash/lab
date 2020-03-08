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
public class Slf4jAndLogback {

    @Test
    public void log() {

        //xml编辑配置:
        /*
            本案例使用logback作为slf4j实现,默认读取classpath下的logback.xml

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

        //log,trace debug info warn error
        int i = 10000;
        while (i > 0) {
            logger.trace("trace");
            logger.debug("debug");
            logger.debug("debug");
            logger.info("info");
            logger.info("info");
            logger.warn("warn");
            logger.warn("warn");
            logger.error("error");
            logger.error("error");
            i--;
        }

        //xml配置实践
        /*
        使用同一个logger对象,不同的level的日志放在不同的文件中,文件滚动记录
         */

        //底层原理
        /*
        Slf4j module 提供api,加载 concrete logger
        加载原理背后的思考方式: JDNI
            https://www.oracle.com/technetwork/java/jndi/index.html
        具体实现:
            ...
         */


    }

}
