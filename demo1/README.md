## springboot
前言：本教程以win10作为开发环境，以centos7.0作为生产环境。
### 1 开发环境
#### 1.1 IDE环境
安装一个好用的IDE吧
> IDEA
> 
> Ultimate version

地址：
https://www.jetbrains.com/idea/download/#section=windows

下载后安装IDEA，一路点击next即可。在激活页面，可以选择试用，或者是各显神通。如果是在校学生，持有学籍证明等信息，可以在官方申请免费使用的权利。
***

#### 1.2 java开发环境
安装一个jdk1.8吧，这样java程序就能跑啦。

jdk即Java Development Kit，用于开发java应用。
> 版本示例：Java SE 8u221
 
**tips:**
出于某种商业上的考量，java在1.5版本后推出了写作6.0实为1.6的版本，因此java1.8就是java8.0。

地址：
https://www.oracle.com/technetwork/java/javase/downloads/index.html

下载后安装java，一路点击next，在安装过程中留意自己jdk安装位置。配置环境变量时需要添加jdk的根目录路径。

**配置环境变量**
在控制面板中，以**类别**作为查看方式，选择**系统与安全**，再选择**系统**，选择左侧边栏最后的高级系统配置。选择**环境变量**。添加如下环境变量，示例：
> JAVA_HOME:
> D:\JDK
> 
> CLASSPATH:
> D:\JDK\lib\tools.jar
> 
> Path:
> D:\JDK\bin; D:\JDK\jre\bin

