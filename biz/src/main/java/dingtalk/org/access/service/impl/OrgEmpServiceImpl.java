package dingtalk.org.access.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.service.OrgDeptService;
import dingtalk.org.access.service.OrgEmpService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;
import dingtalk.org.access.vo.EmpSimpileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgEmpServiceImpl implements OrgEmpService {
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgEmpServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("EMP_LOGGER");
    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;
    @Resource
    private OrgService orgService;

    public ServiceResult<List<EmpSimpileVO>> getOrgEmpList(Long deptId) {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                LogFormatter.KeyValue.getNew("deptId", deptId)
        ));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/user/simplelist?access_token=" + accessToken + "&department_id=" + deptId;
            String empResult = httpRequestHelper.doHttpGet(url);
            JSONObject tokenObject = JSON.parseObject(empResult);
            Long errCode = tokenObject.getLong("errcode");
            if (null == errCode || errCode.intValue() != 0) {
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "获取部门下的用户简单信息列表失败",
                        LogFormatter.KeyValue.getNew("deptId", deptId)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            JSONArray empArr = tokenObject.getJSONArray("userlist");
            List<EmpSimpileVO> empList = JSONArray.parseArray(empArr.toJSONString(), EmpSimpileVO.class);
            return ServiceResult.success(empList);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    LogFormatter.KeyValue.getNew("deptId", deptId)
            ));
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }


    public ServiceResult<String> createEmp(OrgEmpService.CreateEmpVO createEmpVO) {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                LogFormatter.KeyValue.getNew("createEmpVO", JSON.toJSONString(createEmpVO))
        ));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/user/create?access_token=" + accessToken;
            String empResult = httpRequestHelper.httpPostJson(url, JSON.toJSONString(createEmpVO));
            JSONObject empObject = JSON.parseObject(empResult);
            Long errCode = empObject.getLong("errcode");
            if (null == errCode || errCode.intValue() != 0) {
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "创建员工失败失败",
                        LogFormatter.KeyValue.getNew("empObject", empObject)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String userId = empObject.getString("userid");
            return ServiceResult.success(userId);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    LogFormatter.KeyValue.getNew("createEmpVO", JSON.toJSONString(createEmpVO))
            ));
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}

