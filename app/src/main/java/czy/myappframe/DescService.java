package czy.myappframe;

import java.util.List;

import czy.myappframe.http.HttpResult;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by george on 2016/11/28.
 */

public interface DescService {
    @POST
    Observable<HttpResult<List<DescInfo>>> getdesc(@Body Request request);
}
