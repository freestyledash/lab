package feature.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class Generator {

    public static void main(String[] args) {

        String tablePrefix = "";

        //表名字
        String tableName = "user_questionnaire";

        Config config = new Config();
        config.setDbType(DbType.MYSQL);
        config.setDriver("com.mysql.jdbc.Driver");
        config.setDbUrl("jdbc:mysql://rm-uf612564zi3v9qvvs.mysql.rds.aliyuncs.com:3306/gezhi-dev_blood-lipid?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=GMT%2b8&useSSL=false");
        config.setUsername("gezhi_dev");
        config.setPassword("nE3cV7dA6a");
        config.setAuthor("张言琦");
        config.setParentName("com.yuehuijiankang.blood.lipid");
        config.setModuleName("blood-lipid-service");

        //本地代码地址
        config.setProjectPath("/Users/zhangyanqi/projects/blood-lipid-service");
        config.setApplicationName("blood-lipid-service");

        //是否覆盖生产文件，默认false
        config.setFileOverride(false);
        config.setGenerateFeign(false);
        config.setGenerateController(false);


        try {

            FastAutoGenerator.create("url", "username", "password")
                    .globalConfig(builder -> {
                        builder.author("baomidou") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                                .outputDir("D://"); // 指定输出目录
                    })

                    .packageConfig(builder -> {
                        builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                                .moduleName("system"); // 设置父包模块名
//                                .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/zhangyanqi/projects/blood-lipid-service")); // 设置mapperXml生成路径
                    })

                    .strategyConfig(builder -> {
                        builder.addInclude("t_simple") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    })


                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .execute();

        } catch (Exception e) {
            //ignore
        }

    }

}