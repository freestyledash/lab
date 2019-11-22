package feature.tool;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/10/11
 */
public class Main {

    static String shellLocation = "/Users/zhangyanqi/Desktop/pship/run.sh";

    static String readFileBasePath = "/Users/zhangyanqi/Desktop/pship/result/";

    static String readMoreFileBasePath = "/Users/zhangyanqi/Desktop/pship/result/more";

    static String readMoreMoreFileBasePath = "/Users/zhangyanqi/Desktop/pship/result/moremore";

    static String gOsTokenV2 = "0fac6130-dfa7-4060-8cb5-1bf15b980fc1";

    static String url = "http://pre-cngcost.cainiao.com/gateway/tool/batchDeclareByLbxCode";

    public static void main(String[] args) throws Exception {
        //下 载文件
        //download();  ok

        //修复142131条 ok   142131 51596 201629
        //fix(0);

        //处理53153条  ok
        //fixMore(51596);

        //一共201629条 ok
        fixMoreMore(201499);

        //修复一条
        //fixOne("LBX0329523717281317"); ok

        //getDup(); ok

        //checkLostFile(); ok

        //statistic();

        //5w
        //statisticMore();

        //20w
        //statisticMoreMore();

        System.out.println("结束了");
    }

    //154条，待修复的
    static List<String> targets = Arrays.asList(
        //"3934273242=STORE_11824371",
        //"4229074189=HGH506",
        //"2194810384=CGO502",
        //"2200695737748=STORE_12018381",
        //"2201502467993=FOC502",
        //"2206612155349=STORE_1518957",
        //"2206351802637=CGO504"
        //"2206415268616=CAN604",
        //"2201468552663=HGH506",
        //"2206487110776=CGO502",
        //"2316003304=STORE_1372728",
        //"3249354083=STORE_1372728",
        //"3899096041=STORE_12320005",
        //"2878528631=STORE_12320005",
        //"4157797318=STORE_12320005",
        //"4008552303=STORE_1372728",
        //"2549841410=NGB503",
        //"2549841410=NGB520",
        //"3384324308=STORE_11824371",
        //"2167772801=STORE_11824371",
        //"2822264336=STORE_11824371",
        //"2030008797=FOC502",
        //"2257482711=FOC502",
        //"2298016439=FOC502",
        //"2200765522929=STORE_1518810",
        //"2169933405=FOC502",
        //"2085938070=FOC502",
        //"2064657420=FOC502",
        //"1993129562=FOC502",
        //"2731931245=STORE_1709661",
        //"4173617368=HGH510",
        //"3979166562=ISCS-220079",
        //"3010779630=ISCS-220079",
        //"2906837490=ISCS-220079",
        //"3315297347=HGH510",
        //"2170968104=HGH510",
        //"4263377845=ISCS-220079",
        //"3946991043=HGH510",
        //"2549841410=HGH506",
        //"2979726454=HGH510",
        //"2932255676=STORE_673974",
        //"2821996749=HGH510",
        //"2201470547985=STORE_1709661",
        //"2482635690=STORE_1709661",
        //"4163194675=HGH510",
        //"2200599383330=ISCS-220079",
        //"1935219690=ISCS-220079",
        //"4121153063=STORE_12018381",
        //"2206372202026=HGH506",
        //"2509849149=STORE_673974",
        //"2843259230=STORE_673974",
        //"2200643497500=CAN603",
        //"2202009087095=STORE_673974",
        //"3357241566=STORE_12320005",
        //"1792368114=STORE_12320005",
        //"3010115176=STORE_12320005",
        //"4002894107=STORE_12320005",
        //"2159616682=STORE_673974",
        //"3002065131=STORE_12320005",
        //"2205561022593=STORE_12018381",
        //"3931753567=STORE_12320005",
        //"2962411000=STORE_12320005",
        //"4228193079=STORE_12320005",
        //"2962411000=STORE8811077",
        //"3838144047=STORE_1372728",
        //"2648899388=STORE_12320005",
        //"2798015967=STORE_12320005",
        //"3009696847=STORE_12320005",
        //"2695876552=STORE_12320005",
        //"2204247368952=CAN603",
        //"4001765147=STORE_1518957",
        //"2608180479=STORE_1518957",
        //"4254194640=STORE_1709661",
        //"4086047356=CAN603",
        //"2635083319=STORE_11180270",
        //"2477818746=STORE_1372728",
        //"4155337799=CGO502",
        //"2794371653=STORE_12093326",
        //"4091091457=CGO502",
        //"2984563895=STORE_12018381",
        //"4036468598=STORE_12018381",
        //"4052630752=STORE_12018381",
        //"2156857538=STORE_12320005",
        //"4113098545=STORE_12018381",
        //"1993129562=CGO502",
        //"1996234796=CGO502",
        //"2041058580=CGO502",
        //"1835946814=CGO502",
        //"2201443975634=STORE_11535850",
        //"2201649215970=STORE_673974",
        //"3394222469=STORE_12093326",
        //"4162416468=STORE_12093326",
        //"4216658333=CGO502",
        //"2781798977=FOC502",
        //"2032939909=ISCS-220079",
        //"2956756848=STORE_11824371",
        //"2169933405=CGO502",
        //"3364684496=CGO502",
        //"2627565993=FOC502",
        //"2809410174=CGO502",
        //"3319445762=STORE_1518957",
        //"4118055481=STORE_11180270",
        //"2202800855693=STORE_1518957",
        //"2200758980149=STORE_1518810",
        //"2691645197=CGO502",
        //"3925705463=HGH506",
        //"2201498649159=NGB503",
        //"4074877360=STORE_12320005",
        //"2200726153564=STORE_673974",
        //"2200977339809=STORE_12018386",
        //"2549599360=STORE_1518957",
        //"2201264181221=HGH506",
        //"2257482711=CGO502",
        //"4113667828=STORE_12018381",
        //"3962668671=STORE_12018381",
        //"2927932724=CAN603",
        //"2979211515=STORE_12093326",
        //"2640238597=STORE_673974",
        //"3705123341=STORE_12320005",
        //"3538226517=STORE_12320005",
        //"2203090716636=STORE_1518957",
        //"3497235133=STORE_12093326",
        //"2204432005457=STORE_1518957",
        //"4041884127=STORE_1258299",
        //"2378730927=STORE_12320005",
        //"3342051534=STORE_12320005",
        //"2820479942=STORE_12320005",
        //"1991094637=STORE_1518810",
        //"2137150453=STORE_1709661",
        //"2458076250=STORE_1372728",
        //"2605364174=STORE_1372728",
        //"2637970571=STORE_1372728",
        //"2532208428=SZX601",
        //"2166290049=FOC502",
        //"2201548686682=ISCS-220079",
        //"2205860170116=STORE_1518957",
        //"2200725341135=STORE_1518957",
        //"2564346277=FOC502",
        //"2750873244=STORE_1518810",
        //"2203034391218=STORE_1518957",
        //"2200788503980=STORE_1518957",
        //"2549841410=SZX601",
        //"2204175164246=STORE_1518957",
        //"4050264010=STORE_12018381",
        //"2206368645522=STORE8811077",
        //"2929053804=STORE_673974",
        //"2861689487=STORE_1709661",
        //"2549841410=CGO503",
        //"2202387885315=STORE_12320005",
        //"3838303135=HGH506",
        //"3075140505=NGB503",
        //"2201548783571=SZX601",
        //"2206472499851=STORE_673974",
        //"2809410174=FOC502"
    );

