package github.kyrenesjtv.albertadmin.config.exception;

import org.springframework.util.StringUtils;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/28 17:21
 */
public class EntityExistException extends RuntimeException {

    public EntityExistException(Class clazz, String field, String val) {
        super(EntityExistException.generateMessage(clazz.getSimpleName(), field, val));
    }

    private static String generateMessage(String entity, String field, String val) {
        return StringUtils.capitalize(entity)
                + " with " + field + " "+ val + " existed";
    }

}
