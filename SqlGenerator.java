package com.artboy.common.utils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xh
 * @Date 2023/5/14
 */
@Slf4j
public class SqlGenerator {

    //-1小写,1大写
    public static final int format = -1;
    /**
     * 用来存储Java等属性类型与sql中属性类型的对照
     * </br>
     * 例如：java.lang.Integer 对应 integer
     */
    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("boolean", "tinyint(1)");
        map.put("java.lang.Object", "varchar(255)");
        map.put("int", "int");
        map.put("short", "int");
        map.put("long", "bigint");
        map.put("float", "float");
        map.put("double", "double");
        map.put("char", "varchar(255)");
        map.put("java.lang.String", "varchar(255)");
        map.put("java.lang.Integer", "int");
        map.put("java.lang.byte[]", "blob");
        map.put("java.lang.Boolean", "bit");
        map.put("java.lang.Long", "integer unsigned");
        map.put("java.math.BigInteger", "bigint unsigned");
        map.put("java.lang.Float", "float");
        map.put("java.lang.Double", "float");
        map.put("java.sql.Date", "datetime");
        map.put("java.sql.Time", "time");
        map.put("java.sql.Timestamp", "datetime");
        map.put("java.util.Date", "datetime");
        map.put("java.lang.Byte", "tinyint");
        sqlConstruction();
    }

    /**
     * 生成sql建库语句
     */
    private static void sqlConstruction() {
        //实体类所在的package在磁盘上的绝对路径
        String packageName = "F:\\快速开发模板\\springboot-init-all\\springboot-common\\src\\main\\java\\com\\artboy\\common\\utils\\entity";
        //生成sql的文件夹
        String filePath = "F:\\sqlGen";
        //项目中实体类的路径
        String prefix = "com.artboy.common.utils.entity.";
        String className = "";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className, filePath);
            sqls.append(sql);
        }
        StringToSql(sqls.toString(), filePath + "\\entityToSql.sql");
    }

    /**
     * 根据实体类生成建表语句
     *
     * @param className 全类名
     * @param filePath  磁盘路径
     * @return
     */
    public static String generateSql(String className, String filePath) {
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            // 通过@TableName注解获取表名
            String value = clz.getAnnotation(TableName.class).value();
            if (!StringUtils.isEmpty(value)) {
                log.info("读取注解成功：{}", value);
                className = value;
            } else {
                // 表表名adminUser → tb_admin_user
                className = "tb_" + getStandardFields(className).toLowerCase();
            }
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            String varchar = " CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
            for (Field f : fields) {
                // 去掉包含TableField字段
                if(f.getAnnotation(TableField.class) != null && !f.getAnnotation(TableField.class).exist()) {
                    continue;
                }
                String typeName = f.getType().getName();
                // serialVersionUID
                if (f.getName().equals("serialVersionUID")) {
                    continue;
                }
                if (f.getAnnotation(TableId.class) != null) {
                    log.info("typeName : {}, filedName: {}", typeName, getStandardFields(f.getName()));
                    if("java.lang.Long".equals(typeName)) { // 默认主键自增
                        column.append(" \n `" + getStandardFields(f.getName()) + "` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,");
                    }
                    continue;
                }
                if ("java.lang.String".equals(typeName)) {
                    column.append(" \n `" + getStandardFields(f.getName()) + "`" + " " + map.get(typeName)).append(varchar);
                } else {
                    column.append(" \n `" + getStandardFields(f.getName()) + "`" + " " + map.get(typeName)).append(",");
                }
            }
            // 删除最后一个，
            column.deleteCharAt(column.lastIndexOf(","));
            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `" + className + "`; ")
                    .append(" \n CREATE TABLE `" + className + "`  (")
//                    .append(" \n `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,")
                    .append(column)
//                    .append(" \n PRIMARY KEY (`id`) USING BTREE,")
//                    .append("\n INDEX `id`(`id`) USING BTREE")
                    .append(" \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;\n");
            return sql.toString();
        } catch (ClassNotFoundException e) {
            log.info("该类未找到！");
            return null;
        }

    }

    /**
     * 转换为标准等sql字段 例如 adminUser → admin_user
     *
     * @param str 转换为字符串的字段名
     * @return
     */
    public static String getStandardFields(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i != 0 && (c > 'A' && c < 'Z')) {
                sb.append("_");
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 获取包下面等所有实体类名称，类似于获取 XXX.java
     *
     * @param packageName 全类名
     * @return
     */
    public static List<String> getAllClasses(String packageName) {
        List<String> classList = new ArrayList();
        String className = "";
        File f = new File(packageName);
        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            // 遍历实体类下面等所有.java文件 获取其类名
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        } else {
            log.info("包路径未找到！");
            return null;
        }
    }

    /**
     * 将生成等String字符串 写进sql文件
     *
     * @param str  String字符串
     * @param path sql文件路径路径
     */
    public static void StringToSql(String str, String path) {
        if (format < 0) {
            str = str.toLowerCase();
        } else {
            str = str.toUpperCase();
        }
        System.out.println(str);
        byte[] sourceByte = str.getBytes();
        FileOutputStream os = null;
        if (null != sourceByte) {
            try {
                //文件路径（路径+文件名）
                File file = new File(path);
                //文件不存在则创建文件，先创建目录
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                //文件输出流用于将数据写入文件
                os = new FileOutputStream(file);
                os.write(sourceByte);
                os.flush();
                System.out.println("生成成功!!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭文件输出流
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
