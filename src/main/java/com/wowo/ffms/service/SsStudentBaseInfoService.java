package com.wowo.ffms.service;


import com.wowo.ffms.constant.SsStudentBaseInfoConstants;
import com.wowo.ffms.dto.StudentDto;
import com.wowo.ffms.entity.SsStuInschoolInfo;
import com.wowo.ffms.entity.SsStuRelInfo;
import com.wowo.ffms.entity.SsStudentBaseInfo;
import com.wowo.ffms.utils.DateUtils;
import com.wowo.ffms.utils.EasyExcelUtils;
import com.wowo.ffms.utils.NumConstant;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述>
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
@Transactional
@Service
public class SsStudentBaseInfoService {



}
