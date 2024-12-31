
## Install and add module

#### Read

```http
https://bhamza.me/blogpost/2024/09/10/Emulating-Android-native-libraries-using-unidbg.html
```


### IQIYI with jadx
```
https://github.com/skylot/jadx
```

```Java
@Override // com.iqiyi.video.download.http.e
    protected String getUrl(Context context, Object... objArr) {
        String[] g12 = o60.c.g();
        String str = g12[0];
        String str2 = g12[1];
        if (!com.qiyi.baselib.utils.a.i(objArr, 1)) {
            com.qiyi.baselib.utils.g.j((String) objArr[0]);
        }
        String j12 = !com.qiyi.baselib.utils.a.i(objArr, 2) ? com.qiyi.baselib.utils.g.j((String) objArr[1]) : "";
        String j13 = com.qiyi.baselib.utils.a.i(objArr, 3) ? "" : com.qiyi.baselib.utils.g.j(objArr[2].toString());
        long longValue = !com.qiyi.baselib.utils.a.i(objArr, 4) ? ((Long) objArr[3]).longValue() : System.currentTimeMillis();
        String str3 = org.qiyi.context.mode.c.i() ? LocaleUtils.APP_LANGUAGE_TRADITIONAL_CHINESE : LocaleUtils.APP_LANGUAGE_SIMPLIFIED_CHINESE;
        String e12 = e();
        String c12 = c(j13);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/dash");
        sb2.append("?");
        sb2.append("tvid");
        sb2.append("=");
        sb2.append(j12);
        sb2.append("&");
        sb2.append("bid");
        sb2.append("=");
        sb2.append("0");
        sb2.append("&");
        sb2.append("vid");
        sb2.append("=");
        sb2.append(this.f35768a);
        sb2.append("&");
        sb2.append("abid");
        sb2.append("=");
        sb2.append(this.f35772e);
        sb2.append("&");
        sb2.append("src");
        sb2.append("=");
        sb2.append(e12);
        sb2.append("&");
        sb2.append("vt");
        sb2.append("=");
        sb2.append(g());
        sb2.append("&");
        sb2.append("rs");
        sb2.append("=");
        sb2.append("1");
        sb2.append("&");
        sb2.append("uid");
        sb2.append("=");
        sb2.append(str2);
        sb2.append("&");
        sb2.append("pck");
        sb2.append("=");
        sb2.append(str);
        sb2.append("&");
        sb2.append("ori");
        sb2.append("=");
        sb2.append("mba");
        sb2.append("&");
        sb2.append("ps");
        sb2.append("=");
        sb2.append("0");
        sb2.append("&");
        sb2.append("messageId");
        sb2.append("=");
        sb2.append(b());
        sb2.append("&");
        sb2.append("pt");
        sb2.append("=");
        sb2.append("0");
        sb2.append("&");
        sb2.append("lid");
        sb2.append("=");
        sb2.append(this.f35769b);
        sb2.append("&");
        sb2.append("cf");
        sb2.append("=");
        sb2.append(this.f35770c);
        sb2.append("&");
        sb2.append(UserDataStore.CITY);
        sb2.append("=");
        sb2.append(this.f35771d);
        sb2.append("&");
        sb2.append("locale");
        sb2.append("=");
        sb2.append(str3);
        sb2.append("&");
        sb2.append("applang");
        sb2.append("=");
        sb2.append(org.qiyi.context.mode.c.f());
        sb2.append("&");
        sb2.append("k_ver");
        sb2.append("=");
        sb2.append(QyContext.getClientVersion(context));
        sb2.append("&");
        sb2.append("k_tag");
        sb2.append("=");
        sb2.append("1");
        sb2.append("&");
        sb2.append(BioConstant.DeviceInfo.kKeyMemory);
        sb2.append("=");
        if (longValue == 0) {
            longValue = System.currentTimeMillis();
        }
        sb2.append(longValue);
        sb2.append("&");
        sb2.append("qd_v");
        sb2.append("=");
        sb2.append("s1");
        sb2.append("&");
        sb2.append("k_uid");
        sb2.append("=");
        sb2.append(o60.c.k());
        sb2.append("&");
        sb2.append("dcv");
        sb2.append("=");
        sb2.append("4");
        sb2.append("&");
        sb2.append("dfp");
        sb2.append("=");
        sb2.append(d(context));
        a(sb2);
        if (this.f35777j) {
            this.f35773f = v60.c.b(this.f35773f);
            v60.c.a(sb2, this.f35775h, this.f35776i, this.f35774g);
        }
        sb2.append("&");
        sb2.append("k_ft1");
        sb2.append("=");
        sb2.append(this.f35773f);
        if (!h()) {
            String f12 = v60.c.f();
            sb2.append("&");
            sb2.append("k_ft2");
            sb2.append("=");
            sb2.append(f12);
        } else if (!com.qiyi.baselib.utils.g.r(c12)) {
            sb2.append("&");
            sb2.append("k_ft2");
            sb2.append("=");
            sb2.append(c12);
        }
        sb2.append("&");
        sb2.append("k_ft5");
        sb2.append("=");
        sb2.append("2");
        sb2.append("&");
        sb2.append("k_ft4");
        sb2.append("=");
        sb2.append(org.qiyi.video.module.download.exbean.a.f69253b);
        sb2.append("&");
        sb2.append("k_ft7");
        sb2.append("=");
        sb2.append(org.qiyi.video.module.download.exbean.a.f69254c);
        sb2.append("&");
        sb2.append("k_ft8");
        sb2.append("=");
        sb2.append(o60.e.g("k_ft8"));
        String f13 = f(sb2.toString());
        sb2.append("&");
        sb2.append("vf");
        sb2.append("=");
        sb2.append(f13);
        String str4 = org.qiyi.video.module.download.exbean.a.f69256e + sb2.toString();
        wx0.b.i("IfaceGetDownloadVRSInfo", "dataRate: " + c12);
        wx0.b.i("IfaceGetDownloadVRSInfo", str4);
        return str4;
    }
```

```
    private static String f(String str) {
        try {
            return ProtectWrapper.getQdvf(QyContext.getAppContext(), str, QYReactConstants.APP_IQIYI);
        } catch (UnsatisfiedLinkError e12) {
            l.a(e12);
            return "";
        }
    }
  ```

```
apktool d file.apk 
go to folder libs 

find . -name "*.so" -exec sh -c 'echo "File: {}"; nm -D {} | grep "Qdvf"' ;
=> libprotect.so

```

![](https://i.postimg.cc/ZRz7WKFj/Screenshot-2024-12-31-at-9-04-08-PM.png)


