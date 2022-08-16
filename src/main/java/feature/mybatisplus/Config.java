package feature.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Data;

/**
 * mybatis-plus生成配置类
 * @version 1.0
 **/
@Data
public class Config {
    /**
     * 应用名
     */
    private String applicationName;
    /**
     * contextPath
     */
    private String contextPath;
    /**
     * 项目根目录
     */
    private String projectPath;
    /**
     * 作者
     */
    private String author;
    /**
     * 是否覆盖生成，mapper.xml和domain文件覆盖生成不受此参数影响
     */
    private boolean fileOverride = false;
    /**
     * 父包名，如：com.bc.sca.permission
     */
    private String parentName;
    /**
     * 父模块名，如：permission
     */
    private String moduleName;
    /**
     * 数据库类型
     */
    private DbType dbType;
    /**
     * 连接地址
     */
    private String dbUrl;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 驱动
     */
    private String driver;

    /**
     * Boolean类型字段是否移除is前缀（默认 false） 比如 : 数据库字段名称 : 'is_xxx',在映射实体的时候则会去掉is,在实体类中映射最终结果为 xxx
     */
    private boolean entityBooleanColumnRemoveIsPrefix = true;

    /**
     * 乐观锁属性名称
     */
    private String versionFieldName;

    /**
     * 是否生成feign
     */
    private boolean generateFeign = true;

    /**
     * 是否生成controller
     */
    private boolean generateController = true;
}
