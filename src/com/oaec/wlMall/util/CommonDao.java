package com.oaec.wlMall.util;



import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public/* abstract */class CommonDao/*<T>*/ extends JDBCutil {

    /**
     * 对任意表做增删改操作
     *
     * @return
     */
    public int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // 获取连接
            conn = getConnection();
            // 创建语句对象
            pstm = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                // 需要设置占位符
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            // 执行
            int i = pstm.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm, conn);
        }
        return 0;
    }

    public List<Map<String, Object>> query4MapList(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Map<String, Object>>list = new ArrayList<>();
        try {
            conn= getConnection();
            pstm = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            rs = pstm.executeQuery();
            //获取元数据
            ResultSetMetaData data = rs.getMetaData();


            int count = data.getColumnCount();

            String[] columNames =  new String[count];
            for (int i = 0; i < count; i++) {
                columNames[i]= data.getColumnName(i+1);
            }
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>() ;
                for (int i = 0; i < count; i++) {
                    String columName= columNames[i];
                    m.put(columName,rs.getObject(columName));
                }

                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,pstm, conn);
        }
        return list;
    }
    public Map<String, Object> query4Map(String sql, Object... params) {
        List<Map<String, Object>> list = query4MapList(sql, params);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
//    public<T> List<T> query4BeanList(String sql, EmDao<T> e1,Object... params) {
//
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        List<T> list = new ArrayList<>();
//        try {
//            conn = getConnection();
//            pstm = conn.prepareStatement(sql);
//            if (params != null && params.length > 0) {
//                for (int i = 0; i < params.length; i++) {
//                    pstm.setObject(i + 1, params[i]);
//                }
//            }
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                T t =  e1.getBeanFromResultSet(rs);
//                list.add(t);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            close(rs,pstm,conn);
//        }
//        return list;
//    }
//
//    public<T> T query4Bean(String sql,EmDao<T> e1, Object... params) {
//        List <T> list = query4BeanList(sql, e1, params);
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//    }

    public interface EmDao<T>{
        T getBeanFromResultSet(ResultSet rs) throws SQLException;
    }
//	 T getBeanFromResultSet(ResultSet rs) throws SQLException;
}
