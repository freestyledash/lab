package feature.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static feature.tool.Main.fixOne;
import static feature.tool.Main.gOsTokenV2;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/10/14
 */
public class FixAll {

    public static void main(String[] args) {
        fixAll(0);
    }

    /**
     * 修复
     */
    static void fixAll(int begin) {
        int i = 0;
        File f = new File("/Users/zhangyanqi/Desktop/pship/result/more");
        File[] files = f.listFiles();
        for (File file : files) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                while (line != null) {
                    ++i;
                    if (i < begin) {
                        System.out.println("跳过" + i + "条");
                        line = bufferedReader.readLine();
                        continue;
                    }
                    fixOne(line, file.getName());
                    System.out.println("修复完成第 " + i + "条");
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //todo 多种Exception
                System.out.println("error：文件导读取失败 " + f.getName());
            } finally {
                System.out.println("处理" + i + "条");
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
