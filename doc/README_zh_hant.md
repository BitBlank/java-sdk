# B.app Java SDK 源碼


[![](https://jitpack.io/v/BitBlank/java-sdk.svg)](https://jitpack.io/#BitBlank/java-sdk)

> 詳情資料, 請點擊 [此處](https://www.b.app/apidoc/prepair) 了解更多資訊。 

## 添加依賴

#### 1. Gradle方式引入

**Step 1.** 在您的構建文件添加 JitPack 支持

> 在根目錄，添加以下依賴到末尾：

```groovy
allprojects {
    repositories {
        // Add this line at the end of repositories
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** 添加gradle依赖

```groovy
dependencies {
    implementation 'com.github.BitBlank:java-sdk:0.0.3'
}
```

#### 2. Maven方式引入

**Step 1.** 在您的構建文件添加 JitPack 支持

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** 添加Maven依賴

```xml
<dependency>
    <groupId>com.github.BitBlank</groupId>
    <artifactId>java-sdk</artifactId>
    <version>0.0.3</version>
</dependency>
```

#### 3. Jar包方式引入

下載 [java-sdk-0.0.3.jar](../lib/java-sdk-0.0.3.jar)，並在項目中引入。

## 在Java使用

> `AppKey` 和 `AppSecret` 的相關資訊，請點擊 [此處](https://mch.b.app/#/mch_info) 獲取。

### 創建訂單

```
Bapp.newInstance(yourAppKey, yourAppSecret).createOrder(
        OrderCreateBuilder.newBuilder()
                .setOrderId("您的訂單ID")
                .setAmount(1L)
                .setBody("Java-sdk sample")
                .setNotifyUrl("https://sdk.b.app/api/test/notify/test")
                .setReturnUrl("https://github.com")
                .build()
);
```

### 從B.app服務端獲取訂單詳情

```
Bapp.newInstance(yourAppKey, yourAppSecret).getOrder("您的訂單ID");
```

### 簽名驗證

```
Bapp.newInstance(appKey, appSecret).isSignOk(theParamMap);
```