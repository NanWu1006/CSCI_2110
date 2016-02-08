import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by KanzakiMirai on 2/2/16.
 */
public class main {
    public static void main(String[] args) {
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
        String str = "/getUserInfo.action";
        String sessionKey = "90622c4a-49e6-4162-aab7-6e619e514a58";
        String sessionSecret = "C8E44D3161715069DE51802E25A6841E";
        String format = "Tue, 2 Feb 2016 05:32:47 GMT";
        getSignatrue(str /*ACTION_NAME*/,
                sessionKey /* 90622c4a-49e6-4162-aab7-6e619e514a58 */,
                sessionSecret /* C8E44D3161715069DE51802E25A6841E */,
                "GET"/* GET / POST */,
                format /* Tue, 2 Feb 2016 05:32:47 GMT */);
    }

    public static void getSignatrue(String str /* ACTION_NAME */,
                                      String str2 /* 90622c4a-49e6-4162-aab7-6e619e514a58 */,
                                      String str3 /* C8E44D3161715069DE51802E25A6841E */,
                                      String str4 /* GET / POST */,
                                      String str5 /* Tue, 2 Feb 2016 05:32:47 GMT */) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccessToken" /* "AccessToken" */ + "=");
        stringBuilder.append(str2);
        stringBuilder.append("&Operate=");
        stringBuilder.append(str4);
        if (str.startsWith("/" /* "/" */)) {
            stringBuilder.append("&RequestURI=");
        } else {
            stringBuilder.append("&RequestURI=/");
        }
        stringBuilder.append(str);
        stringBuilder.append("&Date=");
        stringBuilder.append(str5);
        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());
//        DLog.v("httpSignature", stringBuilder.toString());
//        return CodecUtil.hmacsha1(stringBuilder.toString(), str3);
        // AccessToken=04f4ea8898a74dec9a490b8739b73bdf&Operate=GET&RequestURI=/keepUserSession.action&Date=Tue, 02 Feb 2016 05:18:09 GMT
    }
}
