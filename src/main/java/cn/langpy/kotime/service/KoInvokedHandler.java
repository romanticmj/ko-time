package cn.langpy.kotime.service;

import cn.langpy.kotime.annotation.KoListener;
import cn.langpy.kotime.handler.InvokedHandler;
import cn.langpy.kotime.model.ExceptionNode;
import cn.langpy.kotime.model.MethodNode;
import cn.langpy.kotime.util.BoomFilter;
import cn.langpy.kotime.util.Common;
import cn.langpy.kotime.util.Context;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.logging.Logger;

@KoListener
public final class KoInvokedHandler implements InvokedHandler {
    private static Logger log = Logger.getLogger(KoInvokedHandler.class.toString());

    @Override
    public void onInvoked(MethodNode current, MethodNode parent, Parameter[] names, Object[] values) {
        GraphService graphService = GraphService.getInstance();
        graphService.addMethodNode(filter(parent));
        graphService.addMethodNode(filter(current));
        graphService.addMethodRelation(parent, current);
        if (Context.getConfig().getParamAnalyse()) {
            graphService.addParamAnalyse(current.getId(), names, values, current.getValue());
        }
        if (Context.getConfig().getLogEnable()) {
            Common.showLog(current);
        }
    }

    @Override
    public void onException(MethodNode current, MethodNode parent, ExceptionNode exception, Parameter[] names, Object[] values) {
        GraphService graphService = GraphService.getInstance();
        graphService.addMethodNode(current);
        graphService.addExceptionNode(exception);
        graphService.addExceptionRelation(current, exception);
    }

    public MethodNode filter(MethodNode currentNode) {
        if (BoomFilter.exists(currentNode.getId())) {
            return null;
        } else {
            BoomFilter.add(currentNode.getId());
            return currentNode;
        }
    }
}
