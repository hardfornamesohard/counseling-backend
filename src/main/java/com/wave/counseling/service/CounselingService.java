package com.wave.counseling.service;

import com.wave.counseling.model.CounselingBook;
import com.wave.counseling.web.Result;

/**
 * @author ziwei.huang
 * @date 2025/3/28 17:08
 */
public interface CounselingService {
    Result<String> book(CounselingBook book);
}
