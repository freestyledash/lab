package feature.excel;

import java.io.File;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/09/29
 */
public class Test {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/zhangyanqi/Downloads/error-center-table-1601376716298.xlsx");
        Workbook wb = new XSSFWorkbook(file);

        Sheet sheet = wb.getSheetAt(0);

        for (int rowNum = sheet.getFirstRowNum() + 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            LogisticErrorRecordDTO record = new LogisticErrorRecordDTO();
            //读取excel
            //垃圾代码 todo
            for (int cellIndex = 0; cellIndex < 17; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                String stringCellValue = null;
                try {
                    stringCellValue = cell.getStringCellValue();
                } catch (Exception e) {
                    continue;
                }
                switch (cellIndex) {
                    case 0: {
                        record.setOrderCode(stringCellValue);
                        break;
                    }
                    case 1: {
                        record.setHBaseRowKey(stringCellValue);
                        break;
                    }
                    case 2: {
                        record.setMailNo(stringCellValue);
                        break;
                    }
                    case 14: {
                        record.setCpSubmitRemark(stringCellValue);
                        break;
                    }
                    case 15: {
                        record.setCpAnticipateSolveTime(stringCellValue);
                        break;
                    }
                    case 16: {
                        record.setCpSubmitReason(stringCellValue);
                        break;
                    }
                    default:
                        break;
                }
            }
            System.out.println(record);
        }
    }
}

@Getter
@Setter
@ToString
class LogisticErrorRecordDTO {
    private String id;
    private String hBaseRowKey;
    private String bizType;
    private String eventId;
    private String orderCode;
    private String transactionId;
    private String mailNo;
    private String status;
    private String snapshot;
    private Date cpSubmitTime;
    private String cpStaffCnId;
    private Date gmtModified;
    private Date gmtCreate;
    private String isTest;
    private String isDeleted;
    private String feature;
    private Long version;
    private String rowKey;
    private String storeName;
    private String distributorName;
    private String distributorCompanyName;
    private String customsGateName;
    private String vehicleNo;
    private String licensePlate;
    private String logisState;
    private String accountName;
    private String cpSubmitReason;
    private String cpSubmitRemark;
    private String cpAnticipateSolveTime;
    private Integer rowNumber;
}