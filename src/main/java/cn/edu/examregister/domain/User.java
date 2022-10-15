package cn.edu.examregister.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Binary cat
 * @date 2022/10/15 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "c_user")
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -7763992896801888254L;

    @TableId
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

}
