package com.yzb.database.action;

import com.yzb.database.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: EchoAction
 * Description:
 * date: 2021/10/4 1:15
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class EchoAction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/echo")
    public String echo(String msg) {
        return "【ECHO】" + msg;
    }

    @GetMapping("/getStudents")
    public Object queryAll() {
        String sql = "select id,name,sex from student";
        List<StudentVO> studentVOS = jdbcTemplate.query(sql, new RowMapper<StudentVO>() {

            @Override
            public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentVO studentVO = new StudentVO();
                studentVO.setId(rs.getInt(1));
                studentVO.setName(rs.getString(2));
                studentVO.setSex(rs.getString(3));
                return studentVO;
            }

        });

        return studentVOS;
    }

    @GetMapping("/delete")
    public Object delete() {
        String sql = "DELETE FROM STUDENT";
        return this.jdbcTemplate.update(sql);
    }
}