    /**
     * 超过一万行的
     */
    static List<String> except = Arrays.asList(
        "2549841410=SZX601",
        "2929053804=STORE_673974",
        "2316003304=STORE_1372728",
        "2549841410=NGB503",
        "1835946814=CGO502",
        "2691645197=CGO502",
        "2549841410=CGO503"
    );

    /**
     * 下载LBX
     *
     * @throws IOException
     * @throws InterruptedException
     */
    static void download() throws IOException, InterruptedException {
        int i = 0;
        for (String target : targets) {
            String[] split = target.split("=");
            String res = split[1];
            String seller = split[0];
            String cmd = "sh  " + shellLocation + " " + res + " " + seller;
            System.out.println("开始" + cmd);
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            line = "";
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(" 完成 " + cmd + " count " + ++i);
        }
    }

    /**
     * 修复
     */
    static void fix(int begin) {
        int i = 0;
        //readFile
        for (String target : targets) {
            if (except.contains(target)) {
                System.out.println("暂时跳过文件：" + target);
                continue;
            }
            String[] split = target.split("=");
            String res = split[1];
            String seller = split[0];
            String fileName = readFileBasePath + res + "-" + seller + ".txt";
            File file = new File(fileName);
            boolean exists = file.exists();
            if (!exists) {
                System.out.println("error：导出的文件不存在 " + fileName);
                continue;
            }

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
                    fixOne(line, fileName);
                    System.out.println("修复完成第 " + i + "条");
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //todo 多种Exception
                System.out.println("error：文件导读取失败 " + fileName);
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

    /**
     * fix One
     */
    static void fixMore(int begin) {
        int i = 0;
        //readFile
        File file = new File(readMoreFileBasePath);
        for (File target : file.listFiles()) {
            if (target.isDirectory()) {
                continue;
            }
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(target));
                String line = bufferedReader.readLine();
                while (line != null) {
                    ++i;
                    if (i < begin) {
                        System.out.println("跳过" + i + "条");
                        line = bufferedReader.readLine();
                        continue;
                    }
                    fixOne(line, target.getName());
                    System.out.println("修复完成第 " + i + "条");
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //todo 多种Exception
                System.out.println("error：文件导读取失败 " + target.getName());
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

    /**
     * fix One
     */
    static void fixMoreMore(int begin) {
        int i = 0;
        //readFile
        File file = new File(readMoreMoreFileBasePath);
        for (File target : file.listFiles()) {
            if (target.isDirectory()) {
                continue;
            }
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(target));
                String line = bufferedReader.readLine();
                while (line != null) {
                    ++i;
                    if (i < begin) {
                        System.out.println("跳过" + i + "条");
                        line = bufferedReader.readLine();
                        continue;
                    }
                    fixOne(line, target.getName());
                    System.out.println("修复完成第 " + i + "条");
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //todo 多种Exception
                System.out.println("error：文件导读取失败 " + target.getName());
            } finally {
                System.out.println("处理" + i + "条");
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("一共" + i + "条");
    }

    /**
     * fix one
     *
     * @param fulfillOrder
     */
    public static void fixOne(String fulfillOrder, String fileName) {
        System.out.println("开始修复 文件： " + fileName + "订单号：" + fulfillOrder);
        try {
            URL url = new URL(Main.url);
            String jsonInputString = "[\"" + fulfillOrder + "\"]";
            System.out.println("jsonInputString: " + jsonInputString);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("gOsTokenV2", gOsTokenV2);
            con.setConnectTimeout(9000);
            con.setReadTimeout(9000);
            con.setUseCaches(false);
            con.setDoInput(true);

            //send request
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            //read response
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                String x = response.toString();
                System.out.println(x);
                if (!x.equals(
                    "{\"data\":null,\"success\":true,\"code\":200,\"errorMessage\":null,\"errorCode\":null}")) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("修复失败 " + fulfillOrder);
        }
    }

    /**
     * 检查targets重复的项
     */
    static void getDup() {
        Set<String> targetSet = new HashSet<>();
        for (String target : targets) {
            if (targetSet.contains(target)) {
                System.out.println("重复：" + target);
            } else {
                targetSet.add(target);
            }
        }
        System.out.println(targets.size());
    }

    //检查文件有没有下载全
    static void checkLostFile() {
        for (String target : targets) {
            //if (except.contains(target)) {
            //    System.out.println("跳过：" + target);
            //    continue;
            //}
            String[] split = target.split("=");
            String res = split[1];
            String seller = split[0];
            String fileName = readFileBasePath + res + "-" + seller + ".txt";
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println(fileName);
            }
        }
    }

    public static void statistic() {
        int i = 0;
        File file = new File(readFileBasePath);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(f));
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        i++;
                        line = bufferedReader.readLine();
                    }
                } catch (Exception e) {
                    //todo 多种Exception
                    System.out.println(e);
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("一共" + i + "行");
    }

    public static void statisticMore() {
        int i = 0;
        File file = new File("/Users/zhangyanqi/Desktop/pship/result/more");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(f));
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        i++;
                        line = bufferedReader.readLine();
                    }
                } catch (Exception e) {
                    //todo 多种Exception
                    System.out.println(e);
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("一共" + i + "行");
    }

    static void statisticMoreMore() {
        int i = 0;
        File file = new File(readMoreMoreFileBasePath);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(f));
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        i++;
                        line = bufferedReader.readLine();
                    }
                } catch (Exception e) {
                    //todo 多种Exception
                    System.out.println(e);
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("一共" + i + "行");
    }
}
