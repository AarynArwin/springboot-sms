

Springboot集成阿里云短信服务

1.[阿里云短信服务使用指引](https://help.aliyun.com/document_detail/59210.html?spm=5176.12207334.0.0.155e1cbea6BkkD)

2.根据指引开通服务后开始编写服务代码

3.添加maven依赖

```java
<!--阿里云短信通知依赖-->
        <!-- https://mvnrepository.com/artifact/com.aliyun/aliyun-java-sdk-core -->
        <dependency>
            <groupId>com.aliyun</groupId>
            <artifactId>aliyun-java-sdk-core</artifactId>
            <version>3.7.1</version>
        </dependency>

        <dependency>
            <groupId>com.aliyun</groupId>
            <artifactId>aliyun-java-sdk-dysmsapi</artifactId>
            <version>1.1.0</version>
        </dependency>
        <!--阿里云短信依赖json-->
        <!-- https://mvnrepository.com/artifact/org.json/json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20180130</version>
        </dependency>
```

4.