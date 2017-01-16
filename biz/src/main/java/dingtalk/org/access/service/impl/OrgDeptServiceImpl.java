package dingtalk.org.access.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.service.OrgDeptService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskRejectedException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgDeptServiceImpl implements OrgDeptService {
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgDeptServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("DEPT_LOGGER");
    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;
    @Resource
    private OrgService orgService;
    public ServiceResult<List<DeptSimpileVO>> getOrgDeptList(Long deptId) {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                LogFormatter.KeyValue.getNew("deptId", deptId)
        ));
        try{
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if(!tokenSr.isSuccess()){
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain()+"/department/list?access_token="+accessToken;
            String deptResult = httpRequestHelper.doHttpGet(url);
            JSONObject tokenObject = JSON.parseObject(deptResult);
            Long errCode = tokenObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "获取ORG 部门列表失败",
                        LogFormatter.KeyValue.getNew("deptId", deptId)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            JSONArray deptArr = tokenObject.getJSONArray("department");
            List<DeptSimpileVO> deptList = JSONArray.parseArray(deptArr.toJSONString(), DeptSimpileVO.class);
            return ServiceResult.success(deptList);
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    LogFormatter.KeyValue.getNew("deptId", deptId)
            ),e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }


    public ServiceResult<Long> createDept(CreateDeptVO createDeptVO) {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                LogFormatter.KeyValue.getNew("createDeptVO", JSON.toJSONString(createDeptVO))
        ));
        try{
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if(!tokenSr.isSuccess()){
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain()+"/department/create?access_token="+accessToken;
            String deptResult = httpRequestHelper.httpPostJson(url, JSON.toJSONString(createDeptVO));
            JSONObject tokenObject = JSON.parseObject(deptResult);
            Long errCode = tokenObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "创建部门失败",
                        LogFormatter.KeyValue.getNew("tokenObject", tokenObject)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }

            Long deptId = tokenObject.getLong("id");
            return ServiceResult.success(deptId);
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    LogFormatter.KeyValue.getNew("createDeptVO", JSON.toJSONString(createDeptVO))
            ),e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }

    }
}
