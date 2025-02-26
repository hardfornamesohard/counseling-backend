# counseling-backend
counseling后端仓库
Counseling.sql
```
首先是用户表，用户表id主键自增，需要有用户名name,加密过后的密码，secret，角色role（总共三种角色，学生，心理咨询师，管理员），邮箱email，昵称nickname，创建时间gmtCreated，修改时间gmtModified。以上是基本结构，下面是一些额外的约束，当用户发生修改时，数据库需要自动更新gmtModified字段，用户名字段增加一个唯一索引，secret，role，email，gmtCreated这几个字段必须非空
CREATE TABLE counseling_user (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 用户ID，主键，自增
    name VARCHAR(255) NOT NULL UNIQUE,                 -- 用户名，唯一，不可为空
    secret VARCHAR(255) NOT NULL,                      -- 加密后的密码，不可为空
    role TINYINT NOT NULL,                             -- 角色字段，使用TINYINT类型，不可为空
    email VARCHAR(255) NOT NULL,                       -- 邮箱，不可为空
    nickname VARCHAR(255),                             -- 昵称，可为空
    gmtCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 创建时间，默认当前时间，不可为空
    gmtModified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL -- 修改时间，自动更新
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

个人信息表：counseling_userinfo，主键id自增，用户头像avatar，存储头像路径，性别gender，年龄age，个性签名signature，爱好hobby，用户关联uid，不要设置外键索引，uid增加一个唯一索引约束，其他字段都可以是空的

```
CREATE TABLE counseling_userinfo (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 个人信息ID，主键，自增
    avatar VARCHAR(255),                               -- 用户头像路径，可为空
    gender TINYINT DEFAULT 0,                          -- 性别，使用TINYINT，0=男，1=女，2=其他，默认值为 0
    age INT,                                          -- 年龄，可为空
    hobby VARCHAR(255),                                -- 爱好，可为空
    signature VARCHAR(255),                            -- 个性签名，可为空
    uid INT NOT NULL,                                  -- 用户ID，关联用户表，非空
    CONSTRAINT unique_uid UNIQUE (uid)                 -- 用户ID（uid）唯一索引
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```
预约咨询表counseling_book:主键id自增，预约状态status，预约操作时间gmtCreated，预约时间counselDate，预约学生suid，被预约咨询师puid，咨询的主题topic，问题简述description
```
CREATE TABLE counseling_book (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 预约ID，主键，自增
    status TINYINT NOT NULL,                           -- 预约状态，使用TINYINT类型（例如：0=待处理，1=已确认，2=已取消等）
    gmtCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 预约操作时间，默认当前时间
    counselDate TIMESTAMP NOT NULL,                     -- 预约时间，使用TIMESTAMP类型
    suid INT NOT NULL,                                 -- 预约学生ID，不能为空
    puid INT NOT NULL,                                 -- 被预约咨询师ID，不能为空
    topic VARCHAR(255),                                -- 咨询主题，可以为空
    description TEXT                                  -- 问题简述，可以为空
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

咨询表，counsel_detail，存放咨询的情况，主键自增，咨询师puid，接受咨询的学生suid，实际咨询日期counselDate，咨询时长duration，咨询主题topic，咨询师建议suggestion，全部都需要非空，无需其他约束了

```
CREATE TABLE counsel_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,                -- 咨询详情ID，主键，自增
    puid INT NOT NULL,                                 -- 咨询师ID，不能为空
    suid INT NOT NULL,                                 -- 学生ID，不能为空
    counselDate TIMESTAMP NOT NULL,                    -- 实际咨询日期，不能为空
    duration INT NOT NULL,                             -- 咨询时长（分钟），不能为空
    topic VARCHAR(255) NOT NULL,                       -- 咨询主题，不能为空
    suggestion TEXT NOT NULL                           -- 咨询师建议，不能为空
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```
