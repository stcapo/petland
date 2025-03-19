# 萌宠乐园管理平台

## 项目概述

萌宠乐园管理平台是一个用于管理宠物园区的综合性管理系统，包括用户管理、宠物管理、预约管理、商品销售、订单管理以及财务管理等功能。

## 技术栈

- 后端: Spring Boot 2.2.2
- 数据库: MySQL 5.7
- ORM: MyBatis
- 构建工具: Maven
- 前端: 静态 HTML + CSS + JavaScript (AJAX)

## 项目结构

```
D:\AA\pet_land_management
├── src/main/java/com/petland/
│   ├── controller/       # 控制器层
│   ├── service/          # 服务层
│   ├── repository/       # 数据访问层
│   ├── entity/           # 实体类
│   └── util/             # 工具类
├── src/main/resources/
│   ├── static/           # 静态资源
│   │   ├── css/          # 样式文件
│   │   ├── js/           # JavaScript文件
│   │   ├── admin/        # 管理员页面
│   │   ├── staff/        # 员工页面
│   │   └── user/         # 用户页面
│   ├── mapper/           # MyBatis映射文件
│   └── application.properties  # 应用配置文件
└── pom.xml               # Maven配置文件
```

## 主要功能

1. **用户管理**：用户注册、登录、权限管理
2. **宠物管理**：宠物信息管理、状态追踪
3. **预约管理**：入园预约、服务预订
4. **商品管理**：商品信息管理、库存管理
5. **订单管理**：订单创建、状态更新、查询
6. **财务管理**：收入记录、支出记录、财务统计

## 角色分类

- **管理员**：系统管理员，拥有所有权限
- **员工**：包括售票员、饲养员、客服等，具有有限的操作权限
- **用户**：普通用户，可以预约入园、购买商品等

## 启动步骤

1. 创建MySQL数据库，执行 `create_database.sql` 脚本创建表和初始数据
2. 修改 `application.properties` 文件中的数据库连接信息
3. 使用Maven构建项目：`mvn clean package`
4. 运行生成的jar包：`java -jar target/pet_land_management-0.0.1-SNAPSHOT.jar`
5. 访问 `http://localhost:8080` 进入系统

## 初始账号

- 管理员账号: admin / admin123
- 普通用户: 张三 / password123
- 员工账号: 赵六 / password123
