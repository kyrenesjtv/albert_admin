package github.kyrenesjtv.albertadmin.config.exception;

import org.springframework.util.StringUtils;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/28 17:21
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, String field, String val) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), field, val));
    }

    private static String generateMessage(String entity, String field, String val) {
        return StringUtils.capitalize(entity)
                + " with " + field + " "+ val + " does not exist";
    }

}
