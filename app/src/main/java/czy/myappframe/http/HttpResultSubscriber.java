package czy.myappframe.http;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by george on 2016/11/28.
 */
public abstract class HttpResultSubscriber<T> extends Subscriber<HttpResult<T>> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof HttpException) {
            // ToastUtils.getInstance().showToast(e.getMessage());
        }
        _onError(e);
    }

    @Override
    public void onNext(HttpResult<T> t) {

        if (t.Success.equals("true")) {
            onSuccess(t.DataValue);
        } else {
            _onError(new Throwable("error=" + t.ErrorText));
        }


    }

    public abstract void onSuccess(T t);

    public abstract void _onError(Throwable e);
}