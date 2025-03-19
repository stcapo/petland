-- 创建数据库
CREATE DATABASE IF NOT EXISTS petland CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 使用数据库
USE petland;

-- 用户表
CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    passwd VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL COMMENT '角色: user, admin, staff',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 管理员表
CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 员工表
CREATE TABLE IF NOT EXISTS staff (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    role VARCHAR(20) NOT NULL COMMENT '角色: 售票员, 饲养员, 客服等',
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 宠物表
CREATE TABLE IF NOT EXISTS pet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL COMMENT '状态: 展示中, 休息中, 生病, 繁殖中',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 预约表
CREATE TABLE IF NOT EXISTS reservation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    pet_id INT,
    type VARCHAR(20) NOT NULL COMMENT '类型: 入园预约, 服务预订',
    status VARCHAR(20) NOT NULL COMMENT '状态: 待确认, 已确认, 已完成, 已取消',
    reservation_time DATETIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (pet_id) REFERENCES pet(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品表
CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 订单表
CREATE TABLE IF NOT EXISTS `order` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL COMMENT '状态: 待支付, 已支付, 已取消',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 收入记录表
CREATE TABLE IF NOT EXISTS income_record (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES `order`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 支出记录表
CREATE TABLE IF NOT EXISTS expense_record (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(200) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入测试数据
-- 用户数据
INSERT INTO user (username, passwd, role) VALUES
('admin', 'admin123', 'admin'),
('张三', 'password123', 'user'),
('李四', 'password123', 'user'),
('王五', 'password123', 'user'),
('赵六', 'password123', 'staff'),
('钱七', 'password123', 'staff'),
('孙八', 'password123', 'staff');

-- 管理员数据
INSERT INTO admin (user_id) VALUES (1);

-- 员工数据
INSERT INTO staff (user_id, role) VALUES
(5, '售票员'),
(6, '饲养员'),
(7, '客服');

-- 宠物数据
INSERT INTO pet (name, type, status) VALUES
('小花', '猫咪', '展示中'),
('大黄', '狗狗', '展示中'),
('小白', '兔子', '休息中'),
('小灰', '仓鼠', '展示中'),
('小绿', '鹦鹉', '休息中'),
('小黑', '乌龟', '展示中');

-- 预约数据
INSERT INTO reservation (user_id, pet_id, type, status, reservation_time) VALUES
(2, 1, '入园预约', '已确认', '2025-03-20 10:00:00'),
(3, 2, '服务预订', '待确认', '2025-03-21 14:00:00'),
(4, 3, '入园预约', '已完成', '2025-03-19 09:00:00'),
(2, 4, '服务预订', '已取消', '2025-03-18 11:00:00');

-- 商品数据
INSERT INTO product (name, price, stock) VALUES
('萌宠零食包', 29.90, 100),
('宠物玩具套装', 99.00, 50),
('宠物护理用品', 79.50, 30),
('萌宠纪念照', 39.90, 999),
('宠物小屋', 199.00, 20);

-- 订单数据
INSERT INTO `order` (user_id, product_id, quantity, total_price, status) VALUES
(2, 1, 2, 59.80, '已支付'),
(3, 2, 1, 99.00, '待支付'),
(4, 3, 1, 79.50, '已支付'),
(2, 4, 3, 119.70, '已支付'),
(3, 5, 1, 199.00, '已取消');

-- 收入记录
INSERT INTO income_record (order_id, amount) VALUES
(1, 59.80),
(3, 79.50),
(4, 119.70);

-- 支出记录
INSERT INTO expense_record (description, amount) VALUES
('宠物饲料采购', 2000.00),
('设施维护费用', 1500.00),
('员工工资', 15000.00),
('水电费', 800.00),
('医疗用品', 1200.00);
