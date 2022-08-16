package main.java.feature.mybatisplus.biz.mapper;

import main.java.feature.mybatisplus.biz.po.TestTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 测试table Mapper 接口
 * </p>
 *
 * @author 张言琦
 * @since 2022-08-16
 */
@Mapper
public interface TestTableMapper extends BaseMapper<TestTable> {

}
