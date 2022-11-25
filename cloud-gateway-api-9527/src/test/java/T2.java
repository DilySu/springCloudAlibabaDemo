import java.time.ZonedDateTime;

/**
 * Date: 2022-11-16 星期三
 * Time: 14:01
 * Author: Dily_Su
 * Remark: 获取时区
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        // 2022-11-16T14:02:13.515870500+08:00[Asia/Shanghai]
    }
}
