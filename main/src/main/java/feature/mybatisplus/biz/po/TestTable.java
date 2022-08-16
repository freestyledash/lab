package main.java.feature.mybatisplus.biz.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 测试table
 * </p>
 *
 * @author 张言琦
 * @since 2022-08-16
 */
@Getter
@Setter
@TableName("test_table")
public class TestTable implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("column_2")
    private String column2;

    @TableField("column_3")
    private BigDecimal column3;


}
