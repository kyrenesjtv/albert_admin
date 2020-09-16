package github.kyrenesjtv.albertadmin.config.annotation;

import java.lang.annotation.*;

/**
 * 标记匿名方法，无需登录就可以访问
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/23 21:01
 */
@Inherited
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {

}
