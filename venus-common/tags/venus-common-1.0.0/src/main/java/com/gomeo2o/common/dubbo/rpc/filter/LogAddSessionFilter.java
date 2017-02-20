package com.gomeo2o.common.dubbo.rpc.filter;

import org.slf4j.MDC;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.gomeo2o.common.constant.BaseConstants;

@Activate(group = Constants.CONSUMER, order = -10000)
public class LogAddSessionFilter implements Filter {

	@Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext.getContext().setAttachment(BaseConstants.LOG_SESSION_ID, MDC.get(BaseConstants.LOG_SESSION_ID));
		return invoker.invoke(invocation);
    }
}