查看是否安装成功：
打开命令行窗口，输入java与javac命令查看是否出现有效信息。
![success](https://i.loli.net/2019/07/17/5d2ef702c375331626.png)

```
这里缺少图片
```
安装成功
***

#### 1.3 新建项目
打开idea，选择新建空白的Maven项目（当然Gradle项目也可以）。在Project SDK中选择jdk的根目录即可。选择下一步，按照提示填写GroupId与ArtificialId等相关信息。
>  GroupId是项目组织唯一的标识符，实际对应JAVA的包的结构，是main目录里java的目录结构。
> 示例：com.estheim.blog
> 
> 其中，estheim是项目持有者，blog是项目名。

> ArtificialId是项目的唯一的标识符，实际对应项目的名称，就是项目根目录的名称。
> 示例：myblog
> 
> myblog就是唯一的标识符。

> version指定了项目的当前版本，SNAPSHOT意为快照，说明该项目还处于开发中，是不稳定的版本。 
> 
> 示例：1.0-SNAPSHOT

> project name是项目的名称。
> project location是项目的位置。

新建项目完成。

### 2 正式开工
#### 2.1 配置Maven
打开pom.xml文件

##### 2.1.1 添加springboot框架
```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
    </parent>
```

##### 2.1.2 添加相关依赖
添加dependencies标签如下：
```
<dependencies>
    ......[在此位置复制以下Maven依赖信息]
</dependencies>
```
###### 2.1.2.1 web应用开发依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
###### 2.1.2.2 开发工具依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
```
###### 2.1.2.3 测试工具依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
###### 2.1.2.4 数据库相关
a.jdbc驱动

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
```
b.mariaDb依赖
```
        <dependency>
            <groupId>org.mariadb.jdbc</groupId>
            <artifactId>mariadb-java-client</artifactId>
            <version>2.2.5</version>
        </dependency>
```
**tips：**
mariadb是mysql开发者Michael在mysql被Oracle收购后担心mysql被闭源而开发的一款替代mysql的mysql产品，使用了与mysql完全接口，但重构了底层与内部逻辑，性能优于非定制版的mysql。

###### 2.1.2.5 mybatis相关
**tips：**
MyBatis是支持定制化SQL、存储过程以及高级映射的优秀的持久层框架。
```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
```

###### 2.1.2.6 安全/权限相关
**Spring Security**

**！这个部分先注释掉**
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
**Token(JJWT)**
```
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.6.0</version>
        </dependency>
```
**Jasypt** **加密解密**
```
        <dependency>
            <groupId>org.jasypt</groupId>
            <artifactId>jasypt</artifactId>
            <version>1.9.2</version>
        </dependency>
```
###### 2.1.2.7 数据格式
```
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
        </dependency>
```
###### 2.1.2.8 数据库连接池
```
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.29</version>
        </dependency>
```

##### 启动maven
`Reimport pom.xml`
maven会开始将依赖安装到本地项目。
```
这里缺少图片
```

#### 2.2 配置Springboot项目
##### 2.2.1 基础结构
**检视项目目录**
```
myblog/ >   pom.xml
        >   src/    >   main/   >   java/
                                >   resource/
                    >   test/
```
在resource/目录下添加如下目录与文件
```
resource/   >   static/     >   index.html
            >   mybatis/    >   mapper/
                            >   mybatis-config.xml
            >   application.yml
```
application.yml
```
server:
  port: 8888
  session:
    timeout: 10
  tomcat:
    uri-encoding: utf-8

spring:
  datasource:
    url: jdbc:mariadb://127.0.0.1:3306/eblog
    username: root
    password: [你的数据库用户的密码]
    driver-class-name: org.mariadb.jdbc.Driver
    tomcat:
      max-idle: 5
      max-wait: 2000
      min-idle: 1
      initial-size: 3
  mvc:
    view:
      prefix: /
      suffix: .html
  thymeleaf:
    enabled: false

# mybatis config
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
  type-aliases-package: com.myblog.Entity

```
index.html
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
</body>
</html>
```
mybatis-config.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias alias="Integer" type="java.lang.Integer" />
        <typeAlias alias="Long" type="java.lang.Long" />
        <typeAlias alias="HashMap" type="java.util.HashMap" />
        <typeAlias alias="LinkedHashMap" type="java.util.LinkedHashMap" />
        <typeAlias alias="ArrayList" type="java.util.ArrayList" />
        <typeAlias alias="LinkedList" type="java.util.LinkedList" />
    </typeAliases>
</configuration>
```


在java/目录下新建如下目录与文件
```
java/   >   com.estheim.myblog  >   Controller/
                                >   Config/
                                >   Entity/
                                >   Mapper/
                                >   Security/
                                >   Utils/
                                >   Application.java
                                >   ServletInitializer.java
```
Application.java
```
package com.estheim.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.estheim.blog.Mapper")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
```
ServletInitializer.java
```
package com.estheim.myblog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
}
```

##### 2.2.2 基础结构说明
**检视项目目录**
```
myblog/ >   pom.xml                                 # Maven配置文件
        >   src/    >   main/   >   java/           # java文件位置
                                >   resource/       # 其他文件位置
                    >   test/                       # 测试目录
```
```
resource/   >   static/     >   index.html          # 空白html文件
            >   mybatis/    >   mapper/             # mybatis文件位置
                            >   mybatis-config.xml  # mybatis配置文件
            >   application.yml                     # springboot项目配置文件
```
```
java/   >   com.estheim.myblog  >   Controller/     # 控制器类目录
                                >   Config/         # 配置类目录
                                >   Entity/         # 实体类目录
                                >   Mapper/         # 映射接口目录
                                >   Security/       # 权限相关目录
                                >   Utils/          # 工具类目录
                                >   Application.java            # 启动入口
                                >   ServletInitializer.java     # 嵌入式Servlet容器
```
#### 2.3 数据库
在进行接下来2.4的工作前，请确保投入使用的数据库能够访问成功。

#### 2.4 先走一套简易程序熟悉一下
在这个部分，我们先以**显示一篇文章**为例展示springboot编写的web应用后端的基本情形。
图示
```
此处缺少图片
```

##### 2.4.1 数据库相关
在数据库中新建数据库Myblog。
在Myblog中新建表Article。
```
> CREATE DATABASE Myblog;
Query OK, 1 row affected (0.00 sec)

> CREATE TABLE Article(
    article_id INT UNSIGNED AUTO_INCREMENT,
    article_title VARCHAR(100) NOT NULL,
    article_author VARCHAR(40) NOT NULL,
    article_content VARCHAR(200) NOT NULL,
    PRIMARY KEY (article_id)
);
```

随便写入一条数据
```
INSERT INTO Article(article_title, article_author, article_content)VALUES('FIREST', 'ESTHEIM', 'LALLALA');
```
确保录入成功
```
MariaDB [myblog]> select * from article;
+------------+---------------+----------------+-----------------+
| article_id | article_title | article_author | article_content |
+------------+---------------+----------------+-----------------+
|          1 | FIREST        | ESTHEIM        | LALLALA         |
+------------+---------------+----------------+-----------------+
1 row in set (0.00 sec)
```

完成

##### 2.4.2 实体类相关
这个部分是实体类，用作一种数据结构，用于实例化存放对应结构的数据。
例如Article.java这个类就用于被实例化后存储有着相同结构的数据。

java/Entity/

Article.java
```
package com.eblog.Entity.Article;

public class Article {
    private int article_id;
    private String article_title;
    private String article_author;
    private String article_content;

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", article_author='" + article_author + '\'' +
                ", article_content='" + article_content + '\'' +
                '}';
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Article(int article_id, String article_title, String article_author, String article_content) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_author = article_author;
        this.article_content = article_content;
    }
}
```
完成

##### 2.4.3 Mapper相关
这是一个抽象接口，通过读取mybatis文件获取
java/Mapper/

ArticleMapper.java
```
package com.eblog.Mapper.ArticleMapper;

@Mapper
public interface UserMapper {
    Article getArticle(int article_id);
}
```


##### 2.4.4 mybatis相关
先是简单说明
> resultMap标签
> 
> 可以理解为是一个装数据的结构。
> 
> 标签中有如下几个属性，id用于指示该resultMap的唯一标识，type用于指示该resultMap的数据类型。
> 标签内有id标签。id标签内包含column属性，用于对应数据库中的对应的行数，property标签用于对应springboot项目中的对应的数据名称。jdbcType属性用于指示数据类型。

**示例：**
```
    <resultMap id="Article" type="com.estheim.myblog.Entity.Article">
        <id column="article_id" property="article_id" jdbcType="INTEGER"/>
        <id column="article_title" property="article_title" jdbcType="VARCHAR"/>
        <id column="article_author" property="article_author" jdbcType="VARCHAR"/>
        <id column="article_content" property="article_content" jdbcType="VARCHAR"/>
    </resultMap>
```

> select标签
> 
> select标签，指示select语法，用于获取数据库数据。
> 其中标签内的id属性是该条select语句的唯一标识，resultMap指示将select所获得的数据映射到哪一个结构中。
> 其中#{}中是填充的是变量，是通过方法传入的外部值。

**示例：**
```
    <select id="getArticle" resultMap="Article">
        SELECT
            article_id, article_title, article_author, article_content
        FROM
            article
        WHERE
            article_id=#{article_id}
    </select>
```

**文件**

resources\mybatis\mapper\

ArticleMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.eblog.Mapper.ArticleMapper.xml">
    <!--上面这里namespace需要配置，配置即是Mapper下对应的Mapper.java-->

    <resultMap id="Article" type="com.eblog.Entity.Article">
        <id column="article_id" property="article_id" jdbcType="INTEGER"/>
        <id column="user_password" property="user_password" jdbcType="VARCHAR"/>
    </resultMap>

    <select id="getArticle" resultMap="Article">
        SELECT
            article_id, article_title, article_author, article_content
        FROM
            article
        WHERE
            article_id=#{article_id}
    </select>
</mapper>
```
完成

##### 2.4.5 控制器相关
**几个注解：**
> @RestController
> 
> @RequestMapping
> 
> @Autowired
> 
> @ModelAttribute

示例代码：
```
@RestController // 使用json作为前后端传递的数据的结构
@RequestMapping(value = "/visitor", method = RequestMethod.POST) // 
public class ArticleController {

    @Autowired // 自动装配Bean注解
    private ArticleMapper articleMapper;

    // 测试
    @PostMapping("/hello")
    public String testHello(){
        return "hello";
    }

    // 测试article数据获取
    @PostMapping("/article")
    public Article testHello(@ModelAttribute("article_id")String article_id){
        Article article;
        article=articleMapper.getArticle(Integer.parseInt(article_id));
        return article;
    }
}
```

##### 2.4.6 测试
启动springboot项目

打开POSTMAN

1.hello
> URL:127.0.0.1:8888/Article/hello

返回：
```
hello
```
2.article
> URL:127.0.0.1:8888/Article/article?article_id=1

返回：
```
{
    "article_id": 1,
    "article_title": "FIREST",
    "article_author": "ESTHEIM",
    "article_content": "LALLALA"
}
```

#### 2.5 更多
