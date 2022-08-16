package main.java.feature.mybatisplus.biz.serviceimpl;

import main.java.feature.mybatisplus.biz.po.TestTable;
import main.java.feature.mybatisplus.biz.mapper.TestTableMapper;
import main.java.feature.mybatisplus.biz.service.ITestTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试table 服务实现类
 * </p>
 *
 * @author 张言琦
 * @since 2022-08-16
 */
@Service
public class TestTableServiceImpl extends ServiceImpl<TestTableMapper, TestTable> implements ITestTableService {

}
