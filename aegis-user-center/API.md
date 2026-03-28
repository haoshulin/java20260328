# 接口文档说明

## 1. 新增用户
- **请求方式**：POST
- **URL**：`/api/user` (通过网关访问：`http://localhost:8082/api/user`)
- **参数**：(JSON Body)
  ```json
  {
    "username": "testuser",
    "password": "password123",
    "email": "test@example.com",
    "phone": "13800000000"
  }
  ```
- **返回值**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true
  }
  ```

## 2. 删除用户
- **请求方式**：DELETE
- **URL**：`/api/user/{id}` (通过网关访问：`http://localhost:8082/api/user/1`)
- **参数**：路径参数 `id` (用户ID)
- **返回值**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true
  }
  ```

## 3. 修改用户
- **请求方式**：PUT
- **URL**：`/api/user` (通过网关访问：`http://localhost:8082/api/user`)
- **参数**：(JSON Body)
  ```json
  {
    "id": 1,
    "username": "testuser_updated",
    "password": "newpassword123",
    "email": "updated@example.com",
    "phone": "13900000000"
  }
  ```
- **返回值**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true
  }
  ```

## 4. 用户查询（单个）
- **请求方式**：GET
- **URL**：`/api/user/{id}` (通过网关访问：`http://localhost:8082/api/user/1`)
- **参数**：路径参数 `id` (用户ID)
- **返回值**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "id": 1,
      "username": "testuser",
      "email": "test@example.com",
      "phone": "13800000000",
      "createTime": "2026-03-27T10:00:00",
      "updateTime": "2026-03-27T10:00:00"
    }
  }
  ```

## 5. 用户分页查询
- **请求方式**：GET
- **URL**：`/api/user/page` (通过网关访问：`http://localhost:8082/api/user/page`)
- **参数**：(Query参数)
  - `current`：当前页码（默认1）
  - `size`：每页大小（默认10）
- **返回值**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "total": 100,
      "records": [
        {
          "id": 1,
          "username": "testuser",
          "email": "test@example.com",
          "phone": "13800000000",
          "createTime": "2026-03-27T10:00:00",
          "updateTime": "2026-03-27T10:00:00"
        }
      ]
    }
  }
  ```