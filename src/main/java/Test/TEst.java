package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/11/11
 * @Description todo
 * important_dependency todo
 */ 
public class TEst {

    private static final String PROPERTIES_FILE = "./123";

    private static final String ENCODING_WRITE = "GBK";

    private static final String ENCODING_READ = "UTF-8";

    public static void main(String[] args) throws Exception {
        //saveFile();
        read();
    }

    static void saveFile() throws Exception {
        OutputStreamWriter writer =
            new OutputStreamWriter(
                new FileOutputStream(PROPERTIES_FILE), ENCODING_WRITE);
        writer.write("我f是f张df言sdaf琦");
        writer.flush();
        writer.close();
    }

    static void read() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(new FileInputStream(PROPERTIES_FILE), ENCODING_READ));
        String s = bufferedReader.readLine();
        System.out.println(s);

    }

}
