package cn.fightingguys.kaiheila.restful.request;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.client.http.HttpCall;
import cn.fightingguys.kaiheila.core.RabbitObject;

import java.util.concurrent.ExecutionException;

public abstract class RestAction extends RabbitObject {

    public RestAction(RabbitImpl rabbit) {
        super(rabbit);
    }

    public RestFuture submit() {
        return new RestFuture();
    }

    public HttpCall.Response execute() throws ExecutionException, InterruptedException {
        return submit().get();
    }

}
