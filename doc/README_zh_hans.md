# B.app Java SDK 源码


[![](https://jitpack.io/v/BitBlank/java-sdk.svg)](https://jitpack.io/#BitBlank/java-sdk)

> 详情资料, 请点击 [此处](https://www.b.app/apidoc/prepair) 了解更多信息。 

## 添加依赖

#### 1. Gradle方式引入

**Step 1.** 在您的构建文件添加 JitPack 支持

> 在根目录，添加以下依赖到末尾：

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

**Step 1.** 在您的构建文件添加 JitPack 支持

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** 添加Maven依赖

```xml
<dependency>
    <groupId>com.github.BitBlank</groupId>
    <artifactId>java-sdk</artifactId>
    <version>0.0.3</version>
</dependency>
```

#### 3. Jar包方式引入

下载 [java-sdk-0.0.3.jar](../lib/java-sdk-0.0.3.jar)，并在项目中引入。

## 在Java使用

> `AppKey` 和 `AppSecret` 的相关信息，请点击 [此处](https://mch.b.app/#/mch_info) 获取。

### 创建订单

```
Bapp.newInstance(yourAppKey, yourAppSecret).createOrder(
        OrderCreateBuilder.newBuilder()
                .setOrderId("您的订单ID")
                .setAmount(1L)
                .setBody("Java-sdk sample")
                .setNotifyUrl("https://sdk.b.app/api/test/notify/test")
                .setReturnUrl("https://github.com")
                .build()
);
```

### 从B.app服务端获取订单详情

```
Bapp.newInstance(yourAppKey, yourAppSecret).getOrder("您的订单ID");
```

### 签名验证

```
Bapp.newInstance(appKey, appSecret).isSignOk(theParamMap);
```