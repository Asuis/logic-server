package com.real.logicserver.meeting.service;

import com.real.logicserver.dto.Result;
import com.real.logicserver.meeting.model.UploadResult;

/**
 * @author asuis
 * 上传服务
 */
public interface CosUploadService {
    public Result<UploadResult> upload();
}
