package main.java.feature.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.HashMap;

public class Generator {

    public static void main(String[] args) {

        //表名字
        String tableName = "test_table";

        HashMap<OutputFile, String> pathInfo = new HashMap<>();

        pathInfo.put(OutputFile.mapper, "src/main/java/feature/mybatisplus/biz/mapper");
        pathInfo.put(OutputFile.xml, "src/main/java/feature/mybatisplus/biz/xml");
        pathInfo.put(OutputFile.entity, "src/main/java/feature/mybatisplus/biz/po");
        pathInfo.put(OutputFile.service, "src/main/java/feature/mybatisplus/biz/service");
        pathInfo.put(OutputFile.serviceImpl, "src/main/java/feature/mybatisplus/biz/serviceimpl");

        try {

            FastAutoGenerator.create(
                            "jdbc:mysql://127.0.0.1:3306/test_repo",
                            "root",
                            "123456"
                    )

                    .globalConfig(builder -> {
                        builder.author("张言琦") // 设置作者
                                .outputDir("/Users/zhangyanqi/projects/lab"); // 指定输出目录

                    })

                    .packageConfig(builder -> {
                        // 设置父包名
                        builder.parent("feature.mybatisplus.biz")
                                .serviceImpl("feature.mybatisplus.biz.serviceimpl")
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