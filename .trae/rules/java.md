所有代码必须符合企业开发规范：

- Controller 不写业务逻辑
- Service 处理业务逻辑
- Dao 只操作数据库
- 使用 DTO / VO 分层
- 统一返回结构（Result<T>）
- 接口必须有注释
你必须按照企业级微服务架构输出代码：


- 技术栈：
  - Spring Cloud Alibaba
  - Nacos 注册中心
  - Spring Cloud Gateway
  - MyBatis
  - 多数据源（Druid）
  - JWT 鉴权
  - React 前端

- 后端必须遵循分层结构：
  controller → service → dao → model

- 模块必须拆分：
  - api
  - app
  - dao
  - model
  - service
  - web
- 网关与微服务规则
  - 所有接口通过网关访问
  - 使用 lb:// 服务名 进行调用
  - 登录、注册接口加入白名单
  - WT 在网关统一校验
- 输出必须分模块：
1. 表结构（SQL）
2. Entity
3. DTO / VO
4. Mapper
5. Service
6. Controller
7. API（Feign接口）
8. 网关配置（如需要）

每部分必须说明作用
- 根据阿里最佳规范写代码