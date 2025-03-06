package com.wave.counseling.model.handler;

import com.wave.counseling.model.Role;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Role.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class RoleTypeHandler extends BaseTypeHandler<Role> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Role role, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, role.getVal()); // 存储时转换为 int
    }

    @Override
    public Role getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return Role.fromValue(value); // 读取时转换为 Role
    }

    @Override
    public Role getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return Role.fromValue(value);
    }

    @Override
    public Role getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return Role.fromValue(value);
    }
}
