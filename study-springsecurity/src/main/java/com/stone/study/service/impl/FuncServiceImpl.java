package com.stone.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.study.mapper.FuncMapperExt;
import com.stone.study.model.Func;
import com.stone.study.model.FuncExample;
import com.stone.study.service.FuncService;

@Service
public class FuncServiceImpl implements FuncService {
	@Autowired
	private FuncMapperExt funcMapper;

	@Override
	public List<Func> queryAll() {
		return funcMapper.selectByExample(new FuncExample());
	}

}
