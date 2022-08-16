package feature.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.HashMap;

public class Generator {

    public static void main(String[] args) {

        String tablePrefix = "";

        //表名字
        String tableName = "test_table";

        Config config = new Config();

        config.setDbType(DbType.MYSQL);
        config.setDriver("com.mysql.jdbc.Driver");
        config.setDbUrl("jdbc:mysql://127.0.0.1:3306/test_repo");
        config.setUsername("root");
        config.setPassword("123456");
        config.setAuthor("张言琦");
        config.setProjectPath("/Users/zhangyanqi/projects/lab");
        config.setApplicationName("lab");
        config.setModuleName("lab");
        config.setParentName("feature.mybatisplus.biz");

        //是否覆盖生产文件，默认false
        config.setFileOverride(false);

        HashMap<OutputFile, String> pathInfo = new HashMap<>();

        pathInfo.put(OutputFile.mapper, "src/main/java/feature/mybatisplus/biz/mapper");
        pathInfo.put(OutputFile.xml, "src/main/java/feature/mybatisplus/biz/xml");
        pathInfo.put(OutputFile.entity, "src/main/java/feature/mybatisplus/biz/po");
        pathInfo.put(OutputFile.service, "src/main/java/feature/mybatisplus/biz/service");
        pathInfo.put(OutputFile.serviceImpl, "src/main/java/feature/mybatisplus/biz/serviceimpl");

        try {


            FastAutoGenerator.create(
                            config.getDbUrl(),
                            config.getUsername(),
                            config.getPassword()
                    )

                    .globalConfig(builder -> {
                        builder.author(config.getAuthor()) // 设置作者
                                .outputDir(config.getProjectPath()); // 指定输出目录

                    })

                    .packageConfig(builder -> {
                        builder.parent(config.getParentName()) // 设置父包名
                                .pathInfo(pathInfo);
                    })

                    .strategyConfig(builder -> {
                        // 设置需要生成的表名
                        builder.entityBuilder().enableLombok().enableTableFieldAnnotation().fileOverride();
                        builder.mapperBuilder().enableMapperAnnotation();
                        builder.addInclude(tableName);
                    })

                    .templateEngine(new VelocityTemplateEngine())
                    .execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            //ignore
            throw new RuntimeException(e);
        }

    }

}