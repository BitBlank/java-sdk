# B.app Resource Storage SDK for Java


[![](https://jitpack.io/v/BitBlank/java-sdk.svg)](https://jitpack.io/#BitBlank/java-sdk)

> Any API detail, click [here](https://www.b.app/apidoc/prepair) and read more. 

## Add dependency

#### 1. For Gradle

**Step 1.** Add the JitPack repository to your build file

> Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        // Add this line at the end of repositories
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    implementation 'com.github.BitBlank:java-sdk:0.0.3'
}
```

#### 2. For Maven

**Step 1.** Add the JitPack repository to your build file

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** Add the dependency

```xml
<dependency>
    <groupId>com.github.BitBlank</groupId>
    <artifactId>java-sdk</artifactId>
    <version>0.0.3</version>
</dependency>
```

#### 3. For lib include only

Download [java-sdk-0.0.3.jar](../lib/java-sdk-0.0.3.jar). and add it in your project.

## Use in Java

> To visit your `AppKey` and `AppSecret`, you can click [here](https://mch.b.app/#/mch_info) and read more.

### Create order

```
Bapp.newInstance(yourAppKey, yourAppSecret).createOrder(
        OrderCreateBuilder.newBuilder()
                .setOrderId("ThisIsOrderId")
                .setAmount(1L)
                .setBody("Java-sdk sample")
                .setNotifyUrl("https://sdk.b.app/api/test/notify/test")
                .setReturnUrl("https://github.com")
                .build()
);
```

### Get order detail from the B.app server

```
Bapp.newInstance(yourAppKey, yourAppSecret).getOrder("ThisIsOrderId");
```

### Check the sign

```
Bapp.newInstance(appKey, appSecret).isSignOk(theParamMap);
```