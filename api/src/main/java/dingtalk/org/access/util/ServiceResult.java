package dingtalk.org.access.util;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */

import java.io.Serializable;

/**
 *service层返回对象列表封装
 * @param <T>
 */
public class ServiceResult<T>  implements Serializable{

    private boolean success = false;

    private String code;

    private String message;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.code = "0";
        item.message = "success";
        return item;
    }


    public static <T> ServiceResult<T> failure(ErrorCode errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode.getErrCode();
        item.message = errorCode.getErrMsg();
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
